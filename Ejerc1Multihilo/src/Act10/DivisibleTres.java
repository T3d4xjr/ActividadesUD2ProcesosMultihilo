/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM1
 */
class DivisibleTres extends Thread{
    private  boolean detenido = false;
    private int condicion;

    public void detener(int condicion) {
        detenido = true;
        this.condicion=condicion;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 90; i++) {
            System.out.println("Hilo 2 muestra el número: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 2 fue interrumpido");
                return;
            }

            if (detenido && i % condicion == 0) {
                System.out.println("Hilo 2 cumple la condición de salida con el número " + i);
                break;
            }
        }
        System.out.println("Hilo 2 ha finalizado");
    }
}
