package cat.proven.psp.chatclient;

import java.net.Socket;

/**
 * Part Client del
 *  xat Client/Servidor que utilitza threads per tal de que el programa no
 *  es quedi bloquejat esperant rebre una dada de teclat o una dada del socket.
 * 
 * @author alumne
 */
public class ChatClient {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // Creem un socket on ens connectem
            Socket socket = new Socket("localhost", 9000);
            System.out.println("Connectat");
            
            // Creem un thread per controlar el que entra pel socket
            // i ho mostra per pantalla
            InputController input = new InputController(socket, "Server");
            input.start();

            // Creem un altre thread per controlar el que enviarem pel socket
            OutputController output = new OutputController(socket);
            output.start();

            //esperem que acabi el thread que llegeix de teclat, 
            //acaba quan l'usuari escriu un "."
            output.join();

            System.exit(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
