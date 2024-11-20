/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc13;

public class RatonHilo extends Thread {
    private String nombre;
    private Comedero comedero;

    public RatonHilo(String nombre, Comedero comedero) {
        this.nombre = nombre;
        this.comedero = comedero;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " empieza a comer.");
            Thread.sleep(3000); // Tiempo de comida: 3 segundos
            comedero.consumirComida(1); // Cada ratón consume 1 unidad de comida
            System.out.println(nombre + " ha terminado de comer.");
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }
    }
}
