/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.controller;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Huilen
 */
public class RellenarFechas {
    public void fechaActual(JTextField txField) {
        // Obtener la fecha actual y formatearla
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        // Establecer la fecha actual en el JTextField
        txField.setText(currentDate);
    }
}
