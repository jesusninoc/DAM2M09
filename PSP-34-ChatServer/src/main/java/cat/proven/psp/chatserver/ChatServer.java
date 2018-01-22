package cat.proven.psp.chatserver;

import java.net.*;

/**
 * Part Servidora del
 *  xat  Client/Servidor que utilitza threads per tal de que el programa no
 *  es quedi bloquejat esperant rebre una dada de teclat o una dada del socket.
 * @author alumne
 */
public class ChatServer {

    /**
     *  Programa principal
     * @param args 
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        // Arranquem el server Socket		
        ServerSocket server = new ServerSocket(9000);
        System.out.println("Server is started");

        while (true) {
            System.out.println("Esperant nou client... ");

            Socket socket = server.accept();

            System.out.println("Client connectat: " + socket.getLocalAddress() + ":" + socket.getPort());

            // Creem un thread per controlar el que el client ens envia pel socket
            InputController input = new InputController(socket, "Client");
            input.start();

            // Creem un thread per enviar el que entrem per teclat cap al Socket
            OutputController output = new OutputController(socket);
            output.start();

            //esperem que el thread d'entrada acabi (el client tanca la connexió quan escriu un ".")
            // i solicitem que el thread de sortida acabi
            input.join();
            output.stopThread();
             
            //esperem que el thread de sortida acabi 
            output.join();
            System.out.println("Sessió finalitzada");

        }
    }
}
