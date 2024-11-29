/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act19;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        Repostero repostero = new Repostero(mesa);
        repostero.start();

        Proveedor proveedorHarina = new Proveedor(mesa, "harina");
        Proveedor proveedorAzucar = new Proveedor(mesa, "azúcar");
        Proveedor proveedorHuevos = new Proveedor(mesa, "huevos");
        
        

        proveedorHarina.start();
        proveedorAzucar.start();
        proveedorHuevos.start();
    }
}
