/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act25;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Laboratorio {

    // Semáforo para la sala A (máximo 4 científicos)
    private final Semaphore salaA = new Semaphore(4);

    // Semáforo para la sala B (máximo 2 científicos)
    private final Semaphore salaB = new Semaphore(2);

    // Método para que un científico entre en la sala A
    public void entrarSalaA(int cientificoId) {
        try {
            System.out.println("El científico " + cientificoId + " espera para entrar en la sala A.");
            // El científico intenta entrar en la sala A
            salaA.acquire();

            // Cuando entra a la sala A
            System.out.println("El científico " + cientificoId + " ha entrado en la sala A.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un científico seleccione y prepare la muestra en la sala A
    public void seleccionarMuestra(int cientificoId) {
        try {
            // Simular que el científico tarda entre 3 y 6 segundos en preparar la muestra
            Random random = new Random();
            int tiempoPreparacion = random.nextInt(4) + 3; // Aleatorio entre 3 y 6 segundos
            Thread.sleep(tiempoPreparacion * 1000); // Convertir a milisegundos
            System.out.println("El científico " + cientificoId + " ha seleccionado la muestra en " + tiempoPreparacion + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un científico salga de la sala A
    public void salirSalaA(int cientificoId) {
        // El científico ha terminado en la sala A, por lo que libera el semáforo
        salaA.release();
        System.out.println("El científico " + cientificoId + " ha salido de la sala A.");
    }

    // Método para que un científico entre en la sala B
    public void entrarSalaB(int cientificoId) {
        try {
            System.out.println("El científico " + cientificoId + " espera para entrar en la sala B.");
            // El científico intenta entrar en la sala B
            salaB.acquire();

            // Cuando entra a la sala B
            System.out.println("El científico " + cientificoId + " ha entrado en la sala B.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un científico analice la muestra en la sala B
    public void analizarMuestra(int cientificoId) {
        try {
            // Simular que el científico tarda entre 2 y 4 segundos en analizar la muestra
            Random random = new Random();
            int tiempoAnalisis = random.nextInt(3) + 2; // Aleatorio entre 2 y 4 segundos
            Thread.sleep(tiempoAnalisis * 1000); // Convertir a milisegundos
            System.out.println("El científico " + cientificoId + " ha analizado la muestra en " + tiempoAnalisis + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un científico salga de la sala B
    public void salirSalaB(int cientificoId) {
        // El científico ha terminado en la sala B, por lo que libera el semáforo
        salaB.release();
        System.out.println("El científico " + cientificoId + " ha salido de la sala B.");
    }
}
