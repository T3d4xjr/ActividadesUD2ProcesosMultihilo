/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author DAM1
 */
public class Comedero {
    private int comidaActual;
    private final Lock lock =new ReentrantLock();

    public Comedero() {
        this.comidaActual = 0; 
    }

    public void consumirComida(String nombreRaton, int unidades, int tiempoEnComer) {
        lock.lock(); // Bloquea el acceso
        try {
            if (comidaActual >= unidades) {
                System.out.println(nombreRaton + " ha empezado a comer.");
                Thread.sleep(tiempoEnComer); // Simula el tiempo que tarda en comer
                comidaActual -= unidades;
                System.out.println(nombreRaton + " ha terminado de comer.");
                System.out.println("Comida restante: " + comidaActual);
            } else {
                System.out.println("No hay suficiente comida para " + nombreRaton + ". Comida disponible: " + comidaActual);
            }
        } catch (InterruptedException e) {
            System.out.println(nombreRaton + " fue interrumpido mientras comía.");
        } finally {
            lock.unlock(); // Asegura liberar el cerrojo
        }
    }

    public  void recargarComida(int cantidad) {
        lock.lock();
        try {
          comidaActual += cantidad;
        System.out.println("Cuidador recargó " + cantidad + " unidades de comida. Comida actual: " + comidaActual);
          
        } finally {
            lock.unlock();
        }
        
    }

    public synchronized int getComidaActual() {
         lock.lock();
        try {
            return comidaActual;
        } finally {
            lock.unlock(); 
        }
    }
}
