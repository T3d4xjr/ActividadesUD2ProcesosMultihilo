package Ejerc5;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tedax
 */
public class VerificaPosNeg {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Dime una lista de numeros separados por espacio");
        String numeros=sc.nextLine();
        
        
        String[]  numeroEspaciados=numeros.split(" ");
        
        for (String numeroStr : numeroEspaciados) {
            // Cada número es manejado por un nuevo hilo
            new Thread(new PosNegRunnable(numeroStr)).start();
        }
    }
}    
    
    class PosNegRunnable implements Runnable{
        private  String numero;
        
        public PosNegRunnable(String numero){
        super();
        this.numero=numero;
        }
    
        @Override
        public void run() {
            int num =Integer.parseInt(numero);
            if (num  >= 0) {
                System.out.println(num + " Es positivo");
            }else
            {
                System.out.println(num + " Es negativo");            
            }
        }
    }
    

