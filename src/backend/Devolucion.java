package backend;

import biblioteca.Prestamos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Devolucion extends javax.swing.JFrame {

    public Devolucion() {
        initComponents();
        java.util.Date fecha = new Date();
        parcearFecha(fecha);        
    }
    
    private void parcearFecha(Date fecha){
        String fechaArray[]=fecha.toString().split(" ");
        if(fechaArray[1].equals("Jan")){
            fechaArray[1]="01";
        }
        if(fechaArray[1].equals("Feb")){
            fechaArray[1]="02";
        }
        if(fechaArray[1].equals("Mar")){
            fechaArray[1]="03";
        }
        if(fechaArray[1].equals("Apr")){
            fechaArray[1]="04";
        }
        if(fechaArray[1].equals("May")){
            fechaArray[1]="05";
        }
        if(fechaArray[1].equals("Jun")){
            fechaArray[1]="06";
        }
        if(fechaArray[1].equals("Jul")){
            fechaArray[1]="07";
        }
        if(fechaArray[1].equals("Aug")){
            fechaArray[1]="08";
        }
        if(fechaArray[1].equals("Sep")){
            fechaArray[1]="09";
        }
        if(fechaArray[1].equals("Oct")){
            fechaArray[1]="10";
        }
        if(fechaArray[1].equals("Nov")){
            fechaArray[1]="11";
        }
        if(fechaArray[1].equals("Dec")){
            fechaArray[1]="12";
        }
        if(fechaArray[2].equals("Jan")){
            fechaArray[2]="01";
        }
        String fechaParceada=fechaArray[5]+"-"+fechaArray[1]+"-"+fechaArray[2];
        formartxtFecha.setText(fechaParceada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodLib = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        formartxtFecha1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        formartxtFecha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(149, 18, 7));
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Codigo del libro:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel1.add(txtCodLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 248, -1));

        jLabel2.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Carnet del estudiante:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(txtCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 248, -1));

        jLabel5.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Fecha de Prestamo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        formartxtFecha1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/mm/dd"))));
        jPanel1.add(formartxtFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 248, -1));

        jLabel6.setForeground(new java.awt.Color(250, 248, 128));
        jLabel6.setText("yyyy/mm/dd");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        formartxtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/mm/dd"))));
        jPanel1.add(formartxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 248, -1));

        jLabel3.setFont(new java.awt.Font("Nakula", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Fecha de devolucion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 216, 0));
        jLabel4.setText("yyyy/mm/dd");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jButton2.setText("Devolver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField formartxtFecha;
    private javax.swing.JFormattedTextField formartxtFecha1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtCodLib;
    // End of variables declaration//GEN-END:variables
}
