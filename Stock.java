/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gp.stock;

import java.util.Scanner;
import modarticulos.Articulos;
import moddemanda.Demanda;
import modinventario.CGI;
import modinventario.LoteEOQ;
import modinventario.LoteMPR;

/**
 *
 * @author f2
 */
public class Stock {

    public static void main(String[] args) {
        
        
        
       
        
        
        Scanner scanner = new Scanner(System.in);
        
        Articulos elec1 = new Articulos(1236, "electrodomestico", "producto linea blanca");
        Articulos elec2 = new Articulos(1237, "electrodomestico", "producto linea blanca");
        Articulos elec3 = new Articulos(1238, "electrodomestico", "producto linea blanca");
        Articulos elec4 = new Articulos(1239, "electrodomestico", "producto linea blanca");
        Articulos elec5 = new Articulos(12310, "electrodomestico", "producto linea blanca");
        
        Articulos[] vector1 = new Articulos[2000];
        
        vector1[0] = elec1;
        vector1[1] = elec2;
        vector1[2] = elec3;
        vector1[3] = elec4;
        vector1[4] = elec5;
        
        int contador = 0;
        int acumulador = 0;
        int bandera = 1;
        
        while (bandera == 1) {
        int i = 1;
       // Articulos[] vector1 = new Articulos[2000];
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Ingrese Codigo del Producto: ");
        //vector1[i].codigo = scanner.nextInt();
        for(i=1;i<=5;i++){
            
        
        System.out.println("Codigo: "+vector1[i].codigo);
        System.out.println("Codigo: "+vector1[i].nombre);
        System.out.println("Codigo: "+vector1[i].descripcion);
             }
        bandera = 0;
        
        
        Demanda dema1 = new Demanda(12, 3, 45);
        dema1.Ventas();
        
       
        
    }
        
        
        
        
        
        
         System.out.println("Hello Users!");
        
        while(true){
         int nro = 0;
         System.out.println(" Selecciona el Modelo de Inventario: ");
         System.out.println(" 1: CGI    ");
         System.out.println(" 2: TAMAÑO FIJO DE LOTE - EOQ; ");
         System.out.println(" 3: TAMAÑO FIJO DE LOTE - MPR "); 
         
         
         switch (nro){
             case 1: 
                  
                  System.out.print("Ingreso de Datos:    D, cp, ca, P  ");
                 
                  double D = scanner.nextDouble();
                  double cp = scanner.nextDouble();
                  double ca = scanner.nextDouble();
                  double P = scanner.nextDouble();
                  
                  CGI cgi1 = new CGI( D,  cp,  ca,  P);
        
             
                 break;
             case 2:
                 
                  System.out.print("Ingreso de Datos: cpi, cai, L, n, t, D");
                  
                  double cpI = scanner.nextDouble();
                  double caI= scanner.nextDouble();
                  double L = scanner.nextDouble();
                  double n = scanner.nextDouble();
                  double t = scanner.nextDouble();
                  double DI= scanner.nextDouble();
                  
                  LoteEOQ eoq1 = new LoteEOQ( cpI, caI, L, n, t, DI);
                 
                 
                 
                 break;

             case 3:
                 
                 System.out.print("Ingreso de Datos: cpi, cai, L, n, t, D");
                  
                 double k = scanner.nextDouble();
                 double cpII = scanner.nextDouble();
                 double caII = scanner.nextDouble();
                 double tI = scanner.nextDouble();
                 double DII = scanner.nextDouble();
                 double LI = scanner.nextDouble();
                 
                 LoteMPR mpr1 = new LoteMPR(k, cpII, caII, tI, DII, LI);
                 
                 
                 
                 
                 
                 
                 break;
             default:
                 break;
             
             
         }
            
        
        //String Modelo = null;
        
        
        //Scanner scanner = new Scanner(System.clearProperty(Modelo));
        //Modelo = scanner.nextLine();
        
        
            
        }
    
    
        
            
        
            
  }  
    
}
