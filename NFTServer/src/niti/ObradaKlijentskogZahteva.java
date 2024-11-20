/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Administrator;
import domen.NFT;
import domen.Valuta;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Mafija
 */
public class ObradaKlijentskogZahteva extends Thread{
    Socket s;

    public ObradaKlijentskogZahteva() {
    }

    public ObradaKlijentskogZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {            
            KlijentskiZahtev kz=primiZahtev();
            ServerskiOdgovor so= new ServerskiOdgovor();
            
            switch (kz.getOperacije()) {
                case Operacije.LOGIN_A:
                    Administrator admin=(Administrator) kz.getParametar();
                    Administrator ulogovaniAdmin=Kontroler.getInstance().proveriLoginAdmin(admin.getKorisnickoIme(), admin.getLozinka());
                    so.setOdgovor(ulogovaniAdmin);
                    break;
                case Operacije.VRATI_NFT:
                    ArrayList<NFT> listaNFT=Kontroler.getInstance().vratiNFT();
                    so.setOdgovor(listaNFT);
                    break;
                case Operacije.PRETRAZI_PO_NAZIVU:
                    NFT nftNaziv=(NFT) kz.getParametar();
                    ArrayList<NFT> NFTlista=Kontroler.getInstance().vratiNFTPoNazivu(nftNaziv);
                    so.setOdgovor(NFTlista);
                    break;
               case Operacije.SACUVAJ_NFT:
                    ArrayList<NFT>listaIzmenaNFT=(ArrayList<NFT>) kz.getParametar();
                    boolean izmena=Kontroler.getInstance().sacuvajIzmeneNFT(listaIzmenaNFT);
                    
                    if(izmena){
                        so.setPoruka("Uspesno sačuvano");
                    }else{
                        so.setPoruka("Pokušajte ponovo");
                    }
                    so.setUspesno(izmena);
                    break;
                case Operacije.POPUNI_VALUTE:
                    ArrayList<Valuta> listaValuta=Kontroler.getInstance().vratiValute();
                    so.setOdgovor(listaValuta);
                    break;
                    
            }
            
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
