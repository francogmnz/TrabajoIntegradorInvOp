/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modinventario;
import java.util.Scanner;
import modarticulos.Articulos;
import moddemanda.Demanda;
import modinventario.CGI;
/**
 *
 * @author f2
 */
public class CGI {
    
   
    private double P;
    private double Q;
    private double ca;
    private double cp;
    private double D;

    public CGI(double D, double ca, double cp, double P) {
       
        this.P = P;
        this.Q = Q;
        this.ca = ca;
        this.cp = cp;
        this.D = D;
    }
    
    public void calcularCGI(int P, int Q, int ca, int cp){
        double costCompra = P*Q;
        double costAlmacenamiento = ca* Q/2;
        double costPedido = cp*D/Q;
        
        double CGI;
        
        CGI = costCompra + costAlmacenamiento + costPedido;
        
        return;
        
        
        
    }
    
    
    
    


    public void setP(int P) {
        this.P = P;
    }

    public void setQ(int Q) {
        this.Q = Q;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setD(int D) {
        this.D = D;
    }

    public double getP() {
        return P;
    }

    public double getQ() {
        return Q;
    }

    public double getCa() {
        return ca;
    }

    public double getCp() {
        return cp;
    }

    public double getD() {
        return D;
    }
    
}
