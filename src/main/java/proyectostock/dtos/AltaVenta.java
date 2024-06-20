/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.dtos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proyectostock.controller.CargarVenta;
import proyectostock.controller.RellenarCombos;
import proyectostock.controller.RellenarFechas;
import proyectostock.entities.Articulo;
import proyectostock.entities.*;
import proyectostock.repository.*;


/**
 *
 * @author Huilen
 */
public class AltaVenta extends javax.swing.JFrame {
    
    RellenarCombos re = new RellenarCombos();
    public AltaVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        re.RellenarComboBox("articulo", "nombreArticulo", jComboBoxArticulo);
        txtcodigoArticulo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxFechaVenta = new javax.swing.JTextField();
        jTxNumVenta = new javax.swing.JTextField();
        jButtonCargarVenta = new javax.swing.JButton();
        jComboBoxArticulo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxCantidad = new javax.swing.JTextField();
        txtcodigoArticulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cargar una nueva venta:");

        jLabel1.setText("Número de Venta:");

        jLabel2.setText("Fecha:");

        jTxFechaVenta.setText("--/--/----");
        jTxFechaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxFechaVentaMouseClicked(evt);
            }
        });
        jTxFechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxFechaVentaActionPerformed(evt);
            }
        });

        jTxNumVenta.setEditable(false);
        jTxNumVenta.setText("numVenta");
        jTxNumVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxNumVentaActionPerformed(evt);
            }
        });

        jButtonCargarVenta.setText("Cargar venta");
        jButtonCargarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCargarVentaMouseClicked(evt);
            }
        });
        jButtonCargarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarVentaActionPerformed(evt);
            }
        });

        jComboBoxArticulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArticuloItemStateChanged(evt);
            }
        });
        jComboBoxArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxArticuloActionPerformed(evt);
            }
        });

        jLabel3.setText("Articulo:");

        jLabel5.setText("Cantidad:");

        jTxCantidad.setText("cantidad");
        jTxCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxCantidadMouseClicked(evt);
            }
        });
        jTxCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxCantidadActionPerformed(evt);
            }
        });

        txtcodigoArticulo.setEditable(false);
        txtcodigoArticulo.setText("codArt");

        jLabel6.setText("Stock Actual:");

        jTxStock.setEditable(false);
        jTxStock.setText("stock");
        jTxStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTxStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtcodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jButtonCargarVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTxNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxArticulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCargarVenta)
                    .addComponent(jButtonCerrar))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jTxNumVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxNumVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxNumVentaActionPerformed

    private void jButtonCargarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarVentaActionPerformed
        // TODO add your handling code here:
        jButtonCargarVenta.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ConfirmacionNuevaVenta newframe = new ConfirmacionNuevaVenta();
            int result = JOptionPane.showConfirmDialog(newframe,"Estas seguro que querés guardar la venta?", "Confirmación Guardado de Venta",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               //codigo si selecciona si;
            }else if (result == JOptionPane.NO_OPTION){
               //codigo si selecciona no;
            }
         }
        });
    }//GEN-LAST:event_jButtonCargarVentaActionPerformed

    private void jTxCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxCantidadActionPerformed

    private void jTxFechaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxFechaVentaMouseClicked
        // TODO add your handling code here:
        RellenarFechas rellenarFechas = new RellenarFechas();
        rellenarFechas.fechaActual(jTxFechaVenta);
    }//GEN-LAST:event_jTxFechaVentaMouseClicked

    private void jTxFechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxFechaVentaActionPerformed
 
    }//GEN-LAST:event_jTxFechaVentaActionPerformed

    private void jComboBoxArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxArticuloActionPerformed

    }//GEN-LAST:event_jComboBoxArticuloActionPerformed

    private void jComboBoxArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArticuloItemStateChanged
        // TODO add your handling code here:
       Articulo objetoArticulo = new Articulo();
       objetoArticulo.MostrarCodigoArticulo(jComboBoxArticulo, txtcodigoArticulo);
       
       CargarVenta objetoCargarVenta = new CargarVenta();
       objetoCargarVenta.MostrarStockArticulo(jComboBoxArticulo, jTxStock);

    }//GEN-LAST:event_jComboBoxArticuloItemStateChanged

    private void jTxStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxStockActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTxStockActionPerformed

    private void jTxCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxCantidadMouseClicked
        // TODO add your handling code here:
        jTxCantidad.setText("");
    }//GEN-LAST:event_jTxCantidadMouseClicked

    private void jButtonCargarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCargarVentaMouseClicked
        // comentado para probar el jopotiopane
   // ConfirmacionNuevaVenta newframe = new ConfirmacionNuevaVenta();
   // newframe.setVisible(true);    

            
    
    }//GEN-LAST:event_jButtonCargarVentaMouseClicked

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
            java.util.logging.Logger.getLogger(AltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarVenta;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JComboBox<String> jComboBoxArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTxCantidad;
    private javax.swing.JTextField jTxFechaVenta;
    private javax.swing.JTextField jTxNumVenta;
    private javax.swing.JTextField jTxStock;
    private javax.swing.JTextField txtcodigoArticulo;
    // End of variables declaration//GEN-END:variables


}
