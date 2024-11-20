/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc15;

import java.util.Random;

public class Cuidador extends Thread {
    private final Comedero comedero;
    private final int limiteMinimo; // Límite mínimo para activar la recarga

    public Cuidador(Comedero comedero, int limiteMinimo) {
        this.comedero = comedero;
        this.limiteMinimo = limiteMinimo;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000); // Verifica cada segundo
                if (comedero.getComidaActual() < limiteMinimo) {
                    int cantidadRecarga = 20 + random.nextInt(11); // Entre 20 y 30
                    comedero.recargarComida(cantidadRecarga);
                }
            } catch (InterruptedException e) {
                System.out.println("El cuidador fue interrumpido.");
                break; // Finaliza el hilo
            }
        }
    }
}
