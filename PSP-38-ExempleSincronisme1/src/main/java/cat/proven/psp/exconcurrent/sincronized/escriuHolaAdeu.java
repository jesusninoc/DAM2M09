/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.exconcurrent.sincronized;

/**
 *
 * @author alumne
 */
class escriuHolaAdeu {

    boolean escritHola = false;

    public synchronized void eAdeu() {
        while (escritHola == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        escritHola = false;
        System.out.println(" Adéu ");
    }

    public synchronized void eHola() {
        System.out.println(" Hola ");
        escritHola = true;
        notify();
    }

}
