
package proyectostock.controller;

import java.sql.CallableStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.entities.Venta;
import proyectostock.repository.BaseRepository;

public class CargarVenta {

    public boolean guardarVentaEnBD(Venta venta) {
        boolean exito = false;

        try {
            // Preparar la consulta SQL para insertar la venta
            BaseRepository baseRepository = new BaseRepository();
            String sql = "INSERT INTO ventas (fecha_venta, cod_articulo, cantidad_vendida) VALUES (?, ?, ?)";
            try (CallableStatement cs = baseRepository.estableceConexion().prepareCall(sql)) {
                cs.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime())); // Convertir java.util.Date a java.sql.Date
                cs.setInt(2, venta.getCodArticulo());
                cs.setInt(3, venta.getCantidadVendida());
                // Ejecutar la consulta
                int filasInsertadas = cs.executeUpdate();
                // Verificar si se insertaron filas
                if (filasInsertadas > 0) {
                    exito = true;
                }
                // Cerrar declaración (no cerramos la conexión porque ya está abierta)
            } // Convertir java.util.Date a java.sql.Date
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }


    public void MostrarStockArticulo(JComboBox articuloCombo, JTextField stockArticulo) {
        String consulta = "SELECT stockActualArticulo FROM articulo WHERE nombreArticulo = ?";
        BaseRepository baseRepository = new BaseRepository();

        try {
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
            cs.setString(1, articuloCombo.getSelectedItem().toString());
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                stockArticulo.setText(rs.getString("stockActualArticulo"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el stock del artículo: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void MostrarVentas(JTable tablaVentas) {
        BaseRepository baseRepository = new BaseRepository();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        tablaVentas.setRowSorter(ordenarTabla);

        // Columnas del modelo de la tabla
        modelo.addColumn("Fecha de Venta");
        modelo.addColumn("Número de Venta");
        modelo.addColumn("Código de Artículo");
        modelo.addColumn("Cantidad Vendida");

        tablaVentas.setModel(modelo);

        String sql = "SELECT fecha_venta, num_venta, cod_articulo, cantidad_vendida FROM ventas";

        try (
                Statement st = baseRepository.estableceConexion().createStatement();ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String fechaVenta = rs.getString("fecha_venta");
                int numVenta = rs.getInt("num_venta");
                int codArticulo = rs.getInt("cod_articulo");
                int cantidadVendida = rs.getInt("cantidad_vendida");

                Object[] fila = {fechaVenta, numVenta, codArticulo, cantidadVendida};
                modelo.addRow(fila);
            }

            tablaVentas.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar las ventas: " + e.toString());
        }
    }
}


