package cat.proven.psp.chatserver;

import java.io.DataInputStream;
import java.net.*;

/**
 * Xat Server. Thread que llegeix del stream d'entrada del socket
 *  i la mostra per pantalla
 * Acaba quan rep un "."
 *
 * @author alumne
 */
public class InputController extends Thread {

    Socket socket;
    String user;

    /**
     * Constructor
     *
     * @param socket socket d'on llegirem
     * @param user Nom usuari
     */
    public InputController(Socket socket, String user) {
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
            while (!s.equals(".")) {

                // LLegeix el que entra pel socket
                DataInputStream din = new DataInputStream(socket.getInputStream());
                s = din.readUTF();

                // Ho mostra per pantalla
                System.out.println(user + " said: " + s);
            }
        } catch (SocketException ex) {
            System.out.println("Input controller: Desconnectat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Client desconectat...");
    }
}
