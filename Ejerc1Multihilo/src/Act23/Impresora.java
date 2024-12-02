/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act23;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {

    // Crear un semáforo con 4 permisos (4 impresoras)
    private final Semaphore impresoras = new Semaphore(4);

    // Método para que los ordenadores intenten usar una impresora
    public void imprimir(int ordenadorNumero) {
        try {
            // El ordenador intenta obtener una impresora
            System.out.println("El ordenador " + ordenadorNumero + " ha enviado el documento. Esperando impresora.");
            
            // Adquirir una impresora (bloquea el hilo si no hay impresoras disponibles)
            impresoras.acquire();

            // El ordenador ha conseguido una impresora
            System.out.println("El ordenador " + ordenadorNumero + " ha comenzado a imprimir.");

            // Simular el tiempo de impresión entre 3 y 6 segundos
            Random rd =new Random();
            int tiempoImpreion=rd.nextInt(3000,6000);
            Thread.sleep(tiempoImpreion);

            // El ordenador ha terminado de imprimir
            System.out.println("El ordenador " + ordenadorNumero + " ha terminado de imprimir.");
        } catch (InterruptedException e) {
            System.out.println("El ordenador " + ordenadorNumero + " fue interrumpido.");
        } finally {
            // Liberar la impresora (un hilo puede usarla)
            impresoras.release();
        }
    }
}
