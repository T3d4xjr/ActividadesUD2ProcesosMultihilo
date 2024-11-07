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
        Hilo n =new Hilo("MiHilo", 10);
        
        n.start();
        
        Thread.sleep(3000);
        
        System.out.println("Han pasado 3seg");
    }
}
