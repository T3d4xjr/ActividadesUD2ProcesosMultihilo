/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act27;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filosofo extends Thread {
    private final int id;
    private final Semaphore tenedorIzquierdo;
    private final Semaphore tenedorDerecho;
    private final static Lock cogiendoTenedores =new ReentrantLock(true);

    public Filosofo(int id, Semaphore tenedorIzquierdo, Semaphore tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Pensar
                System.out.println("Filósofo "+id+" está pensando.");
                Random random = new Random();
                int tiempoPensado=random.nextInt(4)+3;
                Thread.sleep(tiempoPensado*1000);

                // Intentar tomar los tenedores
                System.out.println("Filósofo "+id+" está intentando tomar los tenedores.");
                
                cogiendoTenedores.lock();
                try {
                    // Aqui hay que modficiar para cuando todos los filosofos quieren coger el mismo tenedor.
                    tenedorIzquierdo.acquire();
                    
                    tenedorDerecho.acquire();
                } finally {
                    cogiendoTenedores.unlock();
                }
                // Comer
                System.out.println("Filósofo "+id+" está comiendo.");
                int tiempoComiendo=random.nextInt(4)+3;
                Thread.sleep(tiempoComiendo*1000);
                System.out.println("Filósofo "+id+" ha comido.");

                System.out.println("Filósofo "+id+" terminó de comer y soltó los tenedores.");
                // Soltar los tenedores
                tenedorIzquierdo.release();
                tenedorDerecho.release();
                
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
