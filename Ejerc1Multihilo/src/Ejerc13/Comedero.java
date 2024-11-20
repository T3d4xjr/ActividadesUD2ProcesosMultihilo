/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc13;

public class Comedero {
    private int comidaConsumida;

    public Comedero() {
        this.comidaConsumida = 0;
    }

    public synchronized void consumirComida(int cantidad) {
        comidaConsumida += cantidad;
        System.out.println("Comida consumida actual: " + comidaConsumida);
    }

    public int getComidaConsumida() {
        return comidaConsumida;
    }
}
