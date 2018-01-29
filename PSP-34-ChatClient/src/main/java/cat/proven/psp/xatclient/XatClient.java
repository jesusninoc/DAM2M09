package cat.proven.psp.xatclient;

import java.net.Socket;

/**
 * Part Client del
 *  xat Client/Servidor que utilitza threads per tal de que el programa no
 *  es quedi bloquejat esperant rebre una dada de teclat o una dada del socket.
 * 
 * @author alumne
 */
public class XatClient {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Chat Client");
            System.out.println("-----------");
            // Creem un socket on ens connectem
            Socket socket = new Socket("localhost", 9000);
            System.out.println("Connectat");
            
            // Creem un thread per controlar el que entra pel socket
            // i ho mostra per pantalla
            InputSocketController input = new InputSocketController(socket, "Server");
            input.start();

            // Creem un altre thread per controlar el que enviarem pel socket
            OutputSocketController output = new OutputSocketController(socket);
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
