/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.NFT;
import domen.Valuta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mafija
 */
public class DbBroker {
    Connection konekcija;
    
    public void otvoriKonekciju(){
        try {
            konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/nftmarketplace", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ArrayList<Object> vrati(){
        ArrayList<Object> lista=new ArrayList<>();
        String upit="";
        
        try {
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            
            while(rs.next()){
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
  
    }
    
    boolean sacuvajIzmeniObrisi(){
        String upit="";
        try {
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
            try {
                Konekcija.getInstance().getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return false;
    }

    public ArrayList<NFT> vratiNFT() {
        try {
            String upit="SELECT * FROM nft";
            
            Statement s=konekcija.createStatement();
            ResultSet rs=s.executeQuery(upit);
            ArrayList<NFT> lista=new ArrayList<>();
            
            while (rs.next()) {                
                lista.add(new NFT(rs.getInt("idNFT"), rs.getString("nazivNFT"), rs.getDouble("osnovica"), rs.getString("opis"),"",new Valuta(rs.getInt("idValuta"),"")));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
        
    }

    public ArrayList<NFT> vratiNFTPoNazivu(NFT nftNaziv) {
        try {
            String upit="SELECT * FROM nft WHERE nazivNFT LIKE '%"+nftNaziv.getNaziv()+"%'";
            
            Statement s=konekcija.createStatement();
            ResultSet rs=s.executeQuery(upit);
            ArrayList<NFT> lista=new ArrayList<>();
            
            while (rs.next()) {                
                lista.add(new NFT(rs.getInt("idNFT"), rs.getString("nazivNFT"), rs.getDouble("osnovica"), rs.getString("opis"),"",null));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void sacuvajNFT(NFT nft) throws SQLException {
       String upit="INSERT INTO nft (nazivNFT,osnovica,opis,idValuta) VALUES (?,?,?,?)";
        
        PreparedStatement ps=konekcija.prepareStatement(upit);
        ps.setString(1, nft.getNaziv());
        ps.setDouble(2, nft.getOsnovica());
        ps.setString(3, nft.getOpis());
        ps.setInt(4, nft.getValuta().getId());
        
        ps.executeUpdate(); 
    }

    public void obrisiNFT(NFT nft) throws SQLException {
        String upit="DELETE FROM nft WHERE idNFT=?";
        
        PreparedStatement ps=konekcija.prepareStatement(upit);
        
        ps.setInt(1, nft.getId());
       
        ps.executeUpdate();
    }

    public ArrayList<Valuta> vratiValute() {
        ArrayList<Valuta> lista=new ArrayList<>();
        String upit="SELECT * FROM valuta";
        
        try {
            Statement st=konekcija.createStatement();
            ResultSet rs=st.executeQuery(upit);
            
            while (rs.next()) {                
                lista.add(new Valuta(rs.getInt("idValuta"), rs.getString("nazivValute")));
                
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
