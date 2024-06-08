/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modinventario;

import static java.lang.Math.sqrt;
import java.util.Scanner;
import modarticulos.Articulos;
import moddemanda.Demanda;
import modinventario.CGI;
/**
 *
 * @author f2
 */
public class LoteMPR {
    
    private double k;
    private double cp;
    private double ca;
     private double t;
    private double D;
    private double L;

    public LoteMPR(double k, double cp, double ca, double t, double D, double L) {
        this.k = k;
        this.cp = cp;
        this.ca = ca;
        this.t = t;
        this.D = D;
        this.L = L;
    }
    
    public void calcularLoteOptimo(double k, double cp, double ca, double t, double D, double L){
        
        double Q;
        
        Q = sqrt(2*D*(cp/ca)*(1/(1-D/k)));
        
        
        
    }
    
     public void calcularPuntoReaprovisionamiento(double Q, double cp, double ca, double t, double D, double L, double n){
        
        double PP;
        
        t = sqrt(2/D*(cp/ca)*(1/(1-D/k)));
        n = D/Q;
        PP = D*L;
        
        
    }
    
    
    
    
    
    

    public void setK(int k) {
        this.k = k;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void setD(int D) {
        this.D = D;
    }

    public void setL(int L) {
        this.L = L;
    }


    
    
    
    
    
    
    
    
    
}
