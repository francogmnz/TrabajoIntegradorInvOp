/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Juan
 */
public class OrdenCompra {
    
    private int numOrdenCompra;
    private LocalDate fechaCreacionOC;
    private Proveedor proveedor;
    private List<DetalleOrdenCompra> detalles;
    private EstadoOrdenCompra estadoOrdenCompra;

    public OrdenCompra(int numOrdenCompra, LocalDate fechaCreacionOC, Proveedor proveedor, List<DetalleOrdenCompra> detalles, EstadoOrdenCompra estadoOrdenCompra) {
        this.numOrdenCompra = numOrdenCompra;
        this.fechaCreacionOC = fechaCreacionOC;
        this.proveedor = proveedor;
        this.detalles = detalles;
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    public int getNumOrdenCompra() {
        return numOrdenCompra;
    }

    public void setNumOrdenCompra(int numOrdenCcmpra) {
        this.numOrdenCompra = numOrdenCompra;
    }

    public LocalDate getFechaCreacionOC() {
        return fechaCreacionOC;
    }

    public void setFechaCreacionOC(LocalDate fechaCreacionOC) {
        this.fechaCreacionOC = fechaCreacionOC;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleOrdenCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrdenCompra> detalles) {
        this.detalles = detalles;
    }

    public EstadoOrdenCompra getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }
    

    

}
