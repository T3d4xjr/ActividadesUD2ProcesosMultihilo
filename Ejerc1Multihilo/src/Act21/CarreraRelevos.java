/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act21;

public class CarreraRelevos {
    public static void main(String[] args) {
        // Crear los testigos (uno por equipo)
        Testigo[] testigos = new Testigo[4];
        for (int i = 0; i < 4; i++) {
            testigos[i] = new Testigo();
        }

        // Crear los equipos y sus atletas
        Equipo[] equipos = new Equipo[4];
        for (int i = 0; i < 4; i++) {
            String nombreEquipo = "Equipo " + (i + 1);
            equipos[i] = new Equipo(nombreEquipo, testigos[i]);
        }

        // Mensajes de inicio
        System.out.println("Preparados...");
        System.out.println("Listos...");
        System.out.println("¡Bang!");

        long tiempoInicioCarrera = System.currentTimeMillis();

        // Crear y ejecutar los hilos de los equipos
        Thread[] hilosEquipos = new Thread[4];
        for (int i = 0; i < 4; i++) {
            hilosEquipos[i] = equipos[i];  // Asignamos directamente el equipo, ya que ahora extiende Thread
            hilosEquipos[i].start();
        }

        // Esperar a que todos los equipos terminen
        for (int i = 0; i < 4; i++) {
            try {
                hilosEquipos[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo del equipo fue interrumpido.");
            }
        }

        long tiempoFinCarrera = System.currentTimeMillis();

        // Determinar el equipo ganador
        Equipo ganador = equipos[0];
        for (Equipo equipo : equipos) {
            if (equipo.getTiempoTotal() < ganador.getTiempoTotal()) {
                ganador = equipo;
            }
        }

        // Mostrar los resultados
        System.out.println("\nTiempo total de la carrera: " + (tiempoFinCarrera - tiempoInicioCarrera) + " ms.");
        System.out.println("Equipo ganador: " + ganador.getNombre() + " con un tiempo de " + ganador.getTiempoTotal() + " ms.");
    }
}

