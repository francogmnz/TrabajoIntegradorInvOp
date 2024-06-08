/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.entities;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Pc
 */
public class Venta {
    private LocalDate fechaVenta;
    private int numVenta;
    private List<DetalleVenta> detallesventa;

    public Venta(LocalDate fechaVenta, int numVenta, List<DetalleVenta> detallesventa) {
        this.fechaVenta = fechaVenta;
        this.numVenta = numVenta;
        this.detallesventa = detallesventa;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public List<DetalleVenta> getDetallesventa() {
        return detallesventa;
    }

    public void setDetallesventa(List<DetalleVenta> detallesventa) {
        this.detallesventa = detallesventa;
    }


    
    
    
}
