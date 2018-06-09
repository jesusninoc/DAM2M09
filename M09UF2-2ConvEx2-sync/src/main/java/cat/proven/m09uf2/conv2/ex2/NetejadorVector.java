/*
 * M09 UF2 - Examen 2Conv - Pregunta 2 - Sincronitzacio entre fils
 */
package cat.proven.m09uf2.conv2.ex2;

/**
 * Classe pel Fil que haa de buidar el vector quan estigui ple
 * 
 * @author alumne
 */
public class NetejadorVector extends Thread {
    private Vector vector;
    
    /**
     * Constructor 
     * @param vector    vector a omplir amb numeros aleatoris
     */
    public NetejadorVector(Vector vector) {
        this.vector = vector;
    }  
   
    /**
     * Executa tota la tasca del fil
     */
    @Override
    public void run() {
        this.vector.buidaVectorPle();
    }

}
