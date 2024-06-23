
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.Statement;
import proyectostock.repository.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class Venta {

    private Date fechaVenta;

    public Venta() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
    private int numVenta;
    private int codArticulo;
    private int cantidadVendida;

    public Venta(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Venta(Date fechaVenta, int numVenta, int codArticulo, int cantidadVendida) {
        this.fechaVenta = fechaVenta;
        this.numVenta = numVenta;
        this.codArticulo = codArticulo;
        this.cantidadVendida= cantidadVendida;
    }


       public void MostrarVentas(JTable paramTablaVenta){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaVenta.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Numero");
      modelo.addColumn("Fecha");
      modelo.addColumn("Cantidad");
      modelo.addColumn("Codigo Articulo");

      
      paramTablaVenta.setModel(modelo);
      
      sql = "SELECT * " +
      "FROM venta;";
      
      String[] datos = new String[8];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
 
          
             modelo.addRow(datos);
          } 
          
          paramTablaVenta.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }
       
       public void AgregarVenta(int paramCodArticulo, int paramCantidadVendida) {
        try {
            // Obtener la fecha actual
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date fechaVenta = new java.sql.Date(utilDate.getTime()); // Convierte a java.sql.Date

            int codArticulo = paramCodArticulo;
            int cantidadVendida = paramCantidadVendida;

            BaseRepository baseRepository = new BaseRepository();
            String consulta = "INSERT INTO ventas (fecha_venta, cod_articulo, cantidad_vendida) VALUES (?, ?, ?)";

            try (CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta)) {
                cs.setDate(1, fechaVenta); // Establecer la fecha como java.sql.Date
                cs.setInt(2, codArticulo);
                cs.setInt(3, cantidadVendida);
                cs.execute();
                JOptionPane.showMessageDialog(null, "Venta agregada con éxito");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al agregar venta: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido para el código del artículo o la cantidad");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.toString());
        }
    
    }
}