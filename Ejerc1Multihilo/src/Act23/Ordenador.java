/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act23;

public class Ordenador extends Thread {
    private final int numero;
    private final Impresora impresora;

    // Constructor que recibe el número del ordenador y la impresora
    public Ordenador(int numero, Impresora impresora) {
        this.numero = numero;
        this.impresora = impresora;
    }

    @Override
    public void run() {
        // El ordenador intenta imprimir su documento
        impresora.imprimir(numero);
    }
}

