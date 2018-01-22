package cat.proven.psp.chatserver;

import java.net.Socket;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.net.*;

/**
 * Xat Server. Thread que llegeix del teclat 
 * i escriu al stream de sortida del socket.
 * 
 * Per finalitzar s'ha d'executar el mètode stopThread()
 *
 * @author alumne
 */
public class OutputController extends Thread {

    private Socket socket;
    private boolean stop = false;

    /**
     * Constructor
     *
     * @param socket socket on escriura
     */
    public OutputController(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        String entradaTeclat = "";
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (!this.stop) {

                // Llegim el que entrem per teclat
                entradaTeclat = scan.nextLine();

                //Ho enviem pel socket
                dos.writeUTF(entradaTeclat);
            }
        } catch (SocketException ex) {
            System.out.println("Output Controller: Desconnectat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * aturar el thread, per mitjà d'una variable
     */
    public void stopThread() {
        this.stop = true;
    }
}
