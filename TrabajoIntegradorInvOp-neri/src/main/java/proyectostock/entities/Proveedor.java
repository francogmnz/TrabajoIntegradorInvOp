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
public class Proveedor {
    
    private String nombreProveedor;
    private int codProveedor;
    private int celular;

    public Proveedor(String nombreProveedor, int codProveedor, int celular) {
        this.nombreProveedor = nombreProveedor;
        this.codProveedor = codProveedor;
        this.celular = celular;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }


    
    
}


