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
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una lista de numeros separados por espacio");
        String numeros = sc.nextLine();
        
        String[] numeroEspaciados = numeros.split(" ");
        
        // Convertir la lista de Strings a una lista de enteros
        List<Integer> numeroListado = new ArrayList<>();
        for (String numeroStr : numeroEspaciados) {
            numeroListado.add(Integer.parseInt(numeroStr));
        }

        // Crear los hilos
        ParidadRunnable parImpar = new ParidadRunnable(numeroListado);
        PrimosRunnable primos = new PrimosRunnable(numeroListado);
        PosNegRunnable posNeg = new PosNegRunnable(numeroListado);
        
        // Iniciar los hilos
        parImpar.start();
        primos.start();
        posNeg.start();
        
        // Esperar que los hilos terminen
        parImpar.join();
        primos.join();
        posNeg.join();
    }
}

class ParidadRunnable extends Thread {
    private List<Integer> numero;

    public ParidadRunnable(List<Integer> numero) {
        this.numero = numero;
    }

    public void parImpar() {
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();
        
        // Clasificar los números en pares e impares
        for (int num : numero) {
            if (num % 2 == 0) {
                par.add(num);
            } else {
                impar.add(num);
            }
        }
        
        // Mostrar los resultados
        System.out.println("Numeros Pares: " + par);
        System.out.println("Numeros Impares: " + impar);
    }

    @Override
    public void run() {
        this.parImpar();
    }
}

class PrimosRunnable extends Thread {
    private List<Integer> numero;

    public PrimosRunnable(List<Integer> numero) {
        this.numero = numero;
    }

    public void primos() {
        List<Integer> primos = new ArrayList<>();
        List<Integer> noPrimos = new ArrayList<>();
        
        // Clasificar los números en primos y no primos
        for (int num : numero) {
            if (num <= 1) {
                noPrimos.add(num);
            } else {
                boolean esPrimo = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
                if (esPrimo) {
                    primos.add(num);
                } else {
                    noPrimos.add(num);
                }
            }
        }
        
        // Mostrar los resultados
        System.out.println("Numeros Primos: " + primos);
        System.out.println("Numeros No Primos: " + noPrimos);
    }

    @Override
    public void run() {
        this.primos();
    }
}

class PosNegRunnable extends Thread {
    private List<Integer> numero;

    public PosNegRunnable(List<Integer> numero) {
        this.numero = numero;
    }

    public void posNeg() {
        List<Integer> positivos = new ArrayList<>();
        List<Integer> negativos = new ArrayList<>();
        
        // Clasificar los números en positivos y negativos
        for (int num : numero) {
            if (num >= 0) {
                positivos.add(num);
            } else {
                negativos.add(num);
            }
        }
        
        // Mostrar los resultados
        System.out.println("Numeros Positivos: " + positivos);
        System.out.println("Numeros Negativos: " + negativos);
    }

    @Override
    public void run() {
        this.posNeg();
    }
}
