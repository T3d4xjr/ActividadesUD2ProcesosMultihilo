/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act26;

public class Cliente extends Thread {
    private final int clienteId;
    private final Supermercado supermercado;

    // Constructor que recibe el ID del cliente y el supermercado
    public Cliente(int clienteId, Supermercado supermercado) {
        this.clienteId = clienteId;
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        // El ciclo de trabajo de cada cliente
        supermercado.entrarTienda(clienteId);  // El cliente entra en el supermercado
        supermercado.esperarCaja(clienteId);  // El cliente espera por una caja
        supermercado.irACaja(clienteId);      // El cliente va a la caja
        supermercado.pagarEnCaja(clienteId);  // El cliente paga en la caja
        supermercado.salirDeCaja(clienteId);  // El cliente sale de la caja
    }
}
