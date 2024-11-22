/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc15;

public class Comedero {
    private int comidaActual;

    public Comedero() {
        this.comidaActual = 0; 
    }

    public synchronized boolean consumirComida(String nombreRaton, int cantidad) {
        while (comidaActual < cantidad) {
            System.out.println(nombreRaton + " está esperando comida suficiente.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(nombreRaton + " fue interrumpido.");
                return false;
            }
        }
        comidaActual -= cantidad;
        System.out.println(nombreRaton + " consumió " + cantidad + " unidades de comida. Comida restante: " + comidaActual);
        return true;
    }

    public synchronized void recargarComida(int cantidad) {
        comidaActual += cantidad;
        System.out.println("Cuidador recargó " + cantidad + " unidades de comida. Comida actual: " + comidaActual);
        notifyAll();
    }

    public synchronized int getComidaActual() {
        return comidaActual;
    }
}
