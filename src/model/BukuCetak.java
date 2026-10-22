/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public class BukuCetak extends Koleksi implements Terarsip {
    private final int jumlahHalaman;
    private final String nomorRak;
    private final int lokasiLantai;
    private final boolean sedangDiperbaiki;
    
    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit,
                     int jumlahHalaman,String nomorRak, int lokasiLantai, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lokasiLantai = lokasiLantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }
    
    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }
    
    @Override
    public String deskripsi() {
        return super.deskripsi() + ", " + jumlahHalaman + " halaman, rak " + nomorRak
                + (sedangDiperbaiki ? ", sedang diperbaiki" : ", tidak diperbaiki");
    }
    
    @Override
    public String nomorRak() {
        return nomorRak;
    }
    
    @Override
    public int lokasiLantai() {
        return lokasiLantai;
    }
    
    public int getJumlahHalaman() {
        return jumlahHalaman;
    }    
    
    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }
}
