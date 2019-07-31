/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class RegistrarLibro extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarLibro
     */
    public RegistrarLibro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtEditorial = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCopias = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        txtCodigoNumeros = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoLetras = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(149, 18, 7));
        jPanel1.setForeground(new java.awt.Color(255, 126, 0));

        jLabel1.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Titulo:");

        jLabel4.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Cantidad de copias:");

        jLabel5.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Fecha de publicacion:");

        jLabel6.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Editorial:");

        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Campos con * son obligatorios");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtFecha.setText("Formato: yyyy/mm/dd");
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
        });

        txtCopias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCopiasKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 211, 255));
        jLabel11.setText("*");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 211, 255));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 211, 255));
        jLabel10.setText("*");

        txtCodigoNumeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoNumerosKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel7.setText("-");

        txtCodigoLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoLetrasKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 211, 255));
        jLabel8.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
        txtFecha.setText("");
    }//GEN-LAST:event_txtFechaMouseClicked

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed

    }//GEN-LAST:event_txtFechaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtCodigoLetras.getText().equals("") || txtCodigoNumeros.getText().equals("") || txtAutor.getText().equals("") || txtCopias.getText().equals("") || txtTitulo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Rellene campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else if(txtCodigoLetras.getText().length() != 3 || txtCodigoNumeros.getText().length() != 3){
            JOptionPane.showMessageDialog(null, "Escriba un codigo de libro valido", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            guardar();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigoLetrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoLetrasKeyTyped
        char c=evt.getKeyChar();

        if((c<'A' || c>'Z') || (txtCodigoLetras.getText().length()>2)) evt.consume();

    }//GEN-LAST:event_txtCodigoLetrasKeyTyped

    private void txtCodigoNumerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoNumerosKeyTyped
        char c=evt.getKeyChar();

        if((c<'0' || c>'9') || (txtCodigoNumeros.getText().length()>2)) evt.consume();

    }//GEN-LAST:event_txtCodigoNumerosKeyTyped

    private void txtCopiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCopiasKeyTyped
        char c=evt.getKeyChar();

        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtCopiasKeyTyped

    private void guardar(){
       String codigoN=txtCodigoNumeros.getText();
       String codigoL=txtCodigoLetras.getText();
       String autor=txtAutor.getText();
       String titulo=txtTitulo.getText();
       String copias=txtCopias.getText();
       String fecha=txtFecha.getText();
       String editorial=txtEditorial.getText();
       
        try {
            ObjectOutputStream guar = new ObjectOutputStream(new FileOutputStream("src/registros/libros/"+codigoN+"-"+codigoL+".bin"));
            guar.writeObject(codigoN);
            guar.writeObject(codigoL);
            guar.writeObject(autor);
            guar.writeObject(titulo);
            guar.writeObject(copias);
            guar.writeObject(fecha);
            guar.writeObject(editorial);
            
        } catch (IOException e) {
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCodigoLetras;
    private javax.swing.JTextField txtCodigoNumeros;
    private javax.swing.JTextField txtCopias;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
