/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public class BerkasDigital extends Koleksi {
    private final int ukuranMB;
    private final String tautanUnduh;
    
    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit,
                            int ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }
    
    @Override
    public boolean layakDipinjam(){
        return true;
    }
    
    @Override
    public String deskripsi() {
        return super.deskripsi() + ", " + ukuranMB + " MB, unduh: " + tautanUnduh;
    }
    
    public int getUkuranMB() {
        return ukuranMB;
    }
    
    public String getTautanUnduh() {
        return tautanUnduh;
    }
}
