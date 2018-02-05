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
public class LListaImpresio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LLista list = new LLista();
        
        Consumidor c = new Consumidor(list,"Consumidor");
        Productor p1 = new Productor(list, "Productor 1");
        Productor p2 = new Productor(list, "Productor 2");
        
        c.start();
        p1.start();
        p2.start();
        
        
    }
    
}
