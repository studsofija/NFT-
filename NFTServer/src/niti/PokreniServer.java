/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mafija
 */
public class PokreniServer extends Thread{
    
    ServerskaForma sf;

    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss=new ServerSocket(9000);
            sf.serverJePokrenut();
            
            while (true) {                
                Socket s=ss.accept();
                System.out.println("Klijent se povezao!");
                ObradaKlijentskogZahteva okz=new ObradaKlijentskogZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
            sf.serverNijePokrenut();
        }
    }
    
    
}
