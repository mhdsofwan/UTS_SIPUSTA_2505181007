/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author Sofwan
 */
/** Dilempar saat koleksi yang diminta sedang dipinjam anggota lain. */
public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String pesan) {
        super(pesan);
    }
}