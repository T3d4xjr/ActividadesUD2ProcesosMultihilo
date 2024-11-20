/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc14;

public class Desarrollador extends Thread {
    private final ListaTareas listaTareas;
    private final int numTareas;

    public Desarrollador(ListaTareas listaTareas, int numTareas) {
        this.listaTareas = listaTareas;
        this.numTareas = numTareas;
    }

    @Override
    public void run() {
        for (int i = 0; i < numTareas; i++) {
            try {
                String tarea = listaTareas.obtenerTarea();
                System.out.println("D: " + tarea + " recibida");
            } catch (InterruptedException e) {
                System.out.println("El desarrollador fue interrumpido.");
            }
        }
        System.out.println("Ya no quedan tareas por leer.");
    }
}
