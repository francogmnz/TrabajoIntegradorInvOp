
package proyectostock.controller;

import java.sql.CallableStatement;
import java.sql.Date;

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
    public void MostrarVentas(JTable paramTablaVentas) {
        BaseRepository baseRepository = new BaseRepository();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaVentas.setRowSorter(ordenarTabla);

        String sql = "SELECT fecha_venta, num_venta, cod_articulo, cantidad_vendida FROM ventas";

        modelo.addColumn("Fecha de Venta");
        modelo.addColumn("Número de Venta");
        modelo.addColumn("Código de Artículo");
        modelo.addColumn("Cantidad Vendida");

        paramTablaVentas.setModel(modelo);

        try (Statement st = baseRepository.estableceConexion().createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String fechaVenta = rs.getString("fecha_venta");
                int numVenta = rs.getInt("num_venta");
                int codArticulo = rs.getInt("cod_articulo");
                int cantidadVendida = rs.getInt("cantidad_vendida");

                Object[] fila = {fechaVenta, numVenta, codArticulo, cantidadVendida};
                modelo.addRow(fila);
            }

            paramTablaVentas.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar las ventas: " + e.toString());
        }
    }
    public void ActualizarVenta(JTextField paramNumVenta, JTextField paramFechaVenta, JTextField paramCodArticulo, JTextField paramCantidadVendida) {
        try {
            int numVenta = Integer.parseInt(paramNumVenta.getText());
            Date fechaVenta = Date.valueOf(paramFechaVenta.getText());
            int codArticulo = Integer.parseInt(paramCodArticulo.getText());
            int cantidadVendida = Integer.parseInt(paramCantidadVendida.getText());

            BaseRepository baseRepository = new BaseRepository();
            String consulta = "UPDATE ventas SET fecha_venta = ?, cod_articulo = ?, cantidad_vendida = ? WHERE num_venta = ?";

            try (CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta)) {
                cs.setDate(1, fechaVenta);
                cs.setInt(2, codArticulo);
                cs.setInt(3, cantidadVendida);
                cs.setInt(4, numVenta);
                cs.execute();
                JOptionPane.showMessageDialog(null, "Venta actualizada con éxito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar venta: " + e.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.toString());
        }
    }

}


