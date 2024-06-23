
package proyectostock.controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.repository.BaseRepository;

public class Predicciones {
    private int cantMeses;
    private int codArticulo;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;   
    private int num7;
    private int num8;
    private int num9;
    private int num10;
    private int num11;
    private int num12;
    private int num13;   
    
    public int getCantMeses() {
        return cantMeses;
    }

    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum5() {
        return num5;
    }

    public void setNum5(int num5) {
        this.num5 = num5;
    }

    public int getNum6() {
        return num6;
    }

    public void setNum6(int num6) {
        this.num6 = num6;
    }

    public int getNum7() {
        return num7;
    }

    public void setNum7(int num7) {
        this.num7 = num7;
    }

    public int getNum8() {
        return num8;
    }

    public void setNum8(int num8) {
        this.num8 = num8;
    }

    public int getNum9() {
        return num9;
    }

    public void setNum9(int num9) {
        this.num9 = num9;
    }

    public int getNum10() {
        return num10;
    }

    public void setNum10(int num10) {
        this.num10 = num10;
    }

    public int getNum11() {
        return num11;
    }

    public void setNum11(int num11) {
        this.num11 = num11;
    }

    public int getNum12() {
        return num12;
    }

    public void setNum12(int num12) {
        this.num12 = num12;
    }

    public int getNum13() {
        return num13;
    }

    public void setNum13(int num13) {
        this.num13 = num13;
    }
    
  public void MostrarMeses(JTextField paramCantMeses, JTable paramtbPonderaciones, JTextField paramIdArticulo){ //JTextField idArticulo
      setCodArticulo(Integer.parseInt(paramIdArticulo.getText()));
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramtbPonderaciones.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      setCantMeses(Integer.parseInt(paramCantMeses.getText()));
      
      modelo.addColumn("Número de Demanda");
      modelo.addColumn("Nombre de Mes");
      modelo.addColumn("Cantidad");  
      modelo.addColumn("Artículo");
      
      paramtbPonderaciones.setModel(modelo);
      
      sql = "SELECT demanda.numeroDemanda, demanda.nombreMes, demanda.cantidad, articulo.nombreArticulo\n" +
      "FROM demanda INNER JOIN articulo ON articulo.codArticulo = demanda.codArticulo\n" + 
      "WHERE demanda.codArticulo = " + codArticulo + "\n" + 
      "ORDER BY demanda.numeroDemanda DESC\n" + 
      "LIMIT " + cantMeses + ";";
          
      String[] datos = new String[4];
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
          
          paramtbPonderaciones.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  } public void CalcularPromedioMovilPonderado(JTextField paramCantMeses, JTextField paramIdArticulo, JTextField param1, JTextField param2, JTextField param3, JTextField param4, JTextField param5, JTextField param6, JTextField param7, JTextField param8, JTextField param9, JTextField param10, JTextField param11, JTextField param12, JTextField param13, JTextField paramResultado){
      
        try {
        int cantMeses = Integer.parseInt(paramCantMeses.getText());
        int codArticulo = Integer.parseInt(paramIdArticulo.getText());
        
        
        double[] params = {
        Double.parseDouble(param1.getText()), Double.parseDouble(param2.getText()), 
        Double.parseDouble(param3.getText()), Double.parseDouble(param4.getText()), 
        Double.parseDouble(param5.getText()), Double.parseDouble(param6.getText()), 
        Double.parseDouble(param7.getText()), Double.parseDouble(param8.getText()), 
        Double.parseDouble(param9.getText()), Double.parseDouble(param10.getText()), 
        Double.parseDouble(param11.getText()), Double.parseDouble(param12.getText()), 
        Double.parseDouble(param13.getText())
        };
        
        String sql = "SELECT demanda.numeroDemanda, demanda.cantidad\n" +
                     "FROM demanda INNER JOIN articulo ON articulo.codArticulo = demanda.codArticulo\n" + 
                     "WHERE demanda.codArticulo = " + codArticulo + "\n" + 
                     "ORDER BY demanda.numeroDemanda DESC\n" + 
                     "LIMIT " + cantMeses + ";";
        
     // Obtener conexión y ejecutar consulta
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.estableceConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
    double totalSum = 0;
    int index = 0;
    
            while (rs.next() && index < params.length) {
            int numeroDemanda = rs.getInt("numeroDemanda");
            double cantidad = rs.getDouble("cantidad");
            double paramValue = params[index];
            totalSum += cantidad * paramValue;
            index++;
        }

        double resultado = totalSum / cantMeses;
        paramResultado.setText(String.valueOf(resultado));
// Cerrar recursos
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        paramResultado.setText("Error");
        
  }
 }
  
public void obtenerUltimaCantidad(JTextField paramCodArticulo, JTextField paramUltimaCantidad) {
    try {
        String codArticulo = paramCodArticulo.getText();
        
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.estableceConexion();
        Statement stmt = conn.createStatement();

        // Consulta SQL para obtener la última cantidad de demanda para el artículo dado su código
        String sql = "SELECT demanda.cantidad\n" +
                     "FROM demanda\n" + 
                     "WHERE demanda.codArticulo = '" + codArticulo + "'\n" +
                     "ORDER BY demanda.numeroDemanda DESC\n" + 
                     "LIMIT 1;";
        
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            double ultimaCantidad = rs.getDouble("cantidad");
            paramUltimaCantidad.setText(String.valueOf(ultimaCantidad));
        } else {
            paramUltimaCantidad.setText("No hay demanda registrada para este artículo");
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        paramUltimaCantidad.setText("Error al obtener la cantidad");
    }
   }
public void CalcularPMSuavizadoExponencialmente(JTextField paramUltimaCantidad, JTextField paramDemandaEsperada, JTextField paramAlfa, JTextField paramResultadoPMSuavizado) {
    try {
        // Obtener los valores de los JTextFields
        double ultimaCantidad = Double.parseDouble(paramUltimaCantidad.getText());
        double demandaEsperada = Double.parseDouble(paramDemandaEsperada.getText());
        double alfa = Double.parseDouble(paramAlfa.getText());

        // Validar que alfa esté en el rango [0, 1]
        if (alfa < 0 || alfa > 1) {
            paramResultadoPMSuavizado.setText("El valor de alfa debe estar entre 0 y 1");
            return;
        }

        // Calcular el Promedio Movil Suavizado Exponencialmente (PMSuavizado)
        double pmsuavizado = alfa * ultimaCantidad + (1 - alfa) * demandaEsperada;

        // Mostrar el resultado en el JTextField correspondiente
        paramResultadoPMSuavizado.setText(String.valueOf(pmsuavizado));
    } catch (NumberFormatException e) {
        e.printStackTrace();
        paramResultadoPMSuavizado.setText("Error en el formato de los datos");
    } catch (Exception e) {
        e.printStackTrace();
        paramResultadoPMSuavizado.setText("Error al calcular el PMSuavizado");
    }
}



} 

