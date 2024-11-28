/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act23;


public class Main {
    public static void main(String[] args) {
        // Crear la instancia de Impresora
        Impresora impresora = new Impresora();

        // Crear e iniciar 10 hilos (ordenadores)
        for (int i = 1; i <= 10; i++) {
            new Ordenador(i, impresora).start();
        }
    }
}

