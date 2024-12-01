/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act28;

import java.util.concurrent.Semaphore;

public class Barberia {
    private final Semaphore clientes; // Contador de clientes en la sala de espera
    private final Semaphore sillas;  // Sillas disponibles en la sala de espera
    private final Semaphore barbero; // Estado del barbero (despierto o dormido)

    public Barberia(int capacidadSalaDeEspera) {
        this.clientes = new Semaphore(0); // Inicialmente no hay clientes
        this.sillas = new Semaphore(capacidadSalaDeEspera); // Número de sillas disponibles
        this.barbero = new Semaphore(0); // Barbero dormido inicialmente
    }

    public void abrir() {
        // Iniciar el barbero
        Barbero barberoThread = new Barbero(clientes, sillas, barbero);
        barberoThread.start();
    }

    public void nuevoCliente(int id) {
        // Crear un nuevo cliente y lanzarlo como un hilo
        Cliente clienteNuevo = new Cliente(id, clientes, sillas, barbero);
        clienteNuevo.start();
    }
}
