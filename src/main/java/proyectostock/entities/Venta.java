
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import proyectostock.repository.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class Venta {
   private Articulo articulo;
   private Date fechaVenta;

   public Venta(){
       
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

    
    public void MostrarVentas(JTable paramTablaVenta) {
    try {
        // Crear instancia de BaseRepository y establecer conexión
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.estableceConexion();

        // Consulta SQL para obtener las ventas con detalles del artículo
        String sql = "SELECT v.numVenta, v.fechaVenta, v.codArticulo, v.cantidad " +
                     "FROM venta v";

        // Crear un Statement y ejecutar la consulta
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Crear un modelo de tabla para mostrar los resultados
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaVenta.setRowSorter(OrdenarTabla);

        // Agregar las columnas al modelo
        modelo.addColumn("Número");
        modelo.addColumn("Fecha");
        modelo.addColumn("Código Artículo");
        modelo.addColumn("Cantidad");

        // Iterar sobre los resultados y agregar filas al modelo
        while (rs.next()) {
            int numVenta = rs.getInt("numVenta");
            String fechaVenta = rs.getString("fechaVenta");
            int codArticulo = rs.getInt("codArticulo");
            int cantidad = rs.getInt("cantidad");

            Object[] fila = { numVenta, fechaVenta, codArticulo, cantidad };
            modelo.addRow(fila);
        }

        // Establecer el modelo en la tabla
        paramTablaVenta.setModel(modelo);

        // Cerrar conexión y recursos
        rs.close();
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar las ventas: " + e.getMessage());
    }
} //funciona bien
       
  public void AgregarVenta(JTextField paramfechaVenta, JTextField codArticulo, JTextField paramcantidad) {
      
       try {
            // Verificar si las entradas están vacías
            if (paramcantidad.getText().trim().isEmpty()) {
                throw new NumberFormatException("El campo de cantidad no puede estar vacío.");
            }
            if (codArticulo.getText().trim().isEmpty()) {
                throw new NumberFormatException("El campo de código de artículo no puede estar vacío.");
            }
      
            //Convierto los jtx a int
             setCantidadVendida(Integer.parseInt(paramcantidad.getText()));
             setCodArticulo(Integer.parseInt(codArticulo.getText()));
      
            LocalDate localDate = LocalDate.now();
            Date fechaActual = Date.valueOf(localDate);
            setFechaVenta(fechaActual);           
            
            // Crear instancia de BaseRepository
            BaseRepository baseRepository = new BaseRepository();

            // Consulta SQL para insertar una nueva venta
            String consulta = "INSERT INTO Venta (fechaVenta, codArticulo, cantidad) VALUES (?, ?, ?)";

            // Preparar y ejecutar la consulta
            try (Connection connection = baseRepository.estableceConexion();
                 PreparedStatement ps = connection.prepareStatement(consulta)) {
                ps.setDate(1, fechaActual);
                ps.setInt(2, getCodArticulo());
                ps.setInt(3, getCantidadVendida());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Venta agregada con éxito");
                //actualizarStockArticulo(getCodArticulo(), getCantidadVendida());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al agregar la venta: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error general: " + e.getMessage());
        }
    }
  
  public void actualizarStockArticulo(int codArticulo, int cantidadVendida) {
        String consulta = "UPDATE Articulo SET stockActualArticulo = stockActualArticulo - ? WHERE codArticulo = ?";

        BaseRepository baseRepository = new BaseRepository();

        try (Connection connection = baseRepository.estableceConexion();
             PreparedStatement ps = connection.prepareStatement(consulta)) {
            
            ps.setInt(1, cantidadVendida);
            ps.setInt(2, codArticulo);

            ps.executeUpdate();

            System.out.println("Stock del artículo actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock del artículo: " + e.getMessage());
        }
    }
}