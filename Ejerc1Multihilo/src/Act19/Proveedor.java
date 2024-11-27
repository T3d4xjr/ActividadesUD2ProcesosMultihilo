/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act19;


public class Proveedor extends Thread {
    private final Mesa mesa;
    private final String ingredienteFijo;

    public Proveedor(Mesa mesa, String ingredienteFijo) {
        this.mesa = mesa;
        this.ingredienteFijo = ingredienteFijo;
        setName("Proveedor de " + ingredienteFijo);
    }

    @Override
    public void run() {
        while (true) {
            mesa.entregarIngrediente(ingredienteFijo);
        }
    }
}