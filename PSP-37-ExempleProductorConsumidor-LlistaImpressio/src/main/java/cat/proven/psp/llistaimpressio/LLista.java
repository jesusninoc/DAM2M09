/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.llistaimpressio;

import java.util.LinkedList;

/**
 *
 * @author carlos
 */


public class LLista {
    
    
  private LinkedList lista = new LinkedList();

   public synchronized void addDato(Object dato)
   {
      lista.add(dato);
      notify();
   }

   public synchronized Object getDato()
   {
      
        while (lista.size()==0)
        {
            try
            {
               wait();
            }
            catch(Exception ex)
            {
            }
        }
      Object dato = lista.get(0);
      lista.remove(0);
      return dato;
      
   } 
    
}
