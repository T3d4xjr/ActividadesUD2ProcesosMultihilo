/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc11;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class SumarNumeros {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Introduce una lista de números separados por espacios: ");
        String entrada = scanner.nextLine();
        

        String[] partes = entrada.split(" ");
        int[] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
        }
        
       
        int mitad = numeros.length / 2;
        int[] primeraMitad = new int[mitad];
        int[] segundaMitad = new int[numeros.length - mitad];
        
        for (int i = 0; i < mitad; i++) {
            primeraMitad[i]=numeros[i];
        }
        for (int i = mitad,j=0; i < numeros.length; i++,j++) {
            segundaMitad[j]=numeros[i];
        }
        
    
        SumaHilo hilo1 = new SumaHilo(primeraMitad);
        SumaHilo hilo2 = new SumaHilo(segundaMitad);
        
     
        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
        
   
        int sumaTotal = hilo1.getSuma() + hilo2.getSuma();
        
        // Mostrar la suma total
        System.out.println(Arrays.toString(primeraMitad));
        System.out.println(Arrays.toString(segundaMitad));
        System.out.println("La suma total de los números introducidos es: " + sumaTotal);
    }
}