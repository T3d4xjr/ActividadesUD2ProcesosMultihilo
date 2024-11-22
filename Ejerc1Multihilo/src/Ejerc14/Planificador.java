/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc14;

public class Planificador extends Thread {
    private final ListaTareas listaTareas;
    private final int numTareas;

    public Planificador(ListaTareas listaTareas, int numTareas) {
        this.listaTareas = listaTareas;
        this.numTareas = numTareas;
    }

    @Override
    public void run() {
        for (int i = 0; i < numTareas; i++) {
            String tarea = "Tarea " + i;
            listaTareas.añadirTarea(tarea);
        }
    }
}
