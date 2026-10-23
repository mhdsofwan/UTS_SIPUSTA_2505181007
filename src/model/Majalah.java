/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public class Majalah extends Koleksi implements Terarsip{
    
    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;
    private final String nomorRak;
    private final int lokasiLantai;
    
    public Majalah (String kodeKoleksi, String judul, int tahunTerbit,
                            int edisi, String bulanTerbit, boolean edisiTerbaru, String nomorRak, int lokasiLantai){
    super(kodeKoleksi, judul, tahunTerbit);
    this.edisi = edisi;
    this.bulanTerbit = bulanTerbit;
    this.edisiTerbaru = edisiTerbaru;
    this.nomorRak = nomorRak;
    this.lokasiLantai = lokasiLantai;
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
    
    @Override
    public String infoLokasi() {
        return ringkasanArsip();   // default method dari interface Terarsip
    }
    
    @Override
    public String nomorRak() {
        return nomorRak;
    }
    
    
    @Override
    public int lokasiLantai() {
        return lokasiLantai;
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
