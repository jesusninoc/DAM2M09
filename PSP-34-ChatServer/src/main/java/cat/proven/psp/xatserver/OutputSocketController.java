package cat.proven.psp.xatserver;

import java.io.BufferedReader;
import java.net.Socket;
//import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Thread que llegeix del teclat i escriu al stream de sortida del socket, a la
 * Part Servidora del Xat. Per finalitzar s'ha d'executar el mètode
 * stopThread(). (La lectura del teclat es fa de forma no bloquejant, per poder
 * tractar la sol·licitud d'aturar el thread)
 *
 * @author alumne
 */
public class OutputSocketController extends Thread {

    private Socket socket;
    private boolean stop = false;

    /**
     * Constructor del thread
     *
     * @param socket socket on escriura
     */
    public OutputSocketController(Socket socket) {
        this.socket = socket;
    }

    /**
     * Codi que se executa de forma concurrent: Llegeix del teclat i ho envia
     * pel socket. Llegeix del teclat amb BufferedReader (de forma no
     * bloquejant) I escriu al stream de sortida del socket el que llegeix de
     * teclat. Es fa continuament (en un bucle) acaba quan el flag 'stop' està
     * activat
     */
    @Override
    public void run() {

        String entradaTeclat = "";
        boolean textLLegit = false;
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            //Comentat.Canviat Scanner per BufferedReader que té metodes no bloquejants
            //Scanner scan = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (!this.stop) {

                // Comentat.Canviat Scanner per BufferedReader
                //entradaTeclat = scan.nextLine();
                
                // LLegeix del teclat amb un timer, 
                // i així comprovar el flag 'stop' a cada timer.
                textLLegit = false;
                while (!this.stop && !textLLegit) {
                    //Comprova si hi ha alguna cosa a llegir (no bloqueja)
                    if (br.ready()) {
                        // Llegeix el que l'usuari escriu pel teclat (bloqueja i no rep la interrupcio)
                        entradaTeclat = br.readLine();
                        textLLegit=true;
                    } else {
                        //espera 200 milisegons, amb sleep()
                        // sleep() no ocupa CPU, sleep() pot rebre l'excepció Thread interrupt 
                        sleep(200);
                    }
                }

                //Envia pel socket el text rebut pel teclat
                if (!this.stop) {
                    dos.writeUTF(entradaTeclat);
                    
                }
            }
            System.out.println("OutputSocketController: Finalitzat");
        } catch (SocketException ex) {
            System.out.println("OutputSocketController: Desconnectat");
        } catch (InterruptedException e2) {
            System.out.println("OutputSocketController: Interrumpit");
        } catch (Exception ex) {
            System.out.println("OutputSocketController: Excepció -> " + ex.getMessage());
        }
    }

    /**
     * Atura el thread per mitjà d'una variable (el flag 'stop')
     */
    public void stopThread() {
        this.stop = true;
    }
}
