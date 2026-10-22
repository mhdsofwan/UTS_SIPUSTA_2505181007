/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author Sofwan
 */
/** Dilempar saat koleksi tidak memenuhi aturan layak pinjam. */
public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String pesan) {
        super(pesan);
    }
}