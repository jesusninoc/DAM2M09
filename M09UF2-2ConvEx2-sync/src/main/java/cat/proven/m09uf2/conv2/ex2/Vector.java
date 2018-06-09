/*
 * M09 UF2 - Examen 2Conv - Pregunta 2 - Sincronitzacio entre fils
 */
package cat.proven.m09uf2.conv2.ex2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe Vector es el 'monitor', que conté el vector amb les 10 
 * posicions on guardarem els numeros aleatoris.
 *  I un mètode sincronitzat afegirNumero, que permetra afegir el numero si 
 * no esta repetit
 * 
 * @author alumne
 */
public class Vector {

    private int cont; //posicions plenes del vector
    int[] vector = new int[10];

    /**
     * Constructor. Inicialitza totes les posicions del vector a 0
     * i el comptador a 0.
     */
    public Vector() {
        resetVector();
    }
    
    /**
     * Inicialitza totes les posicions del vector a 0
     */
    private void resetVector() {
        this.cont = 0;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }
    }
    
    /**
     * Comprova si un numero ja esta al vector
     * @param numero
     * @return 
     */
    private Boolean estaRepetit(Integer numero) {
        for (int i = 0; i < vector.length; i++) {
            if (numero.equals(vector[i])) {
                return true;
            }
        }
       return false; 
    }

     /**
     * Buida el vector quan esta ple 
     */
    public synchronized void buidaVectorPle() {
        while (true) {
            if (this.cont>=10) { 
                System.out.println("Vector Ple");
                resetVector();
                notify(); //avisar que he acabat
            }
            try {
                wait();
                System.out.println("Algu em desperta, per comprovar si ple");
            } catch (InterruptedException ex) {
                Logger.getLogger(Vector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Mètode sincronitzat, s'executarà des dels threads,
     * només un el podrà executar a la vegada.
     * 
     * Si el numero esta repetit o el vector està ple retorna false.
     * En cas contrari, l'afegeix a lúltima posició del vector i retorna true
     * 
     * @param numero
     * @return 
     */
    public synchronized Boolean afegirNumero(Integer numero) {        
        if (this.cont>=10) { notify(); //quan ple, desperta al netejador
            try {
                wait(); //espera que acabi la neteja
            } catch (InterruptedException ex) {
                //Logger.getLogger(Vector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (estaRepetit(numero)) {return false;} //numero repetit
        else {
            vector[cont]=numero;
            cont++;
        }

        return true;
    }
}
