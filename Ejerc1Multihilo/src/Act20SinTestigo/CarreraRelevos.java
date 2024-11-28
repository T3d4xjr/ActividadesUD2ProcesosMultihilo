/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act20SinTestigo;

public class CarreraRelevos {
    public static void main(String[] args) {
   
        System.out.println("Preparados...");
        System.out.println("Listos...");
        System.out.println("¡Bang!");

  
        Atleta[] atletas = {
            new Atleta("Atleta 1"),
            new Atleta("Atleta 2"),
            new Atleta("Atleta 3"),
            new Atleta("Atleta 4")
        };

        long tiempoInicioCarrera = System.currentTimeMillis(); 

   
        for (Atleta atleta : atletas) { 
            long tiempoCorrer = atleta.correr();
            

          
            System.out.println(atleta.getNombre() + " tiempo (millis): " + tiempoCorrer);

        }

        long tiempoFinCarrera = System.currentTimeMillis();

        System.out.println("Tiempo total de la carrera (millis): " + (tiempoFinCarrera - tiempoInicioCarrera));
    }
}
