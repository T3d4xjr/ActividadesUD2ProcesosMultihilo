/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act25;

public class Main {
    public static void main(String[] args) {
        Laboratorio laboratorio = new Laboratorio();

        // Crear e iniciar 10 hilos (científicos)
        for (int i = 1; i <= 10; i++) {
            new Cientifico(i, laboratorio).start();
        }
    }
}
