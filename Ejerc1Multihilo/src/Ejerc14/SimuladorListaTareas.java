/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc14;

import java.util.Scanner;

public class SimuladorListaTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de tareas: ");
        int numTareas = scanner.nextInt();

        ListaTareas listaTareas = new ListaTareas();

        Planificador planificador = new Planificador(listaTareas, numTareas);
        Desarrollador desarrollador = new Desarrollador(listaTareas, numTareas);

        planificador.start();
        desarrollador.start();

        try {
            planificador.join();
            desarrollador.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}
