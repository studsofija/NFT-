/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DbBroker;
import domen.Administrator;
import domen.NFT;
import domen.Valuta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mafija
 */
public class Kontroler {
    
    private static Kontroler instance;
    DbBroker dbb;
    
    ArrayList<Administrator> lista;
    
    private Kontroler(){
        dbb=new DbBroker();
        lista=new ArrayList<>();
        lista.add(new Administrator("admin", "admin", "admin", "admin"));
    }

    public static Kontroler getInstance() {
        if(instance==null){
            instance=new Kontroler();
        }
        return instance;
    }

    public Administrator proveriLoginAdmin(String korisnickoIme, String lozinka) {
        for (Administrator administrator : lista) {
            if(administrator.getKorisnickoIme().equals(korisnickoIme) && administrator.getLozinka().equals(lozinka)){
                return administrator;
            }
        }
        return null;
    }

    public ArrayList<NFT> vratiNFT() {
        dbb.otvoriKonekciju();
        ArrayList<NFT> lista=dbb.vratiNFT();
        dbb.zatvoriKonekciju();
        return lista;
    }

    public ArrayList<NFT> vratiNFTPoNazivu(NFT nftNaziv) {
        dbb.otvoriKonekciju();
        
        ArrayList <NFT> lista=dbb.vratiNFTPoNazivu(nftNaziv);
        dbb.zatvoriKonekciju();
        return lista;
    }

    public boolean sacuvajIzmeneNFT(ArrayList<NFT> listaIzmenaNFT) {
        boolean izmene=false;
        dbb.otvoriKonekciju();
        try {
            for (NFT nft : listaIzmenaNFT) {
                if(nft.getStatus().equals("NOVI")){
                        dbb.sacuvajNFT(nft);

                }
                if(nft.getStatus().equals("BURN")){
                    dbb.obrisiNFT(nft);
                }
            }
            dbb.commit();
            izmene=true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        }
        dbb.zatvoriKonekciju();
        return izmene;
    }

    public ArrayList<Valuta> vratiValute() {
        dbb.otvoriKonekciju();
        
        ArrayList<Valuta> lista=dbb.vratiValute();
        
        dbb.zatvoriKonekciju();
        return lista;
    }
    
}
