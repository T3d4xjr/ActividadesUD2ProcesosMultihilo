/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act25;


public class Cientifico extends Thread {
    private final int cientificoId;
    private final Laboratorio laboratorio;

    // Constructor que recibe el ID del científico y el laboratorio
    public Cientifico(int cientificoId, Laboratorio laboratorio) {
        this.cientificoId = cientificoId;
        this.laboratorio = laboratorio;
    }

    @Override
    public void run() {
        // El ciclo de trabajo de cada científico
        laboratorio.entrarSalaA(cientificoId);  // Intentar entrar en la sala A
        laboratorio.seleccionarMuestra(cientificoId); // Preparar la muestra
        laboratorio.salirSalaA(cientificoId);    // Salir de la sala A
        
        laboratorio.entrarSalaB(cientificoId);  // Intentar entrar en la sala B
        laboratorio.analizarMuestra(cientificoId); // Analizar la muestra
        laboratorio.salirSalaB(cientificoId);    // Salir de la sala B
    }
}
