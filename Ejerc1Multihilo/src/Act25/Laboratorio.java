/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act25;
import java.util.concurrent.Semaphore;

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

    // Método para que un científico salga de la sala A
    public void cambiarSala(int cientificoId) {
        try {
            System.out.println("El científico " + cientificoId + " espera para entrar en la sala B.");
            // El científico intenta entrar en la sala B
            salaB.acquire();
            
            salaA.release();
            
            System.out.println("El científico " + cientificoId + " ha salido de la sala A.");
            // Cuando entra a la sala B
            System.out.println("El científico " + cientificoId + " ha entrado en la sala B.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // El científico ha terminado en la sala A, por lo que libera el semáforo
        
    }

    // Método para que un científico salga de la sala B
    public void salirSalaB(int cientificoId) {
        // El científico ha terminado en la sala B, por lo que libera el semáforo
        salaB.release();
        System.out.println("El científico " + cientificoId + " ha salido de la sala B.");
    }
}
