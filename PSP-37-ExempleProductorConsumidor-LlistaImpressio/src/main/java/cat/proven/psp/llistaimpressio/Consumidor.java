/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.llistaimpressio;

/**
 *
 * @author carlos
 */
public class Consumidor extends Thread {
    
    LLista list;
    String nom;
    
    public Consumidor(LLista list, String nom)
    {
    this.list = list;
    this.nom = nom;
    }
    
      public void run(){
     
        while(true)
        {
             try
             {
                // sleep((int)(Math.random() * 10000)); // Parar un temps aleatori
                 System.out.println(nom + " llest per obtindre dada.");
                 String dada = (String)list.getDato();
                 System.out.println(nom + " imprimeix dada: " + dada);
             }
             catch (Exception ex)
             {
             
             }
        }
    }
    
    
}
