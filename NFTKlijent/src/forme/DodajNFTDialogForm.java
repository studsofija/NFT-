/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Valuta;
import java.util.ArrayList;
import konstante.Operacije;
import kontroler.Komunikacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Mafija
 */
public class DodajNFTDialogForm extends javax.swing.JDialog {

    /**
     * Creates new form DodajNFTDialogForm
     */
    public DodajNFTDialogForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        popuniValute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        Cena = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOpis = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        spinnerOsnovica = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cmbValuta = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Dodaj NFT");

        jLabel2.setText("Naziv");

        Cena.setText("Cena");

        jLabel4.setText("Unesi kratak opis ");

        btnDodaj.setText("DODAJ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel3.setText("Valuta");

        cmbValuta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbValuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbValutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(Cena)
                            .addComponent(txtNaziv)
                            .addComponent(txtOpis)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(spinnerOsnovica)
                            .addComponent(cmbValuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Cena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerOsnovica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnDodaj)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        String naziv=txtNaziv.getText();
        double cena=((Number) spinnerOsnovica.getValue()).doubleValue();
        Valuta valuta=(Valuta) cmbValuta.getSelectedItem();
        String opis=txtOpis.getText(); 
        
        NFTForma nftF=(NFTForma) getParent();
        nftF.unesiNoviNFT(naziv,cena,opis,valuta);        
    }//GEN-LAST:event_btnDodajActionPerformed

    private void cmbValutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbValutaActionPerformed

    }//GEN-LAST:event_cmbValutaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cena;
    private javax.swing.JButton btnDodaj;
    private javax.swing.JComboBox cmbValuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner spinnerOsnovica;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniValute() {
      KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.POPUNI_VALUTE, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        
        ArrayList<Valuta> lista=(ArrayList<Valuta>) so.getOdgovor();
        
        cmbValuta.removeAllItems();
        for (Valuta v : lista) {
            cmbValuta.addItem(v);
        }  
    }
    
    
}
