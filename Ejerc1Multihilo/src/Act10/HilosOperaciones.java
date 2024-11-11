/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act10;

/**
 *
 * @author DAM1
 */
public class HilosOperaciones extends Thread {

    private boolean detenido = false;
    private int condicion;
    private String nombre;

    // Constructor de la clase
    public HilosOperaciones(int condicion,String nombre) {
        super();
        this.condicion = condicion;
        this.nombre =nombre;
    }

    public void detener() {
        detenido = true;
        
    }

    @Override
    public void run() {
        for (int i = 1; i <= 90; i++) {
            System.out.println("Hilo "+nombre+" muestra el número: " + i);

            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                System.out.println("Hilo "+nombre+" fue interrumpido");
                return;
            }

            // Verificar si debe detenerse el hilo
            if (detenido && i % condicion == 0) {
                System.out.println("Hilo" +nombre+"cumple la condición de salida con el número " + i);
                break;
            }
        }
        System.out.println("Hilo "+nombre+" ha finalizado");
    }
}
