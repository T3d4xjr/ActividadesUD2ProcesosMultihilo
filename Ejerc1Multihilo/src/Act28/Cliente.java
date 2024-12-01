/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act28;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
    private final int id;
    private final Semaphore clientes;
    private final Semaphore sillas;
    private final Semaphore barbero;

    public Cliente(int id, Semaphore clientes, Semaphore sillas, Semaphore barbero) {
        this.id = id;
        this.clientes = clientes;
        this.sillas = sillas;
        this.barbero = barbero;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente "+id+" llega a la barbería.");
            // Intentar ocupar una silla en la sala de espera
            if (sillas.tryAcquire()) {
                System.out.println("Cliente "+id+"  se sienta en la sala de espera.");
                // Indicar al barbero que hay un cliente esperando
                clientes.release();
                // Despertar al barbero si está dormido
                barbero.release();
            } else {
                System.out.println("Cliente "+id+"  se va porque no hay sillas disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Cliente "+id+"  tuvo un problema.");
        }
    }
}
