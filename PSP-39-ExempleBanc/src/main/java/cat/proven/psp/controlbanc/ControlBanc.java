/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlbanc;

/**
 *
 * @author alumne
 */
public class ControlBanc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        compteBancari compte = new compteBancari();
        monitor myMonitor = new monitor(compte);
        
        persona persona1 = new persona("Persona 1", myMonitor);
        persona persona2 = new persona("Persona 2", myMonitor);
        persona persona3 = new persona("Persona 3" ,myMonitor);
        
        recaudador r = new recaudador(myMonitor);
   }
    
}
