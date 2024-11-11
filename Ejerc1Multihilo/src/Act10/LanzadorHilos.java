/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act10;

import java.util.Random;

/**
 *
 * @author DAM1
 */
public class LanzadorHilos {
    public static void main(String[] args) {
        HilosOperaciones h1 =new HilosOperaciones(2, "1");
        HilosOperaciones h2 =new HilosOperaciones(3,"2");
        HilosOperaciones h3 =new HilosOperaciones(5,"3");
        
        h1.start();
        h2.start();
        h3.start();
        
        Random rd =new Random();
        
        int tiempoAleatorio=5 +rd.nextInt(6);
        
        
        
        try {
            Thread.sleep(tiempoAleatorio*1000);
        } catch (InterruptedException e) {
        }
        
        System.out.println("Tiempo agotado");
        
        h1.detener();
        h2.detener();
        h3.detener();
        
        
        
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
        }
    }
}
