/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import java.time.LocalDate;

/**
 *
 * @author Juan
 */
public class EstadoOrdenCompra {
    
    private int codEstadoOC;
    private LocalDate fechaCambio;
    private String nombreEstadoOC;

    public EstadoOrdenCompra(int codEstadoOC, LocalDate fechaCambio, String nombreEstadoOC) {
        this.codEstadoOC = codEstadoOC;
        this.fechaCambio = fechaCambio;
        this.nombreEstadoOC = nombreEstadoOC;
    }

    public int getCodEstadoOC() {
        return codEstadoOC;
    }

    public void setCodEstadoOC(int codEstadoOC) {
        this.codEstadoOC = codEstadoOC;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getNombreEstadoOC() {
        return nombreEstadoOC;
    }

    public void setNombreEstadoOC(String nombreEstadoOC) {
        this.nombreEstadoOC = nombreEstadoOC;
    }
    
    
    
}

