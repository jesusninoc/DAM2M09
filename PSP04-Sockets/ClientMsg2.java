
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class ClientMsg2 {

    public static void main(String[] args) throws Exception {

        String entrada = "";
        int c;

        try {
            Socket socket = new Socket("localhost", 7000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Entra les frases que vulguis enviar. Acaba enviant només un .");

            while (!".".equals(entrada)) {
                try {
                    Scanner scan = new Scanner(System.in);
                    entrada = scan.nextLine();
                    /* escriu al stream de sortida el texte introduit per l'usuari */
                    dos.writeUTF(entrada);

                } catch (IOException ex) {
                    System.out.println("Servidor desconnectat");
                }
            }

        } catch (SocketException ex) {
            System.out.println("No s'ha trobat el Servidor");
        }
    }
}
