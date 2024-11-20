/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc15;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Introduce el número de ratones: ");
        int numRatones = scanner.nextInt();

        Comedero comedero = new Comedero();
        Cuidador cuidador = new Cuidador(comedero, 10); // El cuidador recarga si la comida es menor a 10
        cuidador.start();

        ArrayList<Raton> ratones = new ArrayList<>();

        for (int i = 0; i < numRatones; i++) {
            String nombreRaton = "Ratón " + i;
            int tiempoEnComer = (1 + random.nextInt(3)) * 1000; // Entre 1 y 3 segundos
            int unidadesComida = 1 + random.nextInt(5); // Entre 1 y 5 unidades
            Raton raton = new Raton(nombreRaton, tiempoEnComer, unidadesComida, comedero);
            ratones.add(raton);
            raton.start();
        }

        // Espera a que todos los ratones terminen
        for (Raton raton : ratones) {
            try {
                raton.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        // Detiene al cuidador
        cuidador.interrupt();
        try {
            cuidador.join();
        } catch (InterruptedException e) {
            System.out.println("El cuidador no pudo finalizar correctamente.");
        }

        System.out.println("Todos los ratones han terminado de comer.");
    }
}
