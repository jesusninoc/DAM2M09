package cat.proven.psp.chatserver;

import java.io.BufferedReader;
import java.net.Socket;
//import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Xat Server. Thread que llegeix del teclat i escriu al stream de sortida del
 * socket.
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
        //Canviem Scanner per BufferedReader que te metodes no bloquejants
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entradaTeclat = "";
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (!this.stop) {

                // Llegim el que entrem per teclat (bloqueja)
                //entradaTeclat = scan.nextLine();
                
                //Canviem la forma de llegir del teclat per no quedarnos bloquejats:
                // ho fem amb BufferedReader que te metodes no bloquejants
                //comprovem primer si hi ha alguna cosa a llegir
                // sino esperem amb sleep (no ocupem CPU), sleep és interrumpible
                // i per altra banda al acabar comprovarem la var stop
                boolean nextLine = false;
                while (!this.stop && !nextLine) {
                    //Comprovem si hi ha alguna cosa a llegir (no bloqueja)
                    if (br.ready()) {
                        nextLine = true;
                        // Llegim el que entrem per teclat (bloqueja i no rep la interrupcio)
                        entradaTeclat = br.readLine();
                    } else {
                        //esperem 200 milisegons
                        // sense acaparar 100% CPU, sleep() rep excepció Thread interrupt 
                        sleep(200);
                    }
                }

                //Ho enviem pel socket
                if (!this.stop) {
                    dos.writeUTF(entradaTeclat);
                }
            }
            System.out.println("Output Controller: Finalitzat");
        } catch (SocketException ex) {
            System.out.println("Output Controller: Desconnectat");
        } catch (InterruptedException e2) {
            System.out.println("Output Controller: Interrumpit");
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
