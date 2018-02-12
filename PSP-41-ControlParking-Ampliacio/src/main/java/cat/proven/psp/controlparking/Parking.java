/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlparking;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author carlos
 */
public class Parking {
    
    private int maxplaces;
    private ArrayList<places> list = new ArrayList<>();
 
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
    list.add(new places(cotxe,1));
    System.out.println(maxplaces-list.size() + ": places lliures");
    }
 
    public synchronized void surt(String cotxe) { // el coche deixa el pàrquing

    int preu=0;
    for (int i=0;i<list.size();i++){
        if (list.get(i).getMatricula().equals(cotxe)){
            preu = list.get(i).getPreu();
            list.remove(i);
            break;
        }
    }
        System.out.println(cotxe + " surt. Pagant"+ Integer.toString(preu) +" Plaça alliberada.");
    System.out.println(maxplaces-list.size() + ": places lliures");
    notifyAll();
    }
    
    public synchronized void augmentapreus()
    {
        for (places r : list)
        {
            r.setPreu(r.getPreu()+1);
        }
        System.out.println("El cobrador ha passat");
    }
}
