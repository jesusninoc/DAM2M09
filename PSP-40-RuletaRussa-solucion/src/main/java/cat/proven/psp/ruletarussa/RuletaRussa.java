/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.ruletarussa;

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
        pistola pistola = new pistola(njugs);

        for (int i = 0; i < njugs; i++) {
            new jugador("jugador " + i, pistola);
        }

    }
}
