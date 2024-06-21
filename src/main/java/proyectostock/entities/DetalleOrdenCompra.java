/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

/**
 *
 * @author Juan
 */
public class DetalleOrdenCompra {
    
    private int numDetalleOrdenCompra;
    private int cantArticulosDOC;
    private Articulo articulo;

    public DetalleOrdenCompra(int numDetalleOrdenCompra, int cantArticulosDOC, Articulo articulo) {
        this.numDetalleOrdenCompra = numDetalleOrdenCompra;
        this.cantArticulosDOC = cantArticulosDOC;
        this.articulo = articulo;
    }

    public int getNumDetalleOrdenCompra() {
        return numDetalleOrdenCompra;
    }

    public void setNumDetalleOrdenCompra(int numDetalleOrdenCompra) {
        this.numDetalleOrdenCompra = numDetalleOrdenCompra;
    }

    public int getCantArticulosDOC() {
        return cantArticulosDOC;
    }

    public void setCantArticulosDOC(int cantArticulosDOC) {
        this.cantArticulosDOC = cantArticulosDOC;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }


    
    
}
