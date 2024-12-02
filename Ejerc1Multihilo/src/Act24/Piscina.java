/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act24;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Piscina {

  
    private final Semaphore aforo = new Semaphore(10);

    
    public void entrarPiscina(int personaId) {
        try {
            System.out.println("La persona " + personaId + " quiere entrar a la piscina.");
          
            aforo.acquire();

          
            System.out.println("La persona " + personaId + " ha entrado a la piscina.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    public void salirPiscina(int personaId) {
        
        aforo.release();
        System.out.println("La persona " + personaId + " ha salido de la piscina.");
    }

}
