/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.sumaarraythreads;

/**
 *
 * @author mercedes
 */
public class SumaArray {

    private int suma;
    private int[] vector; //Array on estaran els valors
    private int start; // On començarem a comprovar
    private int end;   // On pararem de comprovar

    /**
     *
     * @param vector
     * @param start
     * @param end
     */
    public SumaArray(int[] vector, int start, int end) {
        this.suma = 0;
        this.vector = vector;
        this.start = start;
        this.end = end;
    }

    /**
     *
     */
    public void run() {
        suma = 0;

        // Recorrem l'array
        for (int i = start; i <= end; i++) {
            // Acumulem la suma
            suma += vector[i];
        }
    }

    /**
     * Getter per a la propietat suma
     *
     * @return
     */
    public int getSuma() {
        return this.suma;
    }

}
