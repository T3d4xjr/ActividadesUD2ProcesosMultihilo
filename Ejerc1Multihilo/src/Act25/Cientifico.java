/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act25;

import java.util.Random;


public class Cientifico extends Thread {
    private final int cientificoId;
    private final Laboratorio laboratorio;

    // Constructor que recibe el ID del científico y el laboratorio
    public Cientifico(int cientificoId, Laboratorio laboratorio) {
        this.cientificoId = cientificoId;
        this.laboratorio = laboratorio;
    }
    public void seleccionarMuestra(int cientificoId) {
        try {
          
            Random random = new Random();
            int tiempoPreparacion = random.nextInt(4) + 3; // Aleatorio entre 3 y 6 segundos
            Thread.sleep(tiempoPreparacion * 1000); // Convertir a milisegundos
            System.out.println("El científico " + cientificoId + " ha seleccionado la muestra en " + tiempoPreparacion + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void analizarMuestra(int cientificoId) {
        try {
            
            Random random = new Random();
            int tiempoAnalisis = random.nextInt(3) + 2; // Aleatorio entre 2 y 4 segundos
            Thread.sleep(tiempoAnalisis * 1000); // Convertir a milisegundos
            System.out.println("El científico " + cientificoId + " ha analizado la muestra en " + tiempoAnalisis + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // El ciclo de trabajo de cada científico
        laboratorio.entrarSalaA(cientificoId);  // Intentar entrar en la sala A
        seleccionarMuestra(cientificoId);
      
        laboratorio.cambiarSala(cientificoId);
        
        analizarMuestra(cientificoId);
        laboratorio.salirSalaB(cientificoId);    // Salir de la sala B
    }
}
