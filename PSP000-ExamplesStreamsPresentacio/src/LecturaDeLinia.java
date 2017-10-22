
import java.io.IOException;

/**
 * DAM2 M09 - Presentació Streams
 * Exemple amb System.in (InputStream) / System.out (OutputStream)
 * 
 * InputStream i OuputStream treballen amb bytes
 * 
 * @author alumne
 */
public class LecturaDeLinia {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int c;
        int contador = 0;
        // llegir byte de l'entrada standard
        // fins trobar el caracter fi de línia
        while ((c = System.in.read()) != '\n') {
            contador++;
            //escriure, a la sortida standard, cada byte llegit, com a caràcter
            System.out.print((char) c);
        }
        System.out.println(); // Escriu un fi de línia
        System.err.println("Comptats " + contador + " bytes en total.");
    }
    
}
