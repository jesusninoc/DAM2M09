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
class E_Adeu implements Runnable {

    escriuHolaAdeu eh;

    E_Adeu(escriuHolaAdeu eh) {
        this.eh = eh;
        new Thread(this, "Adéu").start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            eh.eAdeu();
        }
    }
}
