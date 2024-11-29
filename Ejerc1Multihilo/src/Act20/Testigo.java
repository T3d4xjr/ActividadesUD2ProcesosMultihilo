/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act20;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testigo {
    private final Lock lock = new ReentrantLock();
    private final Condition testigoDisponible = lock.newCondition();
    private boolean disponible = true;

    // Método para tomar el testigo
    public void tomar(String nombreAtleta) {
        lock.lock();
        try {
            while (!disponible) {
                testigoDisponible.await();
            }
            disponible = false; // Testigo en uso
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    // Método para soltar el testigo
    public void soltar(String nombreAtleta) {
        lock.lock();
        try {
            disponible = true; // Testigo disponible
            testigoDisponible.signal(); // Notificar que el testigo está disponible
        } finally {
            lock.unlock();
        }
    }
}

