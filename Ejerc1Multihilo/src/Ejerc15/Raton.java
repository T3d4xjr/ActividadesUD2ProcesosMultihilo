/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc15;

public class Raton extends Thread {
    private final String nombre;
    private final int tiempoEnComer;
    private final int unidadesComida; 
    private final Comedero comedero;

    public Raton(String nombre, int tiempoEnComer, int unidadesComida, Comedero comedero) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.unidadesComida = unidadesComida;
        this.comedero = comedero;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " empieza a comer.");
            Thread.sleep(tiempoEnComer); // Simula el tiempo en comer
            comedero.consumirComida(nombre, unidadesComida);
            System.out.println(nombre + " terminó de comer.");
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido mientras comía.");
        }
    }
}
