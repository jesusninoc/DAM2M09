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
class E_Hola implements Runnable {

    escriuHolaAdeu eh;

    E_Hola(escriuHolaAdeu eh) {
        this.eh = eh;
        new Thread(this, "Hola").start();
    }

    @Override
    public void run() {
        try {
            for (int x = 0; x < 5; x++) {
                Thread.sleep(2000);
                eh.eHola();
            }
        } catch (InterruptedException e) {
        }
    }
}
