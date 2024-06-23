package proyectostock.controller;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class RellenarFechas {
    public void fechaActual(JTextField txField) {
        // Obtener la fecha actual y formatearla
        String currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        // Establecer la fecha actual en el JTextField
        txField.setText(currentDate);
    }
}
