/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private final Lock lock = new ReentrantLock();
    private final Condition ingredientesDisponibles = lock.newCondition();
    private final Condition ingredienteNecesitado = lock.newCondition();

    private List<String> ingredientesEnMesa = new ArrayList<>();
    private boolean ingredientesListos = false;
    private String ingredienteFaltante = null;

        public void colocarIngredientes(String ingrediente1, String ingrediente2) {
        lock.lock();
        try {
            while (ingredientesListos) {
                ingredientesDisponibles.await(); // Espera a que los ingredientes sean recogidos
            }

            ingredientesEnMesa.clear();
            ingredientesEnMesa.add(ingrediente1);
            ingredientesEnMesa.add(ingrediente2);

            // Determinar el ingrediente faltante
            String[] todosLosIngredientes = {"harina", "azúcar", "huevos"};
            for (String ingrediente : todosLosIngredientes) {
                if (!ingredientesEnMesa.contains(ingrediente)) {
                    ingredienteFaltante = ingrediente;
                    break;
                }
            }

            System.out.println("El repostero ha cogido "+ ingrediente1 + " y "+ ingrediente2 +" necesita "+ingredienteFaltante);
            ingredientesListos = true;
            ingredienteNecesitado.signalAll(); // Notifica a los proveedores
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


        public void entregarIngrediente(String ingredienteFijo) {
        lock.lock();
        try {
            while (ingredienteFaltante == null || !ingredienteFaltante.equals(ingredienteFijo)) {
                ingredienteNecesitado.await(); // Espera hasta que sea su turno
            }

            System.out.println("El proveedor con "+ingredienteFijo+" ha sido llamado.");

            // Simula el tiempo de entrega entre 2 y 4 segundos
            Thread.sleep(2000 + (int) (Math.random() * 2000));

            System.out.println("El proveedor ha traído "+ingredienteFijo);
            ingredienteFaltante = null;
            ingredientesListos = false;

            System.out.println("El repostero ha preparado el bizcocho.");
            ingredientesDisponibles.signal(); // Notifica al repostero para que coloque nuevos ingredientes
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
