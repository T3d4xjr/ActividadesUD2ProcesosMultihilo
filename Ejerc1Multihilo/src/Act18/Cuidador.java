package Act18;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

public class Cuidador extends Thread {
    private final Comedero comedero;
    private final int limiteMinimo;

    public Cuidador(Comedero comedero, int limiteMinimo) {
        this.comedero = comedero;
        this.limiteMinimo = limiteMinimo;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            comedero.lock.lock();
            try {
                while (comedero.getComidaActual() >= limiteMinimo) {
                    comedero.comidaDisponible.await(); // Espera a que un ratón despierte al cuidador
                }

                int cantidadRecarga = 20 + random.nextInt(11);
                comedero.recargarComida(cantidadRecarga);
            } catch (InterruptedException e) {
                System.out.println("El cuidador fue interrumpido.");
                break; // Finaliza el hilo
            } finally {
                comedero.lock.unlock();
            }
        }
    }
}
