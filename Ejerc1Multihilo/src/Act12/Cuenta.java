/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act12;

import java.util.Random;

/**
 *
 * @author tedax
 */
public class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        Random r =new Random();
        this.saldo = r.nextInt(30,61);
    }
    

    public synchronized void retirarDinero(String nombre, double cantidad) {
        if (saldo >= cantidad) {
            System.out.println(nombre + ": va a retirar " + cantidad + "€. Saldo actual: " + saldo + "€");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            saldo -= cantidad;
            System.out.println(nombre + ": ha retirado " + cantidad + "€. Saldo actual: " + saldo + "€");
        } else {
            System.out.println(nombre + ": no puede retirar " + cantidad + "€. Saldo actual: " + saldo + "€");
        }
    }

    public double getSaldo() {
        return saldo;
    }

 
    
}

