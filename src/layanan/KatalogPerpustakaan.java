/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sofwan
 */
public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();
    private final Set<String> sedangDipinjam = new HashSet<>();   // kode koleksi yang dipinjam

    public void tambah(Koleksi koleksi) {
        if (koleksi == null) {
            throw new IllegalArgumentException("Koleksi tidak boleh kosong");
        }
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    public void urut(Comparator<Koleksi> pembanding) {
        if (pembanding == null) {
            throw new IllegalArgumentException("Aturan pengurutan tidak boleh kosong");
        }
        daftar.sort(pembanding);
    }

    /** Mencari koleksi berdasarkan kode; null jika tidak ada. */
    private Koleksi cari(String kode) {
        for (Koleksi k : daftar) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);

        if (k == null) {
            throw new PustakaException(
                "Koleksi dengan kode " + kode + " tidak ditemukan di katalog. "
                + "Periksa kembali kode yang Anda masukkan.");
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                "Maaf, \"" + k.getJudul() + "\" (" + kode + ") belum bisa dipinjam saat ini, "
                + "karena sedang diperbaiki atau merupakan edisi terbaru yang hanya "
                + "boleh dibaca di perpustakaan.");
        }
        if (sedangDipinjam.contains(k.getKodeKoleksi())) {
            throw new KoleksiSedangDipinjamException(
                "Maaf, \"" + k.getJudul() + "\" (" + kode + ") sedang dipinjam anggota lain. "
                + "Silakan coba lagi setelah koleksi dikembalikan.");
        }

        sedangDipinjam.add(k.getKodeKoleksi());
        System.out.println("Berhasil: \"" + k.getJudul() + "\" (" + kode + ") berhasil dipinjam.");
    }

    /** Pelengkap supaya koleksi yang dipinjam bisa dikembalikan. */
    public void kembalikan(String kode) {
        Koleksi k = cari(kode);
        if (k != null && sedangDipinjam.remove(k.getKodeKoleksi())) {
            System.out.println("Berhasil: \"" + k.getJudul() + "\" (" + kode + ") sudah dikembalikan.");
        }
    }

    public void cetakStatus() {
        System.out.println("=== STATUS KOLEKSI PERPUSTAKAAN ===");
        for (Koleksi k : daftar) {
            System.out.println(k.deskripsi());
            System.out.println("   Layak pinjam : " + (k.layakDipinjam() ? "Ya" : "Tidak"));
            System.out.println("   Lokasi       : " + k.infoLokasi());
        }
    }
}