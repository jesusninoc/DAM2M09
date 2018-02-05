/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.ruletarussacola;

/**
 *
 * @author dmalb
 */
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pistola {

    private int njugs;

    LinkedList<String> jugadors;

    public int getnjugs() {
        return this.njugs;
    }

    public pistola(int njugs, LinkedList<String> jugadors) {
        this.njugs = njugs;
        this.jugadors = jugadors;
    }

    public synchronized boolean disparar(String jugador) {

        // Mentres no sigui el seu torn espera
        while (!jugadors.getFirst().equals(jugador)) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(pistola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean viu = true;
        if (njugs == 1) {
            return viu;  //condició de victoria
        }
        System.out.println(jugador + " agafa la pistola...");
        Random rand = new Random();
        int randomNum = rand.nextInt(6);//num aleatori entre 0-5 (un revolver te 6 bales)
        if (randomNum == 0) {
            viu = false; //BANG!
            this.njugs--; //un jugador menys a la partida
            System.out.println("BANG!!!");
            System.out.println("Resem per l'ànima de " + jugador);
            jugadors.removeFirst();

        } else {
            System.out.println("clic");
            viu = true;
            jugadors.removeFirst();
            jugadors.add(jugador);
        }

        this.notifyAll();
        return viu;
    }

}
