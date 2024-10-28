/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerc1multihilo;

/**
 *
 * @author DAM1
 */
public class Raton {
    private String nombre;
    private int cuentaComer;
    
    public  Raton(String nombre,int cuentaComer)
    {
        this.nombre=nombre;
        this.cuentaComer=cuentaComer;
    }
    
    public  void Comer()
    {
        try {
           
            System.out.println("El raton " +nombre+ " ha empezado a comer");
            Thread.sleep(cuentaComer*1000);
            System.out.println("El raton " +nombre+ " ha terminado de comer");
        } catch (Exception e) {
            System.err.println("No ha encontrardo el nombre");
        }
    }
    public static void main(String[] args) {
        
        Raton fievel =new Raton("Fievel", 4);
        Raton jerry =new Raton("Jerry", 5);
        Raton pinky =new Raton("Pinky", 3);
        Raton mickey =new Raton("Mickey", 6);
        
        fievel.Comer();
        jerry.Comer();
        pinky.Comer();
        mickey.Comer();
        
        
        
       
    }
}
