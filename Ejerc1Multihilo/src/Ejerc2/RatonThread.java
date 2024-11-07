/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc2;

/**
 *
 * @author tedax
 */
public class RatonThread extends Thread{
   private String nombre;
   private int cuentaComer; 
    public  RatonThread(String nombre,int cuentaComer)
    {
        super();
        this.nombre=nombre;
        this.cuentaComer=cuentaComer;
    }
    
   @Override
    public  void run()
    {
        try {
           
            System.out.println("El raton " +nombre+ " ha empezado a comer");
            Thread.sleep(cuentaComer*1000);
            System.out.println("El raton " +nombre+ " ha terminado de comer");
        } catch (InterruptedException e) {
            System.err.println("No ha encontrardo el nombre");
        }
    }
    public static void main(String[] args) {
        
        RatonThread fievel =new RatonThread("Fievel", 4);
        RatonThread jerry =new RatonThread("Jerry", 5);
        RatonThread pinky =new RatonThread("Pinky", 3);
        RatonThread mickey =new RatonThread("Mickey", 6);
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        
        
       
    }
}
