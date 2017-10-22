
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

import java.net.*;
import java.util.*;

/**
 *
 * @author alumne
 */
public class ClientChat {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String entradaTeclat = "";
        String entradaSocket = "";

        try {
            Socket socket = new Socket("localhost", 7000);

            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                System.out.println("Envia un missatge al servidor, rebràs reposta (. per acabar)");
                while (!".".equals(entradaTeclat) && !".".equals(entradaSocket)) {

                    // LLegir del teclat (entrada stàndard)
                    entradaTeclat = scan.nextLine();
                    //enviar al servidor pel socket
                    dos.writeUTF(entradaTeclat);

                    // Un cop enviat el missatge al servidor, si no he enviat l'ordre de desconexió 
                    // espero la resposta del Server i la mostro per pantalla
                    if (!".".equals(entradaTeclat)) {
                        //rebre resposta del servidor pel socket
                        entradaSocket = dis.readUTF();
                        
                        if (!".".equals(entradaSocket)) {
                            //mostrar la resposta en pantalla (sortida stàndard)
                            System.out.println("Servidor respon: " + entradaSocket);
                            
                            //indicar al usuari que ja pot escriure
                            System.out.println("Escriu nou missatge (. per acabar): ");
                        }
                        else {
                            System.out.println("Connexió finalitzada pel servidor");
                        }

                    }

                }
            } catch (SocketException | EOFException ex) {
                System.out.println("Servidor desconnectat");
            }
        } catch (SocketException ex2) {
            System.out.println("No s'ha trobat el servidor");
        }

    }

}
