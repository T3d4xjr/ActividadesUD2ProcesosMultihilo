/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDemonios;

/**
 *
 * @author DAM1
 */
public class HiloInfinito extends Thread{
    private boolean loop;
    
    public HiloInfinito(String nombre){
        super(nombre);
        
        this.loop =true;
    }
    public void termina(){
     this.loop=false;
    }
    @Override
    public void run (){
        
        while (loop) {       
            
            try {
                System.out.println(this.getName());
                Thread.sleep(500);
                
            } catch(InterruptedException ex) {
            }
        }
    }
}
