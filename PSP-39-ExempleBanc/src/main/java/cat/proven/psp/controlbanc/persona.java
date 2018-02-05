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
public class persona extends Thread{
    
    String nom;
    compteBancari compte;
    monitor myMonitor;
    public persona(String nom, monitor mymonitor)
    {
        this.nom = nom;
        myMonitor = mymonitor;
        this.start();
    }
    
    public void run() {
        while (true) {
            
            try {
            sleep((int)(Math.random() * 10000)); // Parar abans d'entrar al pàrquing
            } catch (InterruptedException e) {}
            
            double quantitat =(int)(Math.random()*50 + 1);
            System.out.println(this.nom + " vol ingressar " + quantitat);
            myMonitor.ingressar(quantitat,nom);
        }
    }
}
