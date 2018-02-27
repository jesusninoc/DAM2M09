/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.examenbustia;

/**
 *
 * @author alumne
 */
public class Bustia {

    private int cartes;
    private int maxCartes;

    /**
     *
     * @param places
     */
    public Bustia(int maxCartes) {
        this.cartes = 0;
        this.maxCartes = maxCartes;
    }

    /**
     *
     * @param escriptor
     */
    public synchronized void deixaCarta(String escriptor) { // cotxe entra al pàrquing
        while (this.cartes == this.maxCartes) {
            try {
                System.out.println(escriptor + ": esperant, bustia plena.");
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(escriptor + ": deixa una carta");
        cartes++;
        System.out.println(cartes + " a la bústia");
    }

    /**
     *
     * @param carter
     */
    public synchronized void recullCartes(String carter) { // el carter recull les cartes
        System.out.println(carter + " recull les cartes");
        cartes=0;
        System.out.println("Bústia buida");
        notifyAll();
    }
}
