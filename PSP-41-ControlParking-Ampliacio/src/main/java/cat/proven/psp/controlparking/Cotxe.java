/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlparking;

/**
 *
 * @author carlos
 */
public class Cotxe extends Thread{
    private Parking parking;
    private String matricula;
    public Cotxe(String matricula, Parking p) {
    this.matricula = matricula;
    this.parking = p;
            
    start();
    }
 
    public void run() {
        while (true) {
           
            try {
            sleep((int)(Math.random() * 10000)); // Parar abans d'entrar al pàrquing
            } catch (InterruptedException e) {}

            parking.entra(this.matricula);
           

            try {
            sleep((int)(Math.random() * 20000)); // Simular estada esperant un temps aleatori
            } catch (InterruptedException e) {}

            parking.surt(this.matricula);
          }
       }
}
