/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act21;

import java.util.Random;

public class Atleta extends Thread {
    private final Testigo testigo;

    public Atleta(String nombre, Testigo testigo) {
        super(nombre); // Configura el nombre del hilo
        this.testigo = testigo;
    }

    @Override
    public void run() {
        // Tomar el testigo antes de correr
        testigo.tomar(getName());

        try {
            // Simular el tiempo que tarda en correr (entre 4000 y 7000 ms)
            int tiempoCorrer = new Random().nextInt(3000) + 4000;
            System.out.println(getName() + " empieza a correr...");
            Thread.sleep(tiempoCorrer);
            System.out.println(getName() + " terminó de correr en " + tiempoCorrer + " ms.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " fue interrumpido mientras corría.");
        } finally {
            // Soltar el testigo después de correr
            testigo.soltar(getName());
        }
    }
}
