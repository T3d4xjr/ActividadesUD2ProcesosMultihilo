/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act20SinTestigo;

import java.util.Random;

public class Atleta {
    private String nombre;

    public Atleta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long correr() {
        try {
            
            int tiempoCorrer = new Random().nextInt(3000) + 4000;
            Thread.sleep(tiempoCorrer);
            return tiempoCorrer; 
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido mientras corría.");
            return 0;
        }
    }
}
