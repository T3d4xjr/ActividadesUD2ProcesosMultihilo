/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act28;

import java.util.concurrent.Semaphore;

public class Barbero extends Thread {
    private final Semaphore clientes;   // Cuenta los clientes esperando
    private final Semaphore sillas;    // Controla el acceso a las sillas de la sala de espera
    private final Semaphore barbero;   // Indica si el barbero está disponible para trabajar

    public Barbero(Semaphore clientes, Semaphore sillas, Semaphore barbero) {
        this.clientes = clientes;
        this.sillas = sillas;
        this.barbero = barbero;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Esperar a que lleguen clientes
                clientes.acquire();
                // Un cliente se va de la sala de espera hacia la silla de servicio
                sillas.release();

                System.out.println("Barbero está atendiendo a un cliente.");
                Thread.sleep((int) (Math.random() * 3000 + 3000)); // Tiempo para pelar
                System.out.println("Barbero terminó de atender al cliente.");
                // Barbero vuelve a dormirse si no hay más clientes
            }
        } catch (InterruptedException e) {
            System.out.println("Barbero ha sido interrumpido.");
            
        }
    }
}
