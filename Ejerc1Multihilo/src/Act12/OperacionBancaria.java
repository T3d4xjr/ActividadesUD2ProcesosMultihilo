/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act12;

import java.util.Random;

public class OperacionBancaria {
    public static void main(String[] args) {
        Random random = new Random();
        double saldoInicial = 30 + random.nextInt(31);
        Cuenta cuenta = new Cuenta(saldoInicial);
        System.out.println("Saldo inicial de la cuenta: " + cuenta.getSaldo() + "€");

        Persona p1 = new Persona("Persona 1", cuenta, saldoInicial);
        Persona p2 = new Persona("Persona 2", cuenta, saldoInicial);

        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Saldo final de la cuenta: " + cuenta.getSaldo() + "€");
    }
}
