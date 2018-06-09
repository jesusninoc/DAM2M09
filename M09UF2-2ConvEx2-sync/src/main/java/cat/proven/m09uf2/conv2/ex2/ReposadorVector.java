/*
 * M09 UF2 - Examen 2Conv - Pregunta 2 - Sincronitzacio entre fils
 */
package cat.proven.m09uf2.conv2.ex2;

/**
 * Classe pel Fils que han de generar numeros aletoris i afegir-los al vector.
 * 
 * Cadascun dels fils farà tota l'estona la següent tasca:
 *  - Dormir un temps aleatori (màxim un segon)
 *  - Generar un nombre aleatori
 *        numero = (int)((Math.random() * 19) + 1);
 *  - Intentar afegir el nombre al vector.
 * - Si el nombre no es troba al vector l'afegirà a l'última posició (la primera que valgui 0) i 
 * mostrarà el següent missatge:
 *              "Fil N afegeix nombre X."
 * - Si el nombre ja està al vector no l'afegirà i mostrarà el següent missatge:
 *              "Fil N. Nombre X repetit."
 * 
 * @author alumne
 */
public class ReposadorVector extends Thread {
    private int num;
    private Vector vector;
    
    /**
     * Constructor 
     * @param vector    vector a omplir amb numeros aleatoris
     * @param num       numero de fil
     */
    public ReposadorVector(Vector vector,int num) {
        this.vector = vector;
        this.num = num;
    }  
   
    /**
     * Executa tota la tasca del fil
     */
    @Override
    public void run() {
        int numAleatori;
        while (true) {
            try {
                sleep((int) (Math.random() * 1000));
                
                numAleatori=(int)((Math.random()*19)+1);
                if (vector.afegirNumero(numAleatori)) {
                    System.out.println("Fil " + num +" afegeix nombre "+ numAleatori + ".");
                }
                else {
                    System.out.println("Fil " + num +". Nombre "+ numAleatori + " repetit.");
                }
            } catch (InterruptedException ex) {
                //sortir
            }
        }   
    }

}
