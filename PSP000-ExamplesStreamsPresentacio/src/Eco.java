
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Exemple combinació de streams
 * InputStream [System.in] (bytes) -> InputStreamReader (char) -> BufferedReader (linia)
 * @author alumne
 */
public class Eco {

    public static void main(String[] args) throws IOException {
        BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
        String missatge;
        System.out.println("Introduir una línia de text:");
        missatge = entradaEstandar.readLine();
        System.out.println("Introduït: \"" + missatge + "\"");
    }
}
