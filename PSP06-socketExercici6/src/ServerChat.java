
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;
import java.net.BindException;

/**
 *
 * @author alumne
 */
public class ServerChat {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String entradaTeclat = "";
        String missatge = "";
        Scanner scan = new Scanner(System.in);

        try {
        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server is started");

        while (true) {

            System.out.println("Esperant nou client... ");
            Socket socket = server.accept();

            System.out.println("Client connectat: " + socket.getRemoteSocketAddress());

            try {
                // input stream per rebre missatges del client
                DataInputStream din = new DataInputStream(socket.getInputStream());
                // output stream per enviar missatges al client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                while (!".".equals(missatge) && !".".equals(entradaTeclat)) {
                    // Espero que el client m'escrigui alguna cosa
                    missatge = din.readUTF();

                    // Si no és la ordre de sortir la mostro per pantalla
                    // Després llegiré la resposta del teclat i l'escriuré al Socket
                    if (!".".equals(missatge)) {
                        System.out.println("Client diu: " + missatge);
                        
                        System.out.println("Escriu resposta (. per acabar):");
                        //llegir resposta del teclat
                        entradaTeclat = scan.nextLine();

                        //enviar resposta al client
                        dos.writeUTF(entradaTeclat);
                    } else {
                        System.out.println("Client desconnectat (fi de transmissió)");
                    }

                }
            } catch (SocketException ex) {
                System.out.println("Client desconnectat");
                System.out.println("Excepció: " + ex);
            } catch (EOFException ex) {
                System.out.println("Client desconnectat");
                System.out.println("Excepció: " + ex);

            } catch (Exception ex) {
                System.out.println("Error amb la connexió...");
                System.out.println("Excepció: " + ex);
            }
            entradaTeclat="";
            missatge="";   
            socket.close();
        }
        
        }catch (BindException ex) {
          System.out.println("El port ja està agafat");  
            
        }
            
    }
}
