/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public abstract class Koleksi {
    private final String kodeKoleksi;
    private final String judul;
    private final int tahunTerbit;
    
    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    
    public abstract boolean layakDipinjam();
    
    public String deskripsi() {
        return getClass().getSimpleName() + " " + kodeKoleksi
                + " \"" + judul + " \" (" + tahunTerbit + ")";
    }
    
    public String infoLokasi(){
        return "Tidak ada lokasi fisik";
    }
    
    
    public String getKodeKoleksi() {
        return kodeKoleksi;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public int getTahunTerbit() {
        return tahunTerbit;
    }
}