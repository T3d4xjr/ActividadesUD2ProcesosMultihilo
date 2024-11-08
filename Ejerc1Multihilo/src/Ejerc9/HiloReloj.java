package Ejerc9;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author DAM1
 */
 class HiloReloj extends Thread{
    private int sReloj;
    
    public  HiloReloj (int sReloj){
        this.sReloj=sReloj;
    }
    
    
    @Override
    public void run(){
        for (int i = 0; i < sReloj; i++) {
            System.out.println("Reloj: " + i +" segundos");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
