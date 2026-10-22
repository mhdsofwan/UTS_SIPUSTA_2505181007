/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Sofwan
 */
public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();
    
    public void tambah(Koleksi koleksi) {
        if (koleksi == null) {
            throw new IllegalArgumentException("Koleksi tidak boleh kosong");
        }
        daftar.add(koleksi);
    }
    
    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }
    
    public void cetakStatus() {
        System.out.println("=== STATUS KOLEKSI PERPUSTAKAAN ===");
        for (Koleksi k : daftar ) {
            System.out.println(k.deskripsi());
            System.out.println("   Layak pinjam : " + (k.layakDipinjam() ? "Ya" : "Tidak"));
            System.out.println("   Lokasi       : " + k.infoLokasi());
        }
    }
}
