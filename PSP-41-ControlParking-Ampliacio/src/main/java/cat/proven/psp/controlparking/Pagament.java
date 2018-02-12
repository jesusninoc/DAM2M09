/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlparking;

/**
 *
 * @author alume
 */
public class Pagament extends Thread{

    private Parking p;
    
    public Pagament(Parking p){
        this.p=p;
        start();
    }
 
    public void run() {
        while (true) {
            
            try {
                sleep((int)(1000)); // Simular estada esperant un temps aleatori
            } catch (InterruptedException e) {}
            p.augmentapreus();
        }
        }
}
