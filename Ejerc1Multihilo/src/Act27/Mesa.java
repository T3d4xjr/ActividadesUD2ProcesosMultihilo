/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act27;

import java.util.concurrent.Semaphore;

public class Mesa {
    private final Semaphore[] tenedores;
    private final int numFilosofos;

    public Mesa(int numFilosofos) {
        this.numFilosofos = numFilosofos;
        tenedores = new Semaphore[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1); // Cada tenedor es usado por un filósofo a la vez
        }
    }

    public void iniciarCena() {
        for (int i = 0; i < numFilosofos; i++) {
            Semaphore tenedorIzquierdo = tenedores[i];
            Semaphore tenedorDerecho = tenedores[(i + 1) % numFilosofos];
            Filosofo filosofo = new Filosofo(i, tenedorIzquierdo, tenedorDerecho);
            filosofo.start();
        }
    }
}
