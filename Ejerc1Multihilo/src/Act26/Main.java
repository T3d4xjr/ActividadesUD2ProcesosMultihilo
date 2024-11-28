/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act26;

/**
 *
 * @author tedax
 */
public class Main {
    public static void main(String[] args) {
        
        Supermercado supermercado = new Supermercado();
        
        for (int i = 0; i < 10; i++) {
            new Cliente(i, supermercado).start();
        }
    }
    
}
