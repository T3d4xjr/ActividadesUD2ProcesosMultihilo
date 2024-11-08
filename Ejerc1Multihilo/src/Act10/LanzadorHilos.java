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
        NumerosPares h1 =new NumerosPares();
        DivisibleTres h2 =new DivisibleTres();
        DivisibleCinco h3 = new DivisibleCinco();
        
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
