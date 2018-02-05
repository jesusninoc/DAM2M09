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
public class Productor extends Thread{
    
    LLista list;
    String nom;
    
    public Productor(LLista list, String nom)
    {
    this.list = list;
    this.nom = nom;
    }
    
    
    public void run(){
     
        while(true)
        {
             try
             {
                 //System.out.println(nom + " entra al bucle");
                 sleep((int)(Math.random() * 10000)); // Parar un temps aleatori
                 String dada = Double.toString(Math.random());
                 System.out.println(nom + " entra dada: " + dada);
                 list.addDato("Nova dada " + dada);
                
             }
             catch (Exception ex)
             {
                ex.printStackTrace();
             }
             
            
        
        }
    }
   
    
}
