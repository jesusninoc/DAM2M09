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
public class Parking {
    
    private int places;
 
    public Parking(int places) {
        if (places < 0)
            places = 0;
        this.places = places;
    }
 
    public synchronized void entra(String cotxe) { // cotxe entra al pàrquing
    while (places == 0) {
    try {
    System.out.println( cotxe + ": esperant, pàrquing ple.");
    wait();
    } catch (InterruptedException e) {}
    }
    System.out.println(cotxe + ": entra al pàrquing");
    places--;
    System.out.println(places + ": places lliures");
    }
 
    public synchronized void surt(String cotxe) { // el coche deixa el pàrquing
    System.out.println(cotxe + " surt. Plaça alliberada.");
    places++;
    System.out.println(places + ": places lliures");
    notifyAll();
    }
}
