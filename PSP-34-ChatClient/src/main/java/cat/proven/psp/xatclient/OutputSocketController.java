package cat.proven.psp.xatclient;

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
public class OutputSocketController extends Thread {

    private Socket socket;

    /**
     *
     * @param socket
     */
    public OutputSocketController(Socket socket) {

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
            System.out.println("OutputSocketController: finalitzar connexió");
            
        } catch (SocketException ex) {
            System.out.println("OutputSocketController: canal desconnectat");
        } catch (Exception ex) {
            System.out.println("OutputSocketController: Excepció -> " + ex.getMessage());
        }

    }

}
