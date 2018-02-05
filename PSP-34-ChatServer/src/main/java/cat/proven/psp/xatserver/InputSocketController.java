package cat.proven.psp.xatserver;

import java.io.DataInputStream;
import java.net.*;

/**
 * Thread que llegeix del stream d'entrada del socket
 *  i la mostra per pantalla, a la Part Servidora del Xat.
 * Acaba quan rep un "."
 *
 * @author alumne
 */
public class InputSocketController extends Thread {

    Socket socket;
    String user;

    /**
     * Constructor
     *
     * @param socket socket d'on llegirem
     * @param user Nom usuari
     */
    public InputSocketController(Socket socket, String user) {
        this.socket = socket;
        this.user = user;
    }

    /**
     * Codi que s'executa en paral·lel: Llegeix del socket i mostra per pantalla
     * el que ha llegit
     */
    @Override
    public void run() {
        try {
            String s = "";
            //obté el canal d'entrada del socket
            DataInputStream din = new DataInputStream(socket.getInputStream());
            while (!s.equals(".")) {
                // LLegeix el que entra pel socket              
                s = din.readUTF();

                // Ho mostra per pantalla
                System.out.println(user + " said: " + s);
            }
            System.out.println("InputSocketController: Finalitzar");
        } catch (SocketException ex) {
            System.out.println("InputSocketController: Socket desconnectat");
        } catch (Exception ex) {
            System.out.println("InputSocketController: Excepció -> " + ex.getMessage());
        }
    }
}
