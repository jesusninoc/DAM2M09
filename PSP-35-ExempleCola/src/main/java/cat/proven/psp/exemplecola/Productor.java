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
public class Productor extends Thread{
    private Cola _buffer;
    
    public Productor(Cola c){
        _buffer = c;
    }
    
    public void run(){
        int valor=0;
        while (true) {
            _buffer.almacenar(valor);
            System.out.println("Productor "+ valor);
            valor++;
        }
    }
}
