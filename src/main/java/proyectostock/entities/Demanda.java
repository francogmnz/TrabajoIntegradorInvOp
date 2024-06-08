
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.repository.BaseRepository;

public class Demanda {
    private int numeroDemanda;
    private int anio;
    private int cantidad;
    private int mes;
    private String nombreMes;
    private Articulo articulo;

    public int getNumeroDemanda() {
        return numeroDemanda;
    }

    public void setNumeroDemanda(int numeroDemanda) {
        this.numeroDemanda = numeroDemanda;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
    public void AgregarDemanda(JTextField paramNumeroDemanda,JTextField paramAnio, JTextField paramCantidad, JTextField paramMes, JTextField paramNombreMes, JTextField idArticulo){
        setNumeroDemanda(Integer.parseInt(paramNumeroDemanda.getText()));        
        setAnio(Integer.parseInt(paramAnio.getText()));
        setCantidad(Integer.parseInt(paramCantidad.getText()));  
        setMes(Integer.parseInt(paramMes.getText()));      
        setNombreMes(paramNombreMes.getText());
        
        BaseRepository baseRepository = new BaseRepository();
        
        String consulta = "insert into Demanda (numeroDemanda, anio, cantidad, mes, nombreMes, codArticulo) values (?,?,?,?,?,?)";
        
        try {
            
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getNumeroDemanda());
            cs.setInt(2, getAnio());
            cs.setInt(3, getCantidad());  
            cs.setInt(4, getMes());  
            cs.setString(5, getNombreMes());  
            cs.setString(6, idArticulo.getText());
            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Demanda agregada con éxito");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" +e.toString());
        }
       
    }
    
  public void MostrarDemandas(JTable paramTablaTotalDemandas){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaTotalDemandas.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Número");
      modelo.addColumn("Año");
      modelo.addColumn("Cantidad");
      modelo.addColumn("Número de mes");  
      modelo.addColumn("Nombre de mes");
      modelo.addColumn("Artículo");
      
      paramTablaTotalDemandas.setModel(modelo);
      
      sql = "SELECT demanda.numeroDemanda, demanda.anio, demanda.cantidad, demanda.mes, demanda.nombreMes, articulo.nombreArticulo\n" +
      "FROM demanda INNER JOIN articulo ON demanda.codArticulo = articulo.codArticulo;";
      
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
          
          paramTablaTotalDemandas.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }
  
    public void SeleccionarDemanda(JTable paramTablaDemandas, JTextField paramNumeroDemanda,JTextField paramAnio, JTextField paramCantidad, JTextField paramMes, JTextField paramNombreMes){
        
        try {
            int fila = paramTablaDemandas.getSelectedRow();
            
            if (fila >= 0) {
                paramNumeroDemanda.setText(paramTablaDemandas.getValueAt(fila, 0).toString());
                paramAnio.setText(paramTablaDemandas.getValueAt(fila, 1).toString());
                paramCantidad.setText(paramTablaDemandas.getValueAt(fila, 2).toString());
                paramMes.setText(paramTablaDemandas.getValueAt(fila, 3).toString());
                paramNombreMes.setText(paramTablaDemandas.getValueAt(fila, 4).toString());

            }
            else 
            {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección:" +e.toString());
            }
        
    }
    
    public void ModificarDemandas(JTextField paramNumeroDemanda,JTextField paramAnio, JTextField paramCantidad, JTextField paramMes, JTextField paramNombreMes, JTextField idArticulo){
        setNumeroDemanda(Integer.parseInt(paramNumeroDemanda.getText()));        
        setAnio(Integer.parseInt(paramAnio.getText()));
        setCantidad(Integer.parseInt(paramCantidad.getText()));  
        setMes(Integer.parseInt(paramMes.getText()));      
        setNombreMes(paramNombreMes.getText());
        
        BaseRepository baseRepository = new BaseRepository();
        //Falta el TipoArticulo
        String consulta = "UPDATE Demanda set demanda.numeroDemanda = ?, demanda.anio = ?, demanda.cantidad = ?, demanda.mes = ?, demanda.nombreMes = ?, demanda.codArticulo = ?;";
        
        try {
            
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, getNumeroDemanda());
            cs.setInt(2, getAnio());
            cs.setInt(3, getCantidad());  
            cs.setInt(4, getMes());  
            cs.setString(5, getNombreMes());  
            cs.setString(6, idArticulo.getText());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha modificado con éxito.");
            
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error en la modificación:" +e.toString());
        }
       
        
    }
    
    public void EliminarDemanda(JTextField paramNumeroDemanda){
        
        setNumeroDemanda(Integer.parseInt(paramNumeroDemanda.getText()));
        BaseRepository baseRepository = new BaseRepository();
        
        String consulta = "DELETE FROM Demanda WHERE demanda.numeroDemanda = ?;";
        
                try {
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta); 
            cs.setInt(1, getNumeroDemanda());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito.");
            
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error en la eliminación:" +e.toString());
        }
                
                
    }
      
    
    
    
}

