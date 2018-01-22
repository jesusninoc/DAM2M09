package cat.proven.psp.chatclient;

import java.net.Socket;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.net.*;

/**
 * Xat Client. Thread que llegeix del teclat 
 * i escriu al stream de sortida del socket.
 * 
 * Acaba quan rep un "." pel teclat
 *
 * @author alumne
 */
public class OutputController extends Thread {

    private Socket socket;

    /**
     *
     * @param socket
     */
    public OutputController(Socket socket) {

        this.socket = socket;
    }
    
    /**
     * Codi que s'executa en paral·lel: Llegeix del socket i mostra per pantalla
     * el que ha llegit
     */
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        String entradaTeclat = "";
        try {

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (!entradaTeclat.equals(".")) {

                // Llegim el que  entrem per teclat
                entradaTeclat = scan.nextLine();

                //Ho enviem pel socket
                dos.writeUTF(entradaTeclat);

            }

            System.out.println("Desconnectant...");
        } catch (SocketException ex) {
            System.out.println("Output Controller: Desconnectat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
