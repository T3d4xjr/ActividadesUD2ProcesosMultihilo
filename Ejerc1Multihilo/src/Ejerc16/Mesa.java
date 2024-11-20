/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc16;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<String> ingredientesEnMesa = new ArrayList<>();
    private boolean ingredientesDisponibles = false;

    public synchronized void colocarIngredientes(String ingrediente1, String ingrediente2) {
        while (ingredientesDisponibles) {
            try {
                wait(); // Espera a que los ingredientes sean recogidos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ingredientesEnMesa.clear();
        ingredientesEnMesa.add(ingrediente1);
        ingredientesEnMesa.add(ingrediente2);
        ingredientesDisponibles = true;
        System.out.println("Chef coloca en la mesa: " + ingrediente1 + " y " + ingrediente2);
        notifyAll(); // Despierta a los ayudantes
    }

    public synchronized boolean recogerIngredientes(String ingredienteFijo) {
        while (!ingredientesDisponibles) {
            try {
                wait(); // Espera a que el chef coloque los ingredientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!ingredientesEnMesa.contains(ingredienteFijo)) {
            System.out.println(Thread.currentThread().getName() + " recoge los ingredientes: " + ingredientesEnMesa);
            ingredientesDisponibles = false;
            notifyAll(); // Despierta al chef
            return true;
        }
        return false; // Ingredientes no son compatibles con el ayudante
    }
}

