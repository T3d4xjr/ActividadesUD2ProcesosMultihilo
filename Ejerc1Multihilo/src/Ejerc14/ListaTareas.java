/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc14;

import java.util.ArrayList;

public class ListaTareas {
    private final ArrayList<String> tareas = new ArrayList<>();

    public synchronized void añadirTarea(String tarea) {
        tareas.add(tarea);
        System.out.println("P: " + tarea + " añadida");
        notify(); // Notifica a los hilos que esperan que hay una nueva tarea
    }

    public synchronized String obtenerTarea() throws InterruptedException {
        while (tareas.isEmpty()) {
            wait(); // Espera hasta que haya una tarea disponible
        }
        return tareas.remove(0); // Devuelve y elimina la primera tarea
    }
}
