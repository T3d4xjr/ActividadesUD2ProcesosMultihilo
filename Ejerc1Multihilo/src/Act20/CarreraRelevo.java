/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act20;

public class CarreraRelevo {
    public static void main(String[] args) {
        // Crear el testigo
        Testigo testigo = new Testigo();

        // Crear los atletas
        Atleta[] atletas = {
            new Atleta("Atleta 1", testigo),
            new Atleta("Atleta 2", testigo),
            new Atleta("Atleta 3", testigo),
            new Atleta("Atleta 4", testigo)
        };

        // Mensajes de inicio
        System.out.println("Preparados...");
        System.out.println("Listos...");
        System.out.println("¡Bang!");

        long tiempoInicioCarrera = System.currentTimeMillis();

        // Crear y ejecutar los hilos de forma secuencial
        for (int i = 0; i < atletas.length; i++) {
            atletas[i].start(); // Iniciar el hilo

            // Asegurar que un atleta no comience hasta que el anterior termine
            try {
                atletas[i].join();
            } catch (InterruptedException e) {
                System.out.println("Un hilo fue interrumpido.");
            }
        }

        long tiempoFinCarrera = System.currentTimeMillis();
        // Mostrar el tiempo total de la carrera
        System.out.println("Tiempo total de la carrera (millis): " + (tiempoFinCarrera - tiempoInicioCarrera));
    }
}

