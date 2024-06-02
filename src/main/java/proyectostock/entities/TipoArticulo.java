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
public class TipoArticulo {
    
    private String nombreTipoArt;
    private int codigoTipoArt;
    
    public TipoArticulo(String nombreTipoArt, int codigoTipoArt) {
    this.nombreTipoArt = nombreTipoArt;
    this.codigoTipoArt = codigoTipoArt;
    }

    public String getNombreTipoArt() {
        return nombreTipoArt;
    }

    public void setNombreTipoArt(String nombreTipoArt) {
        this.nombreTipoArt = nombreTipoArt;
    }
    
    public int getCodigoTipoArt() {
        return codigoTipoArt;
    }

    public void setCodigoTipoArt(int codigoTipoArt) {
        this.codigoTipoArt = codigoTipoArt;
    }
    
    
    
}
