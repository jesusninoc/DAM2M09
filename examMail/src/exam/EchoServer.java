package exam;

import java.io.EOFException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.net.BindException;

/**
 *
 * @author alumne
 */
public class EchoServer {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String ordre;
        String resposta;
        MailManteniment mailMant= new MailManteniment("localhost","aplicacio1@proven.cat","mantm09@yopmail.com");
        
        
        System.out.println("Echo Server");
        System.out.println("===========\n");
        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Echo Server is started");

            while (true) {

                //initialitzacions per cada client:

                //initialitzo l'ordre rebuda
                ordre = "";
                //initialitzo la resposta
                resposta = "";

                System.out.println("Esperant nou client... ");
                Socket socket = server.accept();

                System.out.println("Client connectat: " + socket.getRemoteSocketAddress());

                try {
                    // input stream per rebre missatges del client
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    // output stream per enviar missatges al client
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    do {
                        // Espero rebre ordres del client
                        ordre = din.readUTF();

                        // Mostro per pantalla l'ordre rebuda
                        System.out.println("Client diu: " + ordre);
                      
                        // Si no és la ordre de sortir analitzem l'ordre per fer
                        // la tasca corresponent
                        if (!"QUIT".equals(ordre)) {
                            resposta = ordre;
                            //enviar resposta al client
                            dos.writeUTF(resposta);

                            //mostrar per pantalla (sortida standard) la resposta enviada
                            System.out.println("Resposta enviada: " + resposta);

                        } else {
                            System.out.println("Client desconnectat (fi de transmissió)");
                        }

                    } while (!"QUIT".equals(ordre));

                    din.close();
                    dos.close();
                    socket.close();

                } catch (SocketException | EOFException ex) {
                    System.out.println("Client desconnectat");
                    System.out.println("Excepció: " + ex);
                } catch (Exception ex) {
                    System.out.println("Error amb la connexió...");
                    System.out.println("Excepció: " + ex);
                }

            }

        } catch (BindException ex) {
            System.out.println("ERROR: El port ja està agafat");
            System.out.println("Excepció: " + ex);
            mailMant.enviarMail(ex);

        }
    }
}