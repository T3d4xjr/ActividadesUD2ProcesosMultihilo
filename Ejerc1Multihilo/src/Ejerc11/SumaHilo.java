/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejerc11;

/**
 *
 * @author DAM1
 */
public class SumaHilo extends Thread{
    private int[] numeros;
        private int suma = 0;

     
        public SumaHilo(int[] numeros) {
            this.numeros = numeros;
        }

  
        public int getSuma() {
            return suma;
        }

        @Override
        public void run() {
            for (int num : numeros) {
                suma += num;
            }
        }
}
