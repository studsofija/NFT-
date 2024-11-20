/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mafija
 */
public class Konekcija {
    Connection connection;
    private static Konekcija instance;

    public Konekcija() {
        try {
            String url="jdbc:mysql://localhost:3306/nftmarketplace";
            connection=DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstance() {
        if(instance==null){  
            return instance;
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
    
    
    
}
