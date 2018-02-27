/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.examenselectivitat;

import java.util.Random;

/**
 *
 * @author alumne
 */
public class NotesSelectivitat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int notaMax;
        int numAlumnesAmbNotaMax;

        // Creem l'array
        int ARRAY_SIZE = 3000;

        int[] arrNotes = new int[ARRAY_SIZE];

        //Inicialització
        for (int i = 0; i < arrNotes.length; i++) {
            Random rand = new Random();
            arrNotes[i] = rand.nextInt(15); //num aleatori entre 0-14 
        }

        // Threads
        try {

            NotasSeleThread thread1 = new NotasSeleThread("Part1", arrNotes, 0, 1499);
            thread1.start();

            NotasSeleThread thread2 = new NotasSeleThread("Part2",arrNotes, 1500, 2999);
            thread2.start();

            thread1.join();
            thread2.join();

            //get the results of the threads
            if (thread1.getNotaMax() > thread2.getNotaMax()) {
                notaMax = thread1.getNotaMax();
                numAlumnesAmbNotaMax = thread1.getNumAlumnesNotaMax();
            } else if (thread1.getNotaMax() < thread2.getNotaMax()) {
                notaMax = thread2.getNotaMax();
                numAlumnesAmbNotaMax = thread2.getNumAlumnesNotaMax();
            } else {
                notaMax = thread1.getNotaMax();
                numAlumnesAmbNotaMax = thread1.getNumAlumnesNotaMax() + thread2.getNumAlumnesNotaMax();
            }
            System.out.println("Resultat final: " + numAlumnesAmbNotaMax + " alumnes han tret la nota màxima " + notaMax);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
