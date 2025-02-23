/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Administrator;

/**
 *
 * @author Mafija
 */
public class AdminForma extends javax.swing.JFrame {

    /**
     * Creates new form AdminForma
     */
    public AdminForma(Administrator admin) {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPreetragaNFT2 = new javax.swing.JButton();
        btnPreetragaNFT4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPreetragaNFT2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnPreetragaNFT2.setText("Narudžbenica");
        btnPreetragaNFT2.setToolTipText("");
        btnPreetragaNFT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreetragaNFT2ActionPerformed(evt);
            }
        });

        btnPreetragaNFT4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnPreetragaNFT4.setText("NFT");
        btnPreetragaNFT4.setToolTipText("");
        btnPreetragaNFT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreetragaNFT4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPreetragaNFT4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPreetragaNFT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnPreetragaNFT4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPreetragaNFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreetragaNFT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreetragaNFT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreetragaNFT2ActionPerformed

    private void btnPreetragaNFT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreetragaNFT4ActionPerformed
        NFTForma nftf=new NFTForma();
        nftf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPreetragaNFT4ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPreetragaNFT2;
    private javax.swing.JButton btnPreetragaNFT4;
    // End of variables declaration//GEN-END:variables
}
