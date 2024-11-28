/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act26;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Supermercado {

    // Semáforo que controla el acceso a las 4 cajas (máximo 4 clientes)
    private final Semaphore cajas = new Semaphore(4);

    // Método para que un cliente entre al supermercado
    public void entrarTienda(int clienteId) {
        System.out.println("El cliente " + clienteId + " ha entrado al supermercado.");
    }

    // Método para que un cliente espere una caja
    public void esperarCaja(int clienteId) {
        try {
            System.out.println("El cliente " + clienteId + " está esperando una caja.");
            // Intentar adquirir un permiso de las 4 cajas
            cajas.acquire();
            System.out.println("El cliente " + clienteId + " ha sido asignado a una caja.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que el cliente vaya a la caja
    public void irACaja(int clienteId) {
        try {
            // El cliente tarda entre 5 y 15 segundos en llegar a la caja
            Random random = new Random();
            int tiempoLlegada = random.nextInt(11) + 5; // Aleatorio entre 5 y 15 segundos
            Thread.sleep(tiempoLlegada * 1000); // Convertir a milisegundos
            System.out.println("El cliente " + clienteId + " ha llegado a la caja después de " + tiempoLlegada + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que el cliente pague en la caja
    public void pagarEnCaja(int clienteId) {
        try {
            // El cliente tarda entre 5 y 10 segundos en pagar
            Random random = new Random();
            int tiempoPago = random.nextInt(6) + 5; // Aleatorio entre 5 y 10 segundos
            Thread.sleep(tiempoPago * 1000); // Convertir a milisegundos
            System.out.println("El cliente " + clienteId + " ha pagado en la caja en " + tiempoPago + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un cliente salga de la caja
    public void salirDeCaja(int clienteId) {
        // El cliente ha terminado en la caja, por lo que libera el semáforo
        cajas.release();
        System.out.println("El cliente " + clienteId + " ha terminado de comprar y ha salido de la caja.");
    }
}
