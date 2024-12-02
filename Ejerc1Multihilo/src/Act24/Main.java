/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act24;

public class Main {
    public static void main(String[] args) {
        Piscina piscina = new Piscina();

        
        for (int i = 1; i <= 15; i++) {
            new Persona(i, piscina).start();
        }
    }
}
