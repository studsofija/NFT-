/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.NFT;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mafija
 */
public class TableModelNFT extends AbstractTableModel{

    private ArrayList<NFT> lista;
    private String[] kolone= {"ID","Naziv","Osnovica", "Cena", "Opis","Status"};

    public TableModelNFT() {
        lista=new ArrayList<>();
    }

    public TableModelNFT(ArrayList<NFT> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
     @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NFT nft=lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return nft.getId();
            case 1: return nft.getNaziv();
            case 2: return nft.getOsnovica();
            case 3: return nft.getOpis();
            case 4: return nft.getStatus();
            default:
                return null;
        }
    }

    public ArrayList<NFT> getLista() {
        return lista;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Naziv";
            case 2: return "Osnovica";
            case 3: return "Opis";
            case 4: return "Status";
            default:
                return null;
        }   
    }
    
    public void dodajNFT(NFT nft){
        nft.setStatus("NOVI");
        lista.add(nft);
        fireTableDataChanged();
    } 

    public void obrisiNFT(int red) {
        int izbor = JOptionPane.showConfirmDialog(null, 
        "Da li ste sigurni da želite da obrišete NFT?", 
        "Potvrda promene statusa", 
        JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            NFT nft = lista.get(red);
            if(nft.getStatus().equals("NOVI")){
                lista.remove(nft);
            } else {
                lista.get(red).setStatus("BURN");
            }
            fireTableDataChanged();
        }   
    }
 
    
}
