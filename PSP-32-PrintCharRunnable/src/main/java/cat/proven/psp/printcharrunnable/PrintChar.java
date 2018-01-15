/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.printcharrunnable;

/**
 *
 * @author alumne
 */
public class PrintChar implements Runnable {

    char charImprimir;
    int numImpresions;

    public PrintChar(char charImprimir, int numImpresions) {
        this.charImprimir = charImprimir;
        this.numImpresions = numImpresions;
    }

    @Override
    public void run() {
        for (int x = 0; x < numImpresions; x++) {
            System.out.println(charImprimir + " " + x);
        }
    }

}
