/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc22;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Impresora {
    private final Lock lock = new ReentrantLock();
    private final Condition impresoraLibre = lock.newCondition();
    private boolean ocupada = false;

    public void imprimir(int idOrdenador, int tiempoImpresion) {
        
        /**
        lock.lock();
        try {
            // Espera si la impresora está ocupada
            while (ocupada) {
                impresoraLibre.await();
            }

            // Marca la impresora como ocupada
            ocupada = true;
            System.out.println("El ordenador " + idOrdenador + " ha comenzado a imprimir.");

            // Simula el tiempo de impresión
            Thread.sleep(tiempoImpresion);

            System.out.println("El ordenador " + idOrdenador + " ha terminado de imprimir.");

            // Libera la impresora
            ocupada = false;
            impresoraLibre.signal(); // Notifica a otros hilos que la impresora está disponible

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El ordenador " + idOrdenador + " fue interrumpido.");
        } finally {
            lock.unlock();
        }
        * */
        
        System.out.println("El ordenador "+idOrdenador+" listo para imprimir");
        lock.lock();
        try {
            System.out.println("El ordenador " +idOrdenador+" ha comenzado a imprimir ");
            Thread.sleep(tiempoImpresion);
            System.out.println("El ordenador " +idOrdenador+" ha terminado a imprimir ");
        } catch (InterruptedException e) {
            System.out.println("El ordenador " + idOrdenador + " fue interrumpido.");
        }finally{
        lock.unlock();
        }
    }
}

