
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Exemple Escritura i Lectura Fitxer
 * 
 * FileWriter -> BufferedWriter -> PrintWriter
 * 
 * FileReader -> BufferedReader
 * 
 * 
 * @author alumne
 */
public class LecturaEscrituraFitxer {

    public static void main(String args[]) {
        try { 
            // escritura de datos
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("prueba.txt")));
            salida.println("Este es un ejemplo de escritura y lectura de datos");
            salida.println("en un fichero.");
            salida.close();

            // lectura de datos
            BufferedReader entrada = new BufferedReader(new FileReader("prueba.txt"));
            String s, s2 = new String();
            while ((s = entrada.readLine()) != null) {
                s2 += s + "\n";
            }
            System.out.println("Texto leido:" + "\n" + s2);
            entrada.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
