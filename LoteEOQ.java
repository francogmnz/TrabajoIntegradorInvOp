/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modinventario;
import static java.lang.Math.sqrt;
import static java.awt.PageAttributes.MediaType.D;
import java.util.Scanner;
import modarticulos.Articulos;
import moddemanda.Demanda;
import modinventario.CGI;


/**
 *
 * @author f2
 */
public class LoteEOQ {
    
    private double cp;
    private double ca;
    private double L;
    private double n;
    private double t;
    private double D;

    public LoteEOQ(double cp, double ca, double L, double n, double t, double D) {
        this.cp = cp;
        this.ca = ca;
        this.L = L;
        this.n = n;
        this.t = t;
        this.D = D;
    }
    
    public void calcularLoteOptimo(double cp, double ca, double L, double n, double t, double D){
        
        double Q; 
        
        Q = sqrt(2*D*(cp/ca));
       
        
        
    }
    
    
     public void calcularPuntoReaprovisionamiento(double D, double Q){
        
        double t, n, PP; 
        
        t = D/Q;
        n = D/Q; 
        PP = D*L;
        
        System.out.println("NUMERO DE PEDIDOS: "+n);
         System.out.println("TIEMPO ENTRE PEDIDOS: "+t);
          System.out.println("PUNTO DE PEDIDO: "+PP);
    }
     
    
    
    
    
    
    

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setL(int L) {
        this.L = L;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setT(int t) {
        this.t = t;
    }

    public double getCp() {
        return cp;
    }

    public double getCa() {
        return ca;
    }

    public double getL() {
        return L;
    }

    public double getN() {
        return n;
    }

    public double getT() {
        return t;
    }

    public double getD() {
        return D;
    }


    
      
    
    
    
}
