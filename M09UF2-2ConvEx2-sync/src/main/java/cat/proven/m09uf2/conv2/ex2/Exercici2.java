/*
 * M09 UF2 - Examen 2Conv - Pregunta 2 - Sincronitzacio entre fils
 */
package cat.proven.m09uf2.conv2.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 * Pregunta 2 - Sincronitzacio entre fils
 * 
 * Programa que genera nombres aleatoris entre 1 i 20 i 
 * els guarda en un vector de 10 posicions. 
 * Aquests nombres no es podran repetir. 
 * 
 * @author alumne
 */
public class Exercici2 {

    /**
     * Instancia el vector (vector con 10 posiciones), 
     * instancia els 3 fils que ompliran el vecor amb nombres aletoris 
     * Executa els 3 fils
     *  
     * @param args
     */
    public static void main(String[] args) {
        Vector manager = new Vector();
        NetejadorVector netejador = new NetejadorVector(manager);

        List<ReposadorVector> list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(new ReposadorVector(manager,i+1));
        }
        
        netejador.start();
        for (ReposadorVector reposador : list) {
            reposador.start();
        }
    }
}
