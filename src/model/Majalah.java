/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public class Majalah extends Koleksi {
    
    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;
    
    public Majalah (String kodeKoleksi, String judul, int tahunTerbit,
                            int edisi, String bulanTerbit, boolean edisiTerbaru){
    super(kodeKoleksi, judul, tahunTerbit);
    this.edisi = edisi;
    this.bulanTerbit = bulanTerbit;
    this.edisiTerbaru = edisiTerbaru;
    }
    
    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }
    
    @Override
    public String deskripsi() {
        return super.deskripsi() + ", edisi" + edisi + " (" + bulanTerbit + ")"
                + (edisiTerbaru ? ", edisi terbaru" : ", bukan edisi terbaru");
    }
    
    public int getEdisi() {
        return edisi;
    }
    
    public String getBulanTerbit() {
        return bulanTerbit;
    }
    
    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }
}
