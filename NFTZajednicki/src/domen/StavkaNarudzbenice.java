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
public class StavkaNarudzbenice implements Serializable{
    private int redniBr;
    private double cena;
    private int kolicina;
    private NFT nft;
    private Porez porez;

    public StavkaNarudzbenice() {
    }

    public StavkaNarudzbenice(int redniBr, double cena, int kolicina, NFT nft, Porez porez) {
        this.redniBr = redniBr;
        this.cena = cena;
        this.kolicina = kolicina;
        this.nft = nft;
        this.porez = porez;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getRedniBr() {
        return redniBr;
    }

    public void setRedniBr(int redniBr) {
        this.redniBr = redniBr;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public NFT getNft() {
        return nft;
    }

    public void setNft(NFT nft) {
        this.nft = nft;
    }

    public Porez getPorez() {
        return porez;
    }

    public void setPorez(Porez porez) {
        this.porez = porez;
    }
    
    
}
