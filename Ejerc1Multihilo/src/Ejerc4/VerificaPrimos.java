/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc4;

import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class VerificaPrimos {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Dime una lista de numeros separados por espacio");
        String numeros=sc.nextLine();
        
        
        String[]  numeroEspaciados=numeros.split(" ");
        
        for (String numeroStr : numeroEspaciados) {
            // Cada número es manejado por un nuevo hilo
            new Thread(new PrimosRunnable(numeroStr)).start();
        }
    }
}
class PrimosRunnable implements Runnable{
        private  String numero;
        
        public PrimosRunnable(String numero){
        this.numero=numero;
        }
        
        @Override
        public void run() {
            int num =Integer.parseInt(numero);
            if (num <= 1)
            {
                System.out.println(num + " no es primo");
            }else {
              boolean esPrimo = true;
                            
              for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                    esPrimo = false;
                    break;
                        }
                    }
                    if (esPrimo) {
                        System.out.println(num + " es primo");
                    } else {
                        System.out.println(num + " no es primo");
                    }
            }
        }
    }