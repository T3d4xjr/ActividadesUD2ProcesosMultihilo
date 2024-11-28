/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act20;


import java.util.Random;

public class Atleta  extends Thread{
    private final String nombre;
    private final Testigo testigo;

    public Atleta(String nombre, Testigo testigo) {
        super(nombre);
        this.nombre = nombre;
        this.testigo = testigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        
        testigo.tomar(nombre);

        try {
         
            int tiempoCorrer = new Random().nextInt(3000) + 4000;
            System.out.println(nombre + " empieza a correr...");
            Thread.sleep(tiempoCorrer);
            System.out.println(nombre + " terminó de correr en " + tiempoCorrer + " ms.");
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido mientras corría.");
        } finally {
            testigo.soltar(nombre);
        }
    }
   
}

