/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Mafija
 */
public class NFT implements Serializable{
    private int id;
    private String naziv;
    private double osnovica;
    private String opis;
    
    private String status;
    private Valuta valuta;
    
    

    public NFT() {
    }

    public NFT(int id, String naziv, double osnovica, String opis, String status, Valuta valuta) {
        this.id = id;
        this.naziv = naziv;
        this.osnovica = osnovica;
        this.opis = opis;
        this.status = status;
        this.valuta = valuta;
    }


    /*
    public NFT(int id, String naziv, double osnovica, double cena, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.osnovica = osnovica;
        this.cena = cena;
        this.opis = opis;
    }
*/
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(double osnovica) {
        this.osnovica = osnovica;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    @Override
    public String toString() {
        return naziv ;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    
    
    
}
