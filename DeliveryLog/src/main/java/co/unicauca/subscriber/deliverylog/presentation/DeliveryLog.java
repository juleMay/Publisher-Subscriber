/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.subscriber.deliverylog.presentation;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.subscriber.deliverylog.infra.ISubscriber;
import co.unicauca.subscriber.deliverylog.infra.RabbitListener;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ahurtado
 */
public class DeliveryLog extends javax.swing.JFrame implements ISubscriber {
    /**
     * Creates new form DeliveryLog
     */
    public DeliveryLog() {
        initComponents();
        Runnable subscriber = new RabbitListener(this);
        new Thread(subscriber).start();
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
        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        scrollPane.setBounds(360, 50, 400, 200);
        jPanel1.add(scrollPane);

        jTable1 = new JTable(
                new DefaultTableModel(new Object[][]{},
                        new String[]{ "Id", "Nombre", "Precio", "Dirección", "Ciudad", "Pais" }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
        scrollPane.setViewportView(jTable1);
        jTable1.getTableHeader().setBackground(Color.WHITE);
        jTable1.getTableHeader().setReorderingAllowed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pedidos para entrega");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);


        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliveryLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(String msg) {
      Gson gson = new Gson();
      Delivery deliveryEntity = gson.fromJson(msg, Delivery.class);
      Object[] element = new Object[]{deliveryEntity.getProduct().getProductId(),deliveryEntity.getProduct().getName(),
      deliveryEntity.getPrice(),deliveryEntity.getAddress(),deliveryEntity.getCity(),deliveryEntity.getCountryCode()};
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
      model.addRow(element);
        try {
            FileWriter file = new FileWriter(getBaseFilePath()+"output.json",true);
            gson.toJson(deliveryEntity, file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Elemento " + "Id: " + deliveryEntity.getProduct().getProductId() + ", Nombre: " + deliveryEntity.getProduct().getName() +
                ", Precio: " + deliveryEntity.getPrice() + ", Dirección de destino: " + deliveryEntity.getAddress() +
                ", Ciudad: " + deliveryEntity.getCity() + ", País: " + deliveryEntity.getCountryCode() + " agregado al registro");
    }
    private static String getBaseFilePath() {
        String path = DeliveryLog.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();

            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
        }
        return path;
    }
}