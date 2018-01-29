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
public class Consumidor extends Thread{
        private Cola _buffer;
        private String nom;
    
    public Consumidor(String name, Cola c){
        _buffer = c;
        nom = name;
    }
    
    public void run(){
        int dato;
        int i = 0;
        while (i<3) {
            dato= _buffer.extraer();
            System.out.println("Consumidor"+ nom + " " + dato);
            i++;
        }
    }
}
