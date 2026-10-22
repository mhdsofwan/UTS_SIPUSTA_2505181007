/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import model.Koleksi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sofwan
 */
public class EksporKatalog {
    private static final String[] HEADER =
            {"Kode", "Jenis", "Judul", "Tahun", "Layak Pinjam", "Lokasi"};

    public void ekspor(List<Koleksi> daftar, String namaBerkas) throws IOException {
        // 1. Kumpulkan semua baris (header + data) sebagai teks
        List<String[]> baris = new ArrayList<>();
        baris.add(HEADER);
        for (Koleksi k : daftar) {
            baris.add(new String[] {
                k.getKodeKoleksi(),
                k.getClass().getSimpleName(),
                k.getJudul(),
                String.valueOf(k.getTahunTerbit()),
                k.layakDipinjam() ? "Ya" : "Tidak",
                k.infoLokasi()
            });
        }

        // 2. Hitung lebar tiap kolom dari teks terpanjang
        int[] lebar = new int[HEADER.length];
        for (String[] b : baris) {
            for (int i = 0; i < b.length; i++) {
                lebar[i] = Math.max(lebar[i], b[i].length());
            }
        }

        // 3. Tulis ke berkas; aliran ditutup otomatis oleh try-with-resources
        try (BufferedWriter out = Files.newBufferedWriter(
                Paths.get(namaBerkas), StandardCharsets.UTF_8)) {

            out.write(formatBaris(baris.get(0), lebar));
            out.newLine();
            out.write(garis(lebar));
            out.newLine();

            for (int r = 1; r < baris.size(); r++) {
                out.write(formatBaris(baris.get(r), lebar));
                out.newLine();
            }
        }
    }

    private String formatBaris(String[] kolom, int[] lebar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kolom.length; i++) {
            sb.append(String.format("%-" + lebar[i] + "s", kolom[i]));
            if (i < kolom.length - 1) {
                sb.append("  ");   // jarak antar kolom
            }
        }
        return sb.toString();
    }

    private String garis(int[] lebar) {
        int total = (lebar.length - 1) * 2;
        for (int w : lebar) {
            total += w;
        }
        return "-".repeat(total);
    }
}
