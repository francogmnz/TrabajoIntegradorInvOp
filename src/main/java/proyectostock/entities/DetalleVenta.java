/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.entities;

/**
 *
 * @author Pc
 */
public class DetalleVenta {
    private int cantidadArticulo;
    private int numeroDetalleVenta;
    private Articulo articulo;

    public DetalleVenta(int cantidadArticulo, int numeroDetalleVenta, Articulo articulo) {
        this.cantidadArticulo = cantidadArticulo;
        this.numeroDetalleVenta = numeroDetalleVenta;
        this.articulo = articulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public int getNumeroDetalleVenta() {
        return numeroDetalleVenta;
    }

    public void setNumeroDetalleVenta(int numeroDetalleVenta) {
        this.numeroDetalleVenta = numeroDetalleVenta;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
}
