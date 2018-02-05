/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.humanoides;

/**
 *
 * @author mercedes
 */
public class VectorCosas {
    private static final int MAX = 100;
    private int tam;
    private Cosa[] lista;
    
    public VectorCosas(){
        lista = new Cosa[MAX];
        tam=0;
    }
    
    public synchronized void mostrar (String quien) {
        int p=0;
        
        System.out.println(quien + " ve (" + tam + "):");
        for (int i = 0; i < tam; i++) {
            System.out.println("   " + quien + ", " + lista[i]);
        }
    }
    
}
