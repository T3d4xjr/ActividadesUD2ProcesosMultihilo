/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc7;

import java.util.ArrayList;

/**
 *
 * @author DAM1
 */
public class RatonStates  extends Thread{
    private String nombre;
  private int cuentaComer; 
  private static int comidaConsumida =0;
  public  RatonStates(String nombre,int cuentaComer,int comidaConsumida)
    {
        super();
        this.nombre=nombre;
        this.cuentaComer=cuentaComer;
        this.comidaConsumida=comidaConsumida;
    }
    @Override
    public  void run()
    {
        
        try {
           
            System.out.println("El raton " +nombre+ " ha empezado a comer");
            Thread.sleep(cuentaComer*1000);
            comidaConsumida++;
            System.out.println("El raton " +nombre+ " ha terminado de comer");
            
        } catch (InterruptedException e) {
            System.err.println("No ha encontrardo el nombre");
        }
    }

    public static int getComidaConsumida() {
        return comidaConsumida;
    }
    
    public static void main(String[] args) throws InterruptedException {
        RatonStates mickey =new RatonStates("Mickey", 6,0);   
        
        mickey.start();
        
        ArrayList<String> estado =new ArrayList<>();
        
        while (mickey.isAlive()) {
        estado.add(mickey.getState().toString());
        Thread.sleep(1000);
        }
        mickey.join();
        
        
        System.out.println("Estados del hilo: " + estado);
        System.out.println("Comida consumida:" +RatonStates.getComidaConsumida());
        
        
    }
}
