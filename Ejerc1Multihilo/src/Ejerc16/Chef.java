/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc16;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Chef extends Thread {
    private final Mesa mesa;
    private final List<String> ingredientes = Arrays.asList("verduras", "carne", "salsa");
    private final Random random = new Random();

    public Chef(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            String ingrediente1 = ingredientes.get(random.nextInt(3));
            String ingrediente2;
            do {
                ingrediente2 = ingredientes.get(random.nextInt(3));
            } while (ingrediente1.equals(ingrediente2)); // Asegura que sean diferentes

            mesa.colocarIngredientes(ingrediente1, ingrediente2);
        }
    }
}
