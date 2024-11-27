/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act18;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Comedero {
    private int comidaActual;
    final Lock lock = new ReentrantLock();
    final Condition comidaDisponible = lock.newCondition();
    private final Condition ratonComiendo = lock.newCondition();
    private boolean hayRatonComiendo = false;

    public Comedero() {
        this.comidaActual = 0;
    }

    public void consumirComida(String nombreRaton, int unidades, int tiempoEnComer) {
        lock.lock();
        try {
            while (hayRatonComiendo) {
                ratonComiendo.await(); // Espera hasta que no haya ningún ratón comiendo
            }
            hayRatonComiendo = true;

            while (comidaActual < unidades) {
                System.out.println("No hay suficiente comida para " + nombreRaton + ". Comida disponible: " + comidaActual);
                comidaDisponible.signal(); // Despierta al cuidador
                comidaDisponible.await(); // Espera a que el cuidador recargue comida
            }

            System.out.println(nombreRaton + " ha empezado a comer.");
            Thread.sleep(tiempoEnComer); // Simula el tiempo que tarda en comer
            comidaActual -= unidades;
            System.out.println(nombreRaton + " ha terminado de comer.");
            System.out.println("Comida restante: " + comidaActual);

            hayRatonComiendo = false;
            ratonComiendo.signal(); // Notifica a otros ratones que pueden empezar a comer

        } catch (InterruptedException e) {
            System.out.println(nombreRaton + " fue interrumpido mientras comía.");
        } finally {
            lock.unlock();
        }
    }

    public void recargarComida(int cantidad) {
        lock.lock();
        try {
            comidaActual += cantidad;
            System.out.println("Cuidador recargó " + cantidad + " unidades de comida. Comida actual: " + comidaActual);
            comidaDisponible.signalAll(); // Despierta a todos los ratones esperando comida
        } finally {
            lock.unlock();
        }
    }

    public int getComidaActual() {
        lock.lock();
        try {
            return comidaActual;
        } finally {
            lock.unlock();
        }
    }
}
