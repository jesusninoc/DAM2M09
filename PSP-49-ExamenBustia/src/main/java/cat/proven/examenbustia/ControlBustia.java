/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.examenbustia;

/**
 *
 * @author carlos
 */
public class ControlBustia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EscriptorCarta[] escriptors = new EscriptorCarta[5];
        Bustia bustia = new Bustia(3);
        for (int i=0; i< 5; i++) {
        escriptors[i] = new EscriptorCarta("Escriptor " + i, bustia);
        }
        Carter c = new Carter("Carter", bustia);
    }
    
}
