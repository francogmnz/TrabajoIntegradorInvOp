/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
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
public class OrdenCompra {
    
    private int numOrdenCompra;
    private Date fechaCreacionOC;
    private EstadoOrdenCompra estadoOrdenCompra;
    private Proveedor proveedor;
    private Articulo articulo;
    private int codEstadoOC;
    private int codProveedor;
    private int codArticulo;
    private int cantArticulosOC;

    public int getCodEstadoOC() {
        return codEstadoOC;
    }

    public void setCodEstadoOC(int codEstadoOC) {
        this.codEstadoOC = codEstadoOC;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    
    public int getNumOrdenCompra() {
        return numOrdenCompra;
    }

    public void setNumOrdenCompra(int numOrdenCompra) {
        this.numOrdenCompra = numOrdenCompra;
    }

    public Date getFechaCreacionOC() {
        return fechaCreacionOC;
    }

    public void setFechaCreacionOC(Date fechaCreacionOC) {
        this.fechaCreacionOC = fechaCreacionOC;
    }

    public EstadoOrdenCompra getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantArticulosOC() {
        return cantArticulosOC;
    }

    public void setCantArticulosOC(int cantArticulosOC) {
        this.cantArticulosOC = cantArticulosOC;
    }

   public void MostrarOrdenesCompra(JTable paramTablaTotalOrdenCompra){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaTotalOrdenCompra.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Número");
      modelo.addColumn("Fecha de creación");
      modelo.addColumn("Estado");     
      modelo.addColumn("Proveedor");
      modelo.addColumn("Artículo");  
      modelo.addColumn("Cantidad");
      
      paramTablaTotalOrdenCompra.setModel(modelo);
      
      sql = "SELECT \n" +
      "    OrdenCompra.numOrdenCompra,\n" +
      "    OrdenCompra.fechaCreacionOC,\n" +
      "    EstadoOrdenCompra.nombreEstadoOC AS nombreEstado,\n" +
      "    Proveedor.nombreProveedor AS nombreProveedor,\n" +
      "    Articulo.nombreArticulo AS nombreArticulo,\n" +
      "    OrdenCompra.cantArticulosOC\n" +
      "FROM \n" +
      "    OrdenCompra\n" +
      "    INNER JOIN EstadoOrdenCompra ON OrdenCompra.codEstadoOC = EstadoOrdenCompra.codEstadoOC\n" +
      "    INNER JOIN Proveedor ON OrdenCompra.codProveedor = Proveedor.codProveedor\n" +
      "    INNER JOIN Articulo ON OrdenCompra.codArticulo = Articulo.codArticulo;";
      
      String[] datos = new String[6];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              datos[4]=rs.getString(5);
              datos[5]=rs.getString(6);
              
             modelo.addRow(datos);
          } 
          
          paramTablaTotalOrdenCompra.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  } public void AgregarOrdenCompra(JTextField paramNumero, JTextField paramfechaOrden, JTextField paramProveedor, JTextField paramArticulo, JTextField paramCantidad) {
    try {
        // Verificar si las entradas están vacías
        if (paramCantidad.getText().trim().isEmpty()) {
            throw new NumberFormatException("El campo de cantidad no puede estar vacío.");
        }

        // Convertir valores de los JTextField a tipos adecuados
        int numOrdenCompra = Integer.parseInt(paramNumero.getText());
        LocalDate fechaActual = LocalDate.now(); // Fecha actual en formato LocalDate

        // Establecer siempre codEstadoOC a 1
        int codEstadoOC = 1;

        int codProveedor = Integer.parseInt(paramProveedor.getText());
        int codArticulo = Integer.parseInt(paramArticulo.getText());
        int cantArticulosOC = Integer.parseInt(paramCantidad.getText());

        // Crear instancia de BaseRepository
        BaseRepository baseRepository = new BaseRepository();

        // Consulta SQL para insertar una nueva Orden de Compra
        String consultaInsertarOC = "INSERT INTO ordencompra (numOrdenCompra, fechaCreacionOC, codEstadoOC, codProveedor, codArticulo, cantArticulosOC) VALUES (?, ?, ?, ?, ?, ?)";

        // Preparar la consulta para insertar la Orden de Compra
        try (Connection connection = baseRepository.estableceConexion();
             PreparedStatement psInsertarOC = connection.prepareStatement(consultaInsertarOC)) {

            // Iniciar transacción explícita
            connection.setAutoCommit(false);

            psInsertarOC.setInt(1, numOrdenCompra);
            psInsertarOC.setDate(2, Date.valueOf(fechaActual));
            psInsertarOC.setInt(3, codEstadoOC);
            psInsertarOC.setInt(4, codProveedor);
            psInsertarOC.setInt(5, codArticulo);
            psInsertarOC.setInt(6, cantArticulosOC);

            // Ejecutar la inserción de la Orden de Compra
            psInsertarOC.executeUpdate();

            // Consulta SQL para actualizar el stock en Articulo
            String consultaActualizarStock = "UPDATE articulo SET stockActualArticulo = stockActualArticulo + ? WHERE codArticulo = ?";
            
            // Preparar la consulta para actualizar el stock en Articulo
            try (PreparedStatement psActualizarStock = connection.prepareStatement(consultaActualizarStock)) {
                psActualizarStock.setInt(1, cantArticulosOC);
                psActualizarStock.setInt(2, codArticulo);

                // Ejecutar la actualización del stock en Articulo
                psActualizarStock.executeUpdate();

                // Confirmar la transacción
                connection.commit();

                JOptionPane.showMessageDialog(null, "Orden de compra agregada con éxito");
            } catch (SQLException e) {
                // Revertir la transacción en caso de error al actualizar el stock en Articulo
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Error al actualizar el stock en Articulo: " + e.getMessage());
            }

        } catch (SQLException e) {
            // Revertir la transacción en caso de error al insertar la Orden de Compra
            JOptionPane.showMessageDialog(null, "Error al agregar la Orden de compra: " + e.getMessage());
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error general: " + e.getMessage());
    }
  }
}
