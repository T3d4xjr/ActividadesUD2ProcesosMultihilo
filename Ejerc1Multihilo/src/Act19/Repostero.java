/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act19;

/**
 *
 * @author tedax
 */
import java.util.Random;

public class Repostero extends Thread {
    private final Mesa mesa;
    private final String[] ingredientes = {"harina", "azúcar", "huevos"};
    private final Random random = new Random();

    public Repostero(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            String ingrediente1 = ingredientes[random.nextInt(3)];
            String ingrediente2;
            do {
                ingrediente2 = ingredientes[random.nextInt(3)];
            } while (ingrediente1.equals(ingrediente2)); // Asegura que los ingredientes sean diferentes

            mesa.colocarIngredientes(ingrediente1, ingrediente2);
        }
    }
}
