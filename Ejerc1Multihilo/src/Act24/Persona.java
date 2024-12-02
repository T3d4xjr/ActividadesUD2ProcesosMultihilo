/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act24;

import java.util.Random;

public class Persona extends Thread {
    private final int personaId;
    private final Piscina piscina;
    
    public Persona(int personaId, Piscina piscina) {
        this.personaId = personaId;
        this.piscina = piscina;
    }
    public void simularEstancia(int personaId) {
        try {
          
            Random random = new Random();
            int tiempoEstancia = random.nextInt(6) + 5;
            Thread.sleep(tiempoEstancia * 1000);
            System.out.println("La persona " + personaId + " ha pasado " + tiempoEstancia + " segundos en la piscina.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        
        Random random = new Random();
        int vecesAEntrar = random.nextInt(3) + 1; 

        for (int i = 0; i < vecesAEntrar; i++) {
            piscina.entrarPiscina(personaId); 
            simularEstancia(personaId);
            piscina.salirPiscina(personaId);  
        }
    }
}
