/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act28;

public class Main {
    public static void main(String[] args) {
        // Crear la barbería con capacidad para 5 clientes en la sala de espera
        Barberia barberia = new Barberia(5);

        // Abrir la barbería
        barberia.abrir();

        // Simular la llegada de clientes aleatoriamente
        int clienteId = 1;
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 2000 + 1000)); // Llegada de clientes cada 1-3 segundos
                barberia.nuevoCliente(clienteId++);
            } catch (InterruptedException e) {
                System.out.println("Simulación interrumpida.");
                break;
            }
        }
    }
}
