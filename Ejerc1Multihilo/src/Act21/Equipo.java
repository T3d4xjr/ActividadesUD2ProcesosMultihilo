/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act21;

/**
 *
 * @author tedax
 */
public class Equipo extends Thread {
    private final String nombre;
    private final Testigo testigo;
    private final Atleta[] atletas;
    private long tiempoTotal;

    public Equipo(String nombre, Testigo testigo) {
        this.nombre = nombre;
        this.testigo = testigo;
        this.atletas = new Atleta[4];

        // Crear los atletas del equipo
        for (int i = 0; i < 4; i++) {
            atletas[i] = new Atleta(nombre + " - Atleta " + (i + 1), testigo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }

    @Override
    public void run() {
        long inicioEquipo = System.currentTimeMillis();
        for (Atleta atleta : atletas) {
            atleta.start(); // Iniciar al atleta
            try {
                atleta.join(); // Esperar a que termine
            } catch (InterruptedException e) {
                System.out.println("El atleta fue interrumpido.");
            }
        }
        tiempoTotal = System.currentTimeMillis() - inicioEquipo;
        System.out.println(nombre + " terminó en " + tiempoTotal + " ms.");
    }
}
