/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act12;

/**
 *
 * @author tedax
 */
public class Persona extends Thread {
    private String nombre;
    private Cuenta cuenta;

    public Persona(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            cuenta.retirarDinero(nombre, 10);
        }
    }
}
