/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc22;

/**
 *
 * @author tedax
 */
import java.util.Random;

public class Ordenador extends Thread {
    private final int id;
    private final Impresora impresora;
    private final Random random = new Random();

    public Ordenador(int id, Impresora impresora) {
        this.id = id;
        this.impresora = impresora;
    }

    @Override
    public void run() {
        int tiempoImpresion = 3000 + random.nextInt(4000); // Tiempo aleatorio entre 3 y 6 segundos

        System.out.println("El ordenador " + id + " ha enviado el documento. Esperando impresora.");

        // Intentar imprimir
        impresora.imprimir(id, tiempoImpresion);

        System.out.println("El ordenador " + id + " ha terminado de imprimir.");
    }
}
