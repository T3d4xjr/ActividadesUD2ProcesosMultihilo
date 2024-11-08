/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDemonios;

/**
 *
 * @author DAM1
 */
public class HilosMain {
    public static void main(String[] args) throws InterruptedException {
        
        /*
        Hilo h =new Hilo("Demonio", 100);
        
        h.setDaemon(true);//El demonio es un proceso qeu esta en segundo plano con una funcionalidad y funciona siempre que el programa este en ejecucion.
        
        h.start();
        
        Hilo h2 = new Hilo("MiHilo", 10);
        
        h2.start();
        
        Thread.sleep(3000);
        
        System.out.println("Han pasado 3seg");
        
        */
        
        HiloInfinito hi = new HiloInfinito("Demonio");
        
        hi.start();
        
        try {
            Thread.sleep(3000);
            hi.termina();
        } catch (Exception e) {
        }
        
        System.out.println("Han pasado 3 segundos");
        
        
    }
}
