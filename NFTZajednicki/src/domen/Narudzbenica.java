/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mafija
 */
public class Narudzbenica implements Serializable{
    private int id;
    private double cenaUkupno;
    private Date datumKreiranja;
    private boolean status;
    private Korisnik korisnik;
    

    public Narudzbenica() {
    }

    public Narudzbenica(int id, double cenaUkupno, Date datumKreiranja, boolean status, Korisnik korisnik) {
        this.id = id;
        this.cenaUkupno = cenaUkupno;
        this.datumKreiranja = datumKreiranja;
        this.status = status;
        this.korisnik = korisnik;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getCenaUkupno() {
        return cenaUkupno;
    }

    public void setCenaUkupno(double cenaUkupno) {
        this.cenaUkupno = cenaUkupno;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    
}
