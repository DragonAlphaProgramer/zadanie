/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lufthansa;

/**
 *
 * @author PatrykK
 */
public class Artykul {
    private String tytul="",opis="",autor="";

    public Artykul(String autor, String tytul, String opis) {
        this.autor = autor;
        this.tytul=tytul;
        this.opis=opis;
    }

    public String getTytul() {
        return tytul;
    }

    public String getOpis() {
        return opis;
    }

    public String getAutor() {
        return autor;
    }
    
    
}
