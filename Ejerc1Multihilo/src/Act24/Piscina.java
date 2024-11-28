/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act24;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Piscina {

    // Semáforo que controla el aforo de la piscina (máximo 10 personas)
    private final Semaphore aforo = new Semaphore(10);

    // Método para que una persona intente entrar a la piscina
    public void entrarPiscina(int personaId) {
        try {
            System.out.println("La persona " + personaId + " quiere entrar a la piscina.");
            // Intentar adquirir un permiso del semáforo
            aforo.acquire();

            // Si consigue entrar, notificarlo
            System.out.println("La persona " + personaId + " ha entrado a la piscina.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que una persona salga de la piscina
    public void salirPiscina(int personaId) {
        // Liberar el permiso para que otra persona pueda entrar
        aforo.release();
        System.out.println("La persona " + personaId + " ha salido de la piscina.");
    }

    // Método para simular el tiempo de estancia de una persona en la piscina
    public void simularEstancia(int personaId) {
        try {
            // Simular que la persona está en la piscina entre 5 y 10 segundos
            Random random = new Random();
            int tiempoEstancia = random.nextInt(6) + 5; // 5 a 10 segundos
            Thread.sleep(tiempoEstancia * 1000);  // Convertir a milisegundos
            System.out.println("La persona " + personaId + " ha pasado " + tiempoEstancia + " segundos en la piscina.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
