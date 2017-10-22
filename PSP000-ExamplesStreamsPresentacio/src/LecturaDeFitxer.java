
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exemple streams - llegir fitxer
 * 
 * FileReader -> BufferedReader
 * 
 * @author alumne
 */
public class LecturaDeFitxer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fitxers" + File.separator +"prova.txt"));
            String linea = reader.readLine();
            while (linea != null) {
                // processar el contingut de la linia
                //escrivim la linia a la sortida standard
                System.out.println(linea);
                //llegir la seguent linia
                linea = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // no se encontró el fichero
            System.out.println(e.getLocalizedMessage());
        } catch (IOException e) {
            // algo fue mal al leer o cerrar el fichero
            System.out.println(e.getLocalizedMessage());
        }
    }

}
