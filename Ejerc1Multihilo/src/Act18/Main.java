/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act18;


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
        Cuidador cuidador = new Cuidador(comedero, 10);
        cuidador.setDaemon(true);
        cuidador.start();

        ArrayList<Raton> ratones = new ArrayList<>();

        for (int i = 0; i < numRatones; i++) {
            String nombreRaton = "Ratón " + i;
            int tiempoEnComer = (1 + random.nextInt(3)) * 1000;
            int unidadesComida = 1 + random.nextInt(5);
            Raton raton = new Raton(nombreRaton, tiempoEnComer, unidadesComida, comedero);
            ratones.add(raton);
            raton.start();
        }
    }
}
