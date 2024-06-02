/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.*;

/**
 *
 * @author Juan
 */
public class Articulo {
    private String nombreArticulo;
    private int codArticulo;
    private float costoUnidadArticulo;
    private int loteOptimoArticulo;
    private int stockSeguridadArticulo;
    private int stockActualArticulo;
    private int puntoPedidoArticulo;
    private float costoAlmacenimientoArticulo;
  //  private TipoArticulo tipoArticulo;
    private Demanda demanda;

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public float getCostoUnidadArticulo() {
        return costoUnidadArticulo;
    }

    public void setCostoUnidadArticulo(float costoUnidadArticulo) {
        this.costoUnidadArticulo = costoUnidadArticulo;
    }

    public int getLoteOptimoArticulo() {
        return loteOptimoArticulo;
    }

    public void setLoteOptimoArticulo(int loteOptimoArticulo) {
        this.loteOptimoArticulo = loteOptimoArticulo;
    }

    public int getStockSeguridadArticulo() {
        return stockSeguridadArticulo;
    }

    public void setStockSeguridadArticulo(int stockSeguridadArticulo) {
        this.stockSeguridadArticulo = stockSeguridadArticulo;
    }

    public int getStockActualArticulo() {
        return stockActualArticulo;
    }

    public void setStockActualArticulo(int stockActualArticulo) {
        this.stockActualArticulo = stockActualArticulo;
    }

    public int getPuntoPedidoArticulo() {
        return puntoPedidoArticulo;
    }

    public void setPuntoPedidoArticulo(int puntoPedidoArticulo) {
        this.puntoPedidoArticulo = puntoPedidoArticulo;
    }

    public float getCostoAlmacenimientoArticulo() {
        return costoAlmacenimientoArticulo;
    }

    public void setCostoAlmacenimientoArticulo(float costoAlmacenimientoArticulo) {
        this.costoAlmacenimientoArticulo = costoAlmacenimientoArticulo;
    }

  //  public void setTipoArticulo(TipoArticulo tipoArticulo) {
  //      this.tipoArticulo = tipoArticulo;
  //  }

    
    public void AgregarArticulo(JTextField paramNombre,JTextField paramCod, JTextField paramCosto, JTextField paramStockS, JTextField paramStockA, JTextField paramPuntoP, JTextField paramCostoA){
        setNombreArticulo(paramNombre.getText());
        setCodArticulo(Integer.parseInt(paramCod.getText()));
        setCostoUnidadArticulo(Float.parseFloat(paramCosto.getText()));  
        setStockSeguridadArticulo(Integer.parseInt(paramStockS.getText()));  
        setStockActualArticulo(Integer.parseInt(paramStockA.getText()));  
        setPuntoPedidoArticulo(Integer.parseInt(paramPuntoP.getText()));  
        setCostoAlmacenimientoArticulo(Float.parseFloat(paramCostoA.getText()));
        //Falta el TipoArticulo
        BaseRepository baseRepository = new BaseRepository();
        
        String consulta = "insert into Articulo (nombreArticulo, codArticulo, costoUnidadArticulo, stockSeguridadArticulo, stockActualArticulo, puntoPedidoArticulo, costoAlmacenimientoArticulo) values (?,?,?,?,?,?,?)";
        //Falta el TipoArticulo
        try {
            
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
            cs.setString(1, getNombreArticulo());
            cs.setInt(2, getCodArticulo());
            cs.setFloat(3, getCostoUnidadArticulo());   
            cs.setInt(4, getStockSeguridadArticulo()); 
            cs.setInt(5, getStockActualArticulo());       
            cs.setInt(6, getPuntoPedidoArticulo());  
            cs.setFloat(7, getCostoAlmacenimientoArticulo());  
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Articulo agregado con éxito");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" +e.toString());
        }
       
    }
    
  public void MostrarArticulos(JTable paramTablaTotalArticulos){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaTotalArticulos.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Nombre");
      modelo.addColumn("Código");
      modelo.addColumn("CostoUnidad");
      modelo.addColumn("StockSeguridad");  
      modelo.addColumn("StockActual");
      modelo.addColumn("PuntoPedido");
      modelo.addColumn("CostoAlmacenimiento");
      
      paramTablaTotalArticulos.setModel(modelo);
      
      sql = "select * from Articulo;";
      
      String[] datos = new String[7];
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
              datos[6]=rs.getString(7);   
          
             modelo.addRow(datos);
          } 
          
          paramTablaTotalArticulos.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }
  
    public void SeleccionarArticulo(JTable paramTablaArticulos, JTextField paramNombre,JTextField paramCod, JTextField paramCosto, JTextField paramStockS, JTextField paramStockA, JTextField paramPuntoP, JTextField paramCostoA){
        
        try {
            int fila = paramTablaArticulos.getSelectedRow();
            
            if (fila >= 0) {
                paramNombre.setText(paramTablaArticulos.getValueAt(fila, 0).toString());
                paramCod.setText(paramTablaArticulos.getValueAt(fila, 1).toString());
                paramCosto.setText(paramTablaArticulos.getValueAt(fila, 2).toString());
                paramStockS.setText(paramTablaArticulos.getValueAt(fila, 3).toString());
                paramStockA.setText(paramTablaArticulos.getValueAt(fila, 4).toString());
                paramPuntoP.setText(paramTablaArticulos.getValueAt(fila, 5).toString());
                paramCostoA.setText(paramTablaArticulos.getValueAt(fila, 6).toString());
                
            }
            else 
            {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección:" +e.toString());
            }
        
    }
    
    public void ModificarArticulos(JTextField paramNombre,JTextField paramCod, JTextField paramCosto, JTextField paramStockS, JTextField paramStockA, JTextField paramPuntoP, JTextField paramCostoA){
        setNombreArticulo(paramNombre.getText());
        setCodArticulo(Integer.parseInt(paramCod.getText()));
        setCostoUnidadArticulo(Float.parseFloat(paramCosto.getText()));  
        setStockSeguridadArticulo(Integer.parseInt(paramStockS.getText()));  
        setStockActualArticulo(Integer.parseInt(paramStockA.getText()));  
        setPuntoPedidoArticulo(Integer.parseInt(paramPuntoP.getText()));  
        setCostoAlmacenimientoArticulo(Float.parseFloat(paramCostoA.getText()));
        
        BaseRepository baseRepository = new BaseRepository();
        
        String consulta = "UPDATE Articulo set articulo.nombreArticulo = ?, articulo.codArticulo = ?, articulo.costoUnidadArticulo = ?, articulo.stockSeguridadArticulo = ?, articulo.stockActualArticulo = ?, articulo.puntoPedidoArticulo = ?, articulo.costoAlmacenimientoArticulo = ?;";
        
        try {
            
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, getNombreArticulo());
            cs.setInt(2, getCodArticulo());
            cs.setFloat(3, getCostoUnidadArticulo());   
            cs.setInt(4, getStockSeguridadArticulo()); 
            cs.setInt(5, getStockActualArticulo());       
            cs.setInt(6, getPuntoPedidoArticulo());  
            cs.setFloat(7, getCostoAlmacenimientoArticulo());  
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha modificado con éxito.");
            
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error en la modificación:" +e.toString());
        }
       
        
    }
    
    public void EliminarArticulo(JTextField paramCod){
        
        setCodArticulo(Integer.parseInt(paramCod.getText()));
        BaseRepository baseRepository = new BaseRepository();
        
        String consulta = "DELETE FROM Articulo WHERE articulo.codArticulo = ?;";
        
                try {
            CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta); 
            cs.setInt(1, getCodArticulo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito.");
            
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error en la eliminación:" +e.toString());
        }
    }
    
    
    
    
}
