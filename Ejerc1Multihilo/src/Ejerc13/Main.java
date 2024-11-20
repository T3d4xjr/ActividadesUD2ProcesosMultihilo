/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de ratones: ");
        int numRatones = scanner.nextInt();

        Comedero comedero = new Comedero();
        List<RatonHilo> ratones = new ArrayList<>();

        // Crear e iniciar los hilos de los ratones
        for (int i = 0; i < numRatones; i++) {
            RatonHilo raton = new RatonHilo("Ratón " + i, comedero);
            ratones.add(raton);
            raton.start();
        }

        // Esperar a que todos los ratones terminen
        for (RatonHilo raton : ratones) {
            try {
                raton.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        // Mostrar la comida total consumida
        System.out.println("Todos los ratones han terminado de comer.");
        System.out.println("Total de comida consumida: " + comedero.getComidaConsumida());
    }
}

