/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author Sofwan
 */
public interface Terarsip {
    String nomorRak();
    int lokasiLantai();
    
    /* default method */
    default String ringkasanArsip(){
        return "Rak " + nomorRak() + ", Lantai " + lokasiLantai();
    }
}
