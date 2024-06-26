
package proyectostock.dtos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import proyectostock.controller.CargarVenta;
import proyectostock.controller.RellenarCombos;
import proyectostock.controller.RellenarFechas;
import proyectostock.entities.Articulo;
import proyectostock.entities.Venta;
public class AltaVenta extends javax.swing.JFrame {
    
    RellenarCombos re = new RellenarCombos();
    public AltaVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        Venta objetoVenta = new Venta();
        objetoVenta.MostrarVentas(jTableVentas);
        limpiar();
        re.RellenarComboBox("articulo", "nombreArticulo", jComboBoxArticulo);
        txtCodArticulo.setVisible(true);

    
    }
    void limpiar (){
    t_FechaVenta.setText("");
    t_cantidad.setText("");
  
            }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_FechaVenta = new javax.swing.JTextField();
        txtNumVenta = new javax.swing.JTextField();
        jButtonCargarVenta = new javax.swing.JButton();
        jComboBoxArticulo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_cantidad = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cargar una nueva venta:");

        jLabel1.setText("Número de Venta:");

        jLabel2.setText("Fecha:");

        t_FechaVenta.setText("yyyy/MM/dd");
        t_FechaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_FechaVentaMouseClicked(evt);
            }
        });
        t_FechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_FechaVentaActionPerformed(evt);
            }
        });

        txtNumVenta.setEditable(false);
        txtNumVenta.setText("numVenta");
        txtNumVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumVentaActionPerformed(evt);
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

        t_cantidad.setText("cantidad");
        t_cantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cantidadMouseClicked(evt);
            }
        });
        t_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cantidadActionPerformed(evt);
            }
        });

        txtCodArticulo.setEditable(false);
        txtCodArticulo.setText("codArt");

        jLabel6.setText("Stock Actual:");

        jTxStock.setEditable(false);
        jTxStock.setText("stock");
        jTxStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxStockActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Listado de ventas:");

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Numero de Venta", "Fecha de venta", "Articulo", "Cantidad vendida"
            }
        ));
        jTableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVentas);

        jLabel8.setText("codArt:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(t_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(txtNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(38, 38, 38)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t_FechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jTxStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 46, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jButtonCargarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_FechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jTxStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCargarVenta)
                            .addComponent(jButtonCerrar))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void txtNumVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumVentaActionPerformed

    private void jButtonCargarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarVentaActionPerformed
    jButtonCargarVenta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConfirmacionNuevaVenta newframe = new ConfirmacionNuevaVenta();
            int result = JOptionPane.showConfirmDialog(newframe, "¿Estás seguro que quieres guardar la venta?",
                    "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                // Código si selecciona "Sí"
              Venta objetoVenta = new Venta();
              objetoVenta.AgregarVenta(t_FechaVenta, txtCodArticulo, t_cantidad);
              objetoVenta.MostrarVentas(jTableVentas);
        // Llamar a ActualizarStock después de agregar la venta
        int codigoTipoArticulo = Integer.parseInt(txtCodArticulo.getText().trim());
        int cantidadVendida = Integer.parseInt(t_cantidad.getText().trim());
        objetoVenta.actualizarStockArticulo(codigoTipoArticulo, cantidadVendida);

            } else if (result == JOptionPane.NO_OPTION) {
                // Código si selecciona "No"
               
            }
        }
    });         
          
    }//GEN-LAST:event_jButtonCargarVentaActionPerformed
    private void t_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cantidadActionPerformed
        t_cantidad.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_t_cantidadActionPerformed

    private void t_FechaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_FechaVentaMouseClicked
        RellenarFechas rf = new RellenarFechas();
        rf.fechaActual(t_FechaVenta);
    }//GEN-LAST:event_t_FechaVentaMouseClicked

    private void t_FechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_FechaVentaActionPerformed

        
        t_FechaVenta.transferFocus();
    }//GEN-LAST:event_t_FechaVentaActionPerformed

    private void jComboBoxArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxArticuloActionPerformed

    }//GEN-LAST:event_jComboBoxArticuloActionPerformed

    private void jComboBoxArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArticuloItemStateChanged
        // TODO add your handling code here:
       Articulo objetoArticulo = new Articulo();
       objetoArticulo.MostrarCodigoArticulo(jComboBoxArticulo, txtCodArticulo);
       
       CargarVenta objetoCargarVenta = new CargarVenta();
       objetoCargarVenta.MostrarStockArticulo(jComboBoxArticulo, jTxStock);

    }//GEN-LAST:event_jComboBoxArticuloItemStateChanged

    private void jTxStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxStockActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTxStockActionPerformed

    private void t_cantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cantidadMouseClicked
        // TODO add your handling code here:
        t_cantidad.setText("");
    }//GEN-LAST:event_t_cantidadMouseClicked

    private void jButtonCargarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCargarVentaMouseClicked
        // comentado para probar el jopotiopane
   // ConfirmacionNuevaVenta newframe = new ConfirmacionNuevaVenta();
   // newframe.setVisible(true);    

            
    
    }//GEN-LAST:event_jButtonCargarVentaMouseClicked

    private void jTableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVentasMouseClicked
        Venta objetoVenta = new Venta();
        objetoVenta.MostrarVentas(jTableVentas);  
    }//GEN-LAST:event_jTableVentasMouseClicked

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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVentas;
    private javax.swing.JTextField jTxStock;
    private javax.swing.JTextField t_FechaVenta;
    private javax.swing.JTextField t_cantidad;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtNumVenta;
    // End of variables declaration//GEN-END:variables

    private void AgregarVenta(int codArticulo, int cantidadVendida) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limpiarCampos() {
     //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   


}
