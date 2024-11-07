/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc6;

/**
 *
 * @author DAM1
 */
public class RatonVarComp extends Thread{
  private String nombre;
  private int cuentaComer; 
  private static int comidaConsumida =0;
  public  RatonVarComp(String nombre,int cuentaComer,int comidaConsumida)
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
        
        RatonVarComp fievel =new RatonVarComp("Fievel", 4,0);
        RatonVarComp jerry =new RatonVarComp("Jerry", 5,0);
        RatonVarComp pinky =new RatonVarComp("Pinky", 3,0);
        RatonVarComp mickey =new RatonVarComp("Mickey", 6,0);   
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        fievel.join();
        jerry.join();
        pinky.join();
        mickey.join();
        
        System.out.println("Comida consumida:" +RatonVarComp.getComidaConsumida());
    }
}
