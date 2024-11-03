/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc3;

import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class VerificaParidad {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Dime una lista de numeros separados por espacio");
        String numeros=sc.nextLine();
        
        
        String[]  numeroEspaciados=numeros.split(" ");
        
        for (String numeroStr : numeroEspaciados) {
            // Cada número es manejado por un nuevo hilo
            new Thread(new ParidadRunnable(numeroStr)).start();
        }
    }
}    
    
    class ParidadRunnable implements Runnable{
        private  String numero;
        
        public ParidadRunnable(String numero){
        this.numero=numero;
        }
        
        @Override
        public void run() {
            int num =Integer.parseInt(numero);
            if (num % 2 == 0) {
                System.out.println(num + " Es par");
            }else
            {
                System.out.println(num + " Es impar");            
            }
        }
    }
    

