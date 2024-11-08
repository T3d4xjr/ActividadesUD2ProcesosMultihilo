package Ejerc9;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author DAM1
 */
public class Temporizador {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        System.out.println("Dime los segundos que va a durar el temporizador");
        
        int sReloj =sc.nextInt();
        
        
        System.out.println("Dime los segundo donde quieres que suene la alarma");
        
        int sAlarma =sc.nextInt();
        
        
        HiloReloj hr =new HiloReloj(sReloj);
        HiloAlarma ha =new HiloAlarma(sReloj, sAlarma);
        
        
        
        ha.setDaemon(true);
        
        hr.start();
        ha.start();
        
        try {
            hr.join();
            
        } catch (InterruptedException e) {
        }
    }
    
    
}
