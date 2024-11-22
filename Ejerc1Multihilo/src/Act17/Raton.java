/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act17;

/**
 *
 * @author DAM1
 */
public class Raton extends Thread {
    private final String nombre;
    private final int tiempoEnComer;
    private final int unidadesComida; 
    private final Comedero comedero;

    public Raton(String nombre, int tiempoEnComer, int unidadesComida, Comedero comedero) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.unidadesComida = unidadesComida;
        this.comedero = comedero;
    }

    @Override
    public void run() {
        comedero.consumirComida(nombre, unidadesComida, tiempoEnComer);
    }
}
