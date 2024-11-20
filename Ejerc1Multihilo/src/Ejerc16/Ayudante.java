/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc16;

public class Ayudante extends Thread {
    private final Mesa mesa;
    private final String ingredienteFijo;

    public Ayudante(Mesa mesa, String ingredienteFijo) {
        this.mesa = mesa;
        this.ingredienteFijo = ingredienteFijo;
        setName("Ayudante con " + ingredienteFijo);
    }

    @Override
    public void run() {
        while (true) {
            if (mesa.recogerIngredientes(ingredienteFijo)) {
                System.out.println(getName() + " está preparando un plato.");
                try {
                    Thread.sleep((1 + (int) (Math.random() * 3)) * 1000); // Simula el tiempo de preparación
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " terminó de preparar el plato.");
            }
        }
    }
}

