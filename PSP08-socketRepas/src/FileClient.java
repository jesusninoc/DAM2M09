
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.*;
import java.util.*;

/**
 *
 * @author alumne
 */
public class FileClient {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String ruta = "";
        String linea = "";

        Socket socket = new Socket("localhost", 7000);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        boolean fileExist = false;

        try {

            // Demanarem una ruta a l'usuari fins que no rebem fitxer no trobat del server
            System.out.println("Entra la ruta del fitxer que vols llegir:");

            while (!fileExist) {

                // Demanem la ruta a l'usuari
                ruta = scan.nextLine();

                // Enviem la ruta al server
                dos.writeUTF(ruta);

                // Legim la resposta del server
                linea = dis.readUTF();

                // Si no ens retorna File Not Found
                // el fitxer existeix i ja tenim la primera línea
                if (!"/FNF;".equals(linea)) {
                    fileExist = true;
                } else {
                    System.out.println("Ruta incorrecta. Entra nova ruta.");
                }

            }

            // Mentre el server no ens indiqui que hem acabat anem llegint el que ens envia
            while (!"/EOF;".equals(linea)) {
                // I o mostrem per pantalla
                System.out.println(linea);
                linea = dis.readUTF();
            }
            // Un cop llegit el fitxer desconectem
            socket.close();
        } catch (SocketException ex) {
            System.out.println("Servidor no disponible.");

        }

    }

}
