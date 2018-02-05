/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.ruletarussacola;

import java.util.LinkedList;

/**
 *
 * @author dmalb
 */
public class RuletaRussa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int njugs= 5;
        LinkedList<String> jugadors= new LinkedList<>();
        
        // Afegim els jugadors a la cua
        for(int i=0;i<njugs;i++){
            jugadors.add("jugador "+i);
        }
        
        // Creem la pistola indicant per quin jugador comença i passant-li la cua de jugadors
        pistola pistola = new pistola(njugs,jugadors);
        
        // Creem els jugadors
        for(int i=0;i<njugs;i++){
            new jugador("jugador "+i, pistola, i);
        }
    }
    }
    

