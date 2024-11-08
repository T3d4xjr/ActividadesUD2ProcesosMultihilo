package Ejerc9;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author DAM1
 */
class HiloAlarma extends Thread{
    private int sReloj;
    private int sAlarma;
    
    public  HiloAlarma (int sReloj,int sAlarma){
        this.sReloj=sReloj;
        this.sAlarma=sAlarma;
    }
    
    
    @Override
    public void run(){
        for (int i = sAlarma; i <= sReloj ;i+=sAlarma) {
            System.out.println("Alarma: Han pasado " + sAlarma +" segundos");
            try {
                Thread.sleep(sAlarma*1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
