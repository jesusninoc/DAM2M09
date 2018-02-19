/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruletarussa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmalb
 */
public class RuletaRussa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int njugs= 5;
        LinkedList<String>  jugadors= new LinkedList<>();
        
        // Afegim els jugadors a la cua
        for(int i=0;i<njugs;i++){
            jugadors.add("jugador "+i);
        }
        // Creem la pistola indicant per quin jugador comença i passant-li la cua de jugadors
        pistola pistola = new pistola(jugadors);
        
        
        Collection<Callable<String>> ljugs = new ArrayList<>();
        Collection<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(jugadors.size()); //creem l'executor
        for (String nom: jugadors) {
            jugador jugt = new jugador(nom, pistola);// Creem els jugadors
            ljugs.add(jugt);
        }
        try {
            futures = executor.invokeAll(ljugs);
        } catch (InterruptedException ex) {
            Logger.getLogger(RuletaRussa.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();	// Tanco el Executor
  
        try {
            executor.awaitTermination(10, TimeUnit.DAYS);  //Espero a que tots els executors hagin acabat
        } catch (InterruptedException ex) {
            Logger.getLogger(RuletaRussa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for ( Future<String> r : futures){
            try {
                System.out.println(r.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(RuletaRussa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(RuletaRussa.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    }
    

