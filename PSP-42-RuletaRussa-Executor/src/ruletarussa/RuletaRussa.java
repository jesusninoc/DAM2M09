/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruletarussa;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        int njugs = 5;
        LinkedList<String> jugadors = new LinkedList<>();

        // Afegim els jugadors a la cua
        for (int i = 0; i < njugs; i++) {
            jugadors.add("jugador " + i);
        }
        // Creem la Pistola indicant per quin Jugador comença i passant-li la cua de jugadors
        Pistola pistola = new Pistola(jugadors);

        long init = System.currentTimeMillis();  // Instante inicial del procesamiento
        System.out.println(jugadors.toString());

        ExecutorService executor = Executors.newFixedThreadPool(jugadors.size()); //creem l'executor
        for (String nom : jugadors) {
            Runnable jugt = new Jugador(nom, pistola);// Creem els jugadors
            executor.execute(jugt);
        }
        executor.shutdown();	// Tanco el Executor

        try {
            executor.awaitTermination(10, TimeUnit.DAYS);  //Espero a que tots els executors hagin acabat
        } catch (InterruptedException ex) {
            Logger.getLogger(RuletaRussa.class.getName()).log(Level.SEVERE, null, ex);
        }

        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");

    }
}
