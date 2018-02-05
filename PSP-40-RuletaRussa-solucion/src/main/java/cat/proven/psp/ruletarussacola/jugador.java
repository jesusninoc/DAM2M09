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
import static java.lang.Thread.sleep;

public class jugador extends Thread {

    String nom;
    pistola pistola;
    int njugs;
    private boolean viu = true;
    int ordre;

    public jugador(String nom, pistola pistola, int ordre) {
        this.nom = nom;
        this.pistola = pistola;
        this.njugs = pistola.getnjugs();
        this.ordre = ordre;
        this.start();
    }

    @Override
    public void run() {

        while (this.njugs > 1) {    //mentres estiguis viu i quedin contrincants la partida seguei
            njugs = pistola.getnjugs();
            try {
                sleep((int) (1000)); // PAUSA DRAMÀTICA
            } catch (InterruptedException e) {
            }
            viu = pistola.disparar(nom);
            if (!viu) {
                return;
            }
        }
        System.out.println("Felicitats! " + this.nom + " ha guanyat");
    }
}
