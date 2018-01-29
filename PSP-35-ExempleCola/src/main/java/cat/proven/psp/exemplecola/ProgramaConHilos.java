/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.exemplecola;

/**
 *
 * @author alumne
 */
public class ProgramaConHilos {
    public static void main(String[] args) {
        Cola el_buffer;
        Productor p;
        Consumidor[] c;
        
        el_buffer = new Cola(5);
        p= new Productor(el_buffer);
        c= new Consumidor[3];
        for (int i=0; i < c.length;i++) {
            c[i]= new Consumidor(String.valueOf(i), el_buffer);
        }
        
        p.start();
        for (int i=0; i< c.length; i++) {
            c[i].start();
        }
    }
    
}
