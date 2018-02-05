/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlbanc;

import static java.lang.Thread.sleep;

/**
 *
 * @author alumne
 */
public class monitor {
 
    compteBancari compte;
    
    public monitor(compteBancari compte)
    {
    this.compte = compte;
    }
 
    public  synchronized void  ingressar(double quantitat, String persona)
    {
        System.out.println(persona + " entra a fer ingrés " + quantitat);
        double saldo = compte.getSaldo();
        System.out.println(persona + " consulta saldo abans: " + saldo);
        
        try {
        sleep((int)(Math.random() * 10000)); // Dormir un rato
        } catch (InterruptedException e) {}
        
        saldo+= quantitat;    
        compte.setSaldo(saldo);
        System.out.println(persona + " entra nou saldo " + saldo);
        this.notify();
    }
    
    public  synchronized void recaudar(double quantitat)
    {
        
        while( compte.getSaldo() < quantitat )
        {
            try {
                System.out.println("No hi ha prou saldo");
                wait();
                } catch (InterruptedException e) {}
        }
        
        double saldo = compte.getSaldo();
        System.out.println("He tret " + quantitat);
        saldo-= quantitat;    
        compte.setSaldo(saldo);
        System.out.println("Ara queda " + saldo);
        
    }
    
}
