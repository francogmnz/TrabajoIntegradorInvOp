
package proyectostock.controller;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
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
      
 
  } public void CalcularPromedioMovilPonderado(JTextField paramCantMeses, JTextField paramIdArticulo, JTextField param1, JTextField param2, JTextField param3, JTextField param4, JTextField param5, JTextField param6, JTextField param7, JTextField param8, JTextField param9, JTextField param10, JTextField param11, JTextField param12, JTextField param13, JTextField paramResultado, JTextField txterror){
        setCodArticulo(Integer.parseInt(paramIdArticulo.getText()));
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
    List<Double> demandasReales = new ArrayList<>();
                // Obtener demandas reales
            while (rs.next()) {
                double cantidad = rs.getDouble("cantidad");
                demandasReales.add(cantidad);
            }
                // Calcular el total ponderado
            for (int i = 0; i < demandasReales.size() && index < params.length; i++) {
                double cantidad = demandasReales.get(i);
                double paramValue = params[index];
                totalSum += cantidad * paramValue;
                index++;
            }
    
    
            // Calcular el total ponderado
            for (int i = 0; i < demandasReales.size() && index < params.length; i++) {
                double cantidad = demandasReales.get(i);
                double paramValue = params[index];
                totalSum += cantidad * paramValue;
                index++;
            }
            
        double resultado = totalSum / cantMeses;
        paramResultado.setText(String.valueOf(resultado));
        
            // Calcular el MAPE
            double sumaErrores = 0.0;
            for (int i = 0; i < demandasReales.size() && i < params.length; i++) {
                double demandaReal = demandasReales.get(i);
                double errorAbsoluto = Math.abs(demandaReal - (params[i] * resultado));
                double errorPorcentual = errorAbsoluto / demandaReal * 100;
                sumaErrores += errorPorcentual;
            }
            double mape = sumaErrores / demandasReales.size();
            txterror.setText(String.valueOf(mape));
            
        // Guardar en la tabla prediccioneshistoricas
        String modeloPrediccion = "Promedio móvil Ponderado";
        guardarPrediccionHistorica(getCodArticulo(), modeloPrediccion, mape, resultado);
            
        // Cerrar recursos
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        paramResultado.setText("Error");
        txterror.setText("Error al calcular el MAPE");
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
public void CalcularPMSuavizadoExponencialmente(JTextField paramIdArticulo, JTextField paramUltimaCantidad, JTextField paramDemandaEsperada, JTextField paramAlfa, JTextField paramResultadoPMSuavizado, JTextField txterror) {
        setCodArticulo(Integer.parseInt(paramIdArticulo.getText()));
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

            // Calcular el MAPE
            double errorAbsoluto = Math.abs(ultimaCantidad - pmsuavizado);
            double errorPorcentual = errorAbsoluto / ultimaCantidad * 100;
            txterror.setText(String.valueOf(errorPorcentual));
        
            // Guardar en la tabla prediccioneshistoricas
            String modeloPrediccion = "PM Suavizado Exponencialmente";
            guardarPrediccionHistorica(getCodArticulo(), modeloPrediccion, errorPorcentual, pmsuavizado);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            paramResultadoPMSuavizado.setText("Error en el formato de los datos");
            txterror.setText("Error en el formato de los datos");
        } catch (Exception e) {
            e.printStackTrace();
            paramResultadoPMSuavizado.setText("Error al calcular el PMSuavizado");
            txterror.setText("Error al calcular el MAPE");
        }
    }

public void guardarPrediccionHistorica(int codArticulo, String modeloPrediccion, double error, double resultadoDemanda) {
    try {
        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.estableceConexion();
        Statement stmt = conn.createStatement();

        // Consulta SQL para insertar en la tabla prediccioneshistoricas
        String sql = "INSERT INTO prediccioneshistoricas (Articulo, ModeloPrediccion, Error, resultadoDemanda) " +
                     "VALUES (" + codArticulo + ", '" + modeloPrediccion + "', " + error + ", " + resultadoDemanda + ");";

        // Ejecutar la inserción
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected == 1) {
            System.out.println("Registro insertado en prediccioneshistoricas.");
        } else {
            System.out.println("No se pudo insertar el registro en prediccioneshistoricas.");
        }

        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Error al intentar guardar la predicción histórica.");
    }
}

public void MostrarMejorModelo(JComboBox<String> jComboArticulo, JTextField txtcodigoArticulo, JTable tbTotalDemandas, JTextField txtresultado, JTextField txtresultadoDemanda) {
    try {
        // Obtener el nombre del artículo seleccionado del JComboBox
        String nombreArticulo = jComboArticulo.getSelectedItem().toString();

        // Verificar si se seleccionó un artículo válido
        if (nombreArticulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un artículo válido.");
            return;
        }

        // Obtener el código del artículo seleccionado
        int codArticulo = Integer.parseInt(txtcodigoArticulo.getText());

        // Consulta SQL para obtener las últimas 2 predicciones históricas para el artículo seleccionado
        String sql = "SELECT numPrediccionHistorica, Articulo, ModeloPrediccion, Error, ResultadoDemanda " +
                     "FROM PrediccionesHistoricas " +
                     "WHERE Articulo = " + codArticulo + " " +
                     "ORDER BY numPrediccionHistorica DESC " +
                     "LIMIT 2;";

        BaseRepository baseRepository = new BaseRepository();
        Connection conn = baseRepository.estableceConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Crear un modelo de tabla para almacenar los resultados
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Núm. Predicción");
        modelo.addColumn("Artículo");
        modelo.addColumn("Modelo de Predicción");
        modelo.addColumn("Error");
        modelo.addColumn("Resultado Demanda"); // Nueva columna agregada

        // Llenar el modelo con los resultados de la consulta
        while (rs.next()) {
            int numPrediccion = rs.getInt("numPrediccionHistorica");
            int articulo = rs.getInt("Articulo");
            String modeloPrediccion = rs.getString("ModeloPrediccion");
            int error = rs.getInt("Error");
            double resultadoDemanda = rs.getDouble("ResultadoDemanda");

            // Agregar fila al modelo de la tabla
            modelo.addRow(new Object[]{numPrediccion, articulo, modeloPrediccion, error, resultadoDemanda});
        }

        // Establecer el modelo en la tabla tbTotalDemandas
        tbTotalDemandas.setModel(modelo);

        // Determinar el mejor modelo basado en el menor error de las últimas 2 predicciones
        if (tbTotalDemandas.getRowCount() >= 2) {
            int menorError = Integer.MAX_VALUE;
            String mejorModelo = "";
            int mejorError = 0;
            double mejorResultadoDemanda = 0.0;

            for (int i = 0; i < 2; i++) {
                int errorActual = (int) tbTotalDemandas.getValueAt(i, 3); // Columna de Error
                String modeloActual = (String) tbTotalDemandas.getValueAt(i, 2); // Columna de ModeloPrediccion
                double resultadoDemandaActual = (double) tbTotalDemandas.getValueAt(i, 4); // Columna de ResultadoDemanda

                if (errorActual < menorError) {
                    menorError = errorActual;
                    mejorModelo = modeloActual;
                    mejorError = errorActual;
                    mejorResultadoDemanda = resultadoDemandaActual;
                }
            }

            // Mostrar el mejor modelo, su error y resultado de demanda en los JTextField correspondientes
            txtresultado.setText(mejorModelo);
            txtresultadoDemanda.setText(String.valueOf(mejorResultadoDemanda));
        }

        // Cerrar recursos
        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al consultar las predicciones históricas: " + e.getMessage());
    }
}
        public void MostrarCodigoArticulo(JComboBox articuloCombo, JTextField idArticulo){
        
        String consulta = "SELECT articulo.codArticulo FROM articulo WHERE articulo.nombreArticulo = ?";
        BaseRepository baseRepository = new BaseRepository();
        
        try {
          CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
          cs.setString(1, articuloCombo.getSelectedItem().toString());
          cs.execute();
          
          ResultSet rs = cs.executeQuery();
          
          if(rs.next()){
              idArticulo.setText(rs.getString("codArticulo"));
          }
          
          } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:" +e.toString());
      }
        }
}

