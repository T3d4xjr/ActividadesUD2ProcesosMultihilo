/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc16;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        Chef chef = new Chef(mesa);
        chef.start();

        Ayudante ayudanteVerduras = new Ayudante(mesa, "verduras");
        Ayudante ayudanteCarne = new Ayudante(mesa, "carne");
        Ayudante ayudanteSalsa = new Ayudante(mesa, "salsa");

        ayudanteVerduras.start();
        ayudanteCarne.start();
        ayudanteSalsa.start();
    }
}
