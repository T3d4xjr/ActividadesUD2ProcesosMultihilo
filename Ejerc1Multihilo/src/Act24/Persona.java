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

    @Override
    public void run() {
        // Cada persona puede entrar a la piscina entre 1 y 3 veces
        Random random = new Random();
        int vecesAEntrar = random.nextInt(3) + 1; // Aleatorio entre 1 y 3 veces

        for (int i = 0; i < vecesAEntrar; i++) {
            piscina.entrarPiscina(personaId);  // Intentar entrar en la piscina
            piscina.simularEstancia(personaId); // Simular estancia
            piscina.salirPiscina(personaId);    // Salir de la piscina
        }
    }
}
