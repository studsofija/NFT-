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
public class Porez implements Serializable{
    
    private int id;
    private double stopa;
    private String naziv;

    public Porez() {
    }

    public Porez(int id, double stopa, String naziv) {
        this.id = id;
        this.stopa = stopa;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getStopa() {
        return stopa;
    }

    public void setStopa(double stopa) {
        this.stopa = stopa;
    }
    
    
}
