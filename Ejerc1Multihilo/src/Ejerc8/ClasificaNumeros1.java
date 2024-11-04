/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class ClasificaNumeros1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc =new Scanner(System.in);
        System.out.println("Dime una lista de numeros separados por espacio");
        String numeros=sc.nextLine();
        
        
        String[]  numeroEspaciados=numeros.split(" ");
        
        for (String numeroStr : numeroEspaciados) {
            // Cada número es manejado por un nuevo hilo
            ParidadRunnable parImpar = new ParidadRunnable(numeroStr);
            PrimosRunnable primos =new PrimosRunnable(numeroStr);
            PosNegRunnable posNeg =new PosNegRunnable(numeroStr);
            parImpar.start();
            primos.start();
            posNeg.start();
 
            parImpar.join();
            primos.join();
            posNeg.join();
            
            
        }
        
        
    }
}
class ParidadRunnable extends Thread{
        private  String numero;
        
        public ParidadRunnable(String numero){
        this.numero=numero;
        }
        
        
        public void parIMpar()
        {
            List<String> par =new ArrayList<>();
            List<String> impar =new ArrayList<>();
            int num =Integer.parseInt(numero);
            if (num % 2 == 0) {
                par.add(numero);
            }else
            {
                impar.add(numero);
            }
            
            System.out.println("Numeros Pares" +par);
            System.out.println("Numeros impares" +impar);
        }
        @Override
        public void run() {
           this.parIMpar();
           
        }
    }

class PrimosRunnable extends Thread{
        private  String numero;
        
        public PrimosRunnable(String numero){
        this.numero=numero;
        }
        
        public  void Primos()
        {
        List<String> primos =new ArrayList<>();
        List<String> noPrimos =new ArrayList<>();
        int num =Integer.parseInt(numero);
            if (num <= 1)
            {
                noPrimos.add(numero);
            }else {
              boolean esPrimo = true;
                            
              for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                    esPrimo = false;
                    break;
                        }
                    }
                    if (esPrimo) {
                        primos.add(numero);
                    } else {
                        noPrimos.add(numero);
                    }
            }
            System.out.println("Numeros primos" +primos);
            System.out.println("Numeros noPrimos" + noPrimos);
            
        }
        @Override
        public void run() {
            this.Primos();
        }
    }
class PosNegRunnable extends Thread{
        private  String numero;
        
        public PosNegRunnable(String numero){
        this.numero=numero;
        }
        
        public void PosNeg()
        {
        List<String> positivos =new ArrayList<>();
        List<String> negativos =new ArrayList<>();
        int num =Integer.parseInt(numero);
            if (num  >= 0) {
                positivos.add(numero);
            }else
            {
                negativos.add(numero);
            }
        System.out.println("Numeros positivos" +positivos);
        System.out.println("Numeros negativos" +negativos);    
        }
        @Override
        public void run() {
            this.PosNeg();
        }
        
        
    }