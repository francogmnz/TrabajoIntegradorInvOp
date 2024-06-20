/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Juan
 */
public class Proveedor {
    
    private String nombreProveedor;
    private int codProveedor;
    private int celular;
    private TipoArticulo tipoArticulo;
    private int diasDemora;

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getDiasDemora() {
        return diasDemora;
    }

    public void setDiasDemora(int diasDemora) {
        this.diasDemora = diasDemora;
    }

    public void MostrarProveedores(JTable paramTablaProveedores){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaProveedores.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Nombre");
      modelo.addColumn("Código");
      modelo.addColumn("Celular");

      
      paramTablaProveedores.setModel(modelo);
      
      sql = "SELECT proveedor.nombreProveedor, proveedor.codProveedor, proveedor.celular\n" +
      "FROM proveedor;";
      
      String[] datos = new String[8];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
 
          
             modelo.addRow(datos);
          } 
          
          paramTablaProveedores.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }
    
    
    public void AgregarProveedor(JTextField paramNombre, JTextField paramCodProveedor, JTextField paramNumContacto, JTextField idTipoArticulo, JTextField paramTiempoDemora) {
        try {
            String nombreProveedor = paramNombre.getText();
            int codProveedor = Integer.parseInt(paramCodProveedor.getText());
            int celular = Integer.parseInt(paramNumContacto.getText());
            int diasDemora = Integer.parseInt(paramTiempoDemora.getText());
            int codigoTipoArticulo = Integer.parseInt(idTipoArticulo.getText());

            BaseRepository baseRepository = new BaseRepository();
            String consulta = "INSERT INTO Proveedor (nombreProveedor, codProveedor, celular, tipoArticuloId, diasDemora) VALUES (?, ?, ?, ?, ?)";

            try (CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta)) {
                cs.setString(1, nombreProveedor);
                cs.setInt(2, codProveedor);
                cs.setInt(3, celular);
                cs.setInt(4, codigoTipoArticulo);
                cs.setInt(5, diasDemora);
                cs.execute();
                JOptionPane.showMessageDialog(null, "Proveedor agregado con éxito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar proveedor: " + e.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.toString());
        }
    }

    public void MostrarCodigoArticulo(JComboBox articuloCombo, JTextField idArticulo) {
        String consulta = "SELECT codArticulo FROM articulo WHERE nombreArticulo = ?";
        BaseRepository baseRepository = new BaseRepository();

        try (CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta)) {
            cs.setString(1, articuloCombo.getSelectedItem().toString());
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    idArticulo.setText(rs.getString("codArticulo"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar código de artículo: " + e.toString());
        }
    }
}