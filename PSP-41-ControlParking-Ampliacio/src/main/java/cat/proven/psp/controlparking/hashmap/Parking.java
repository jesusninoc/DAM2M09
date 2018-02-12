/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlparking;

import java.util.HashMap;
import java.util.Map.Entry;


/**
 *
 * @author carlos
 */
public class Parking {
    
    private int maxplaces;
    
    private HashMap<String, Integer> list = new HashMap<>();
    
 
    public Parking(int maxplaces) {
        if (maxplaces < 0)
            maxplaces = 0;
        this.maxplaces = maxplaces;
    }
 
    public synchronized void entra(String cotxe) { // cotxe entra al pàrquing
    while (list.size() == maxplaces) {
    try {
    System.out.println( cotxe + ": esperant, pàrquing ple.");
    wait();
    } catch (InterruptedException e) {}
    }
    System.out.println(cotxe + ": entra al pàrquing");
    
    list.put(cotxe,1);
    
    System.out.println(maxplaces-list.size() + ": places lliures");
    }
 
    public synchronized void surt(String cotxe) { // el coche deixa el pàrquing

        
    int preu = list.get(cotxe);
    list.remove(cotxe);
    
    System.out.println(cotxe + " surt. Pagant"+ Integer.toString(preu) +" Plaça alliberada.");
    System.out.println(maxplaces-list.size() + ": places lliures");
    notifyAll();
    }
     
    public synchronized void augmentapreus()
    {
        for (Entry r : list.entrySet())
        {
            r.setValue((int)r.getValue()+1);
        }
        System.out.println("El cobrador ha passat");
    }
}
