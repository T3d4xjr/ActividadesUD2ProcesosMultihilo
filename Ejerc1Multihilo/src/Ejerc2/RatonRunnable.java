package Ejerc2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tedax
 */
public class RatonRunnable implements Runnable{
    private String nombre;
   private int cuentaComer; 
     public  RatonRunnable(String nombre,int cuentaComer)
    {
        
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
        
        RatonRunnable fievel =new RatonRunnable("Fievel", 4);
        RatonRunnable jerry =new RatonRunnable("Jerry", 5);
        RatonRunnable pinky =new RatonRunnable("Pinky", 3);
        RatonRunnable mickey =new RatonRunnable("Mickey", 6);
        
        new Thread(fievel).start();
        new Thread(jerry).start();
        new Thread(pinky).start();
        new Thread(mickey).start();
       
    }
}
