
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * * * @author alumne
 */
public class GameSimpleClient {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String entradaTeclat;
        String respostaServidor;

        System.out.println("Test Game Server");

        //Instanciem Scanner per llegir de l'entrada estandar 
        Scanner scan = new Scanner(System.in);

        try {
            //iniciem el socket, indicant la IP del servidor i el port del servidor
            //obtinguts del fitxer de configuració
            Socket socket = new Socket("localhost", 7000);
            System.out.println("## connexió correcta");
            try {
                // output stream per enviar missatges al servidor
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                // input stream per rebre missatges del servidor
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                do {
                    //Demanem al usuari la ordre a enviar
                    System.out.println("Escriu ordre: ");
                    entradaTeclat = scan.nextLine();

                    //enviem al servidor l'ordre
                    dos.writeUTF(entradaTeclat);
                    if (!"QUIT".equals(entradaTeclat)) {
                        //espera resposta del servidor
                        respostaServidor = dis.readUTF();
                        //mostra el resultat a l'usuari
                        System.out.println("Resposta Game Server: " + respostaServidor);
                    }

                } while (!"QUIT".equals(entradaTeclat));

                System.out.println("Fi de connexió");

            } catch (SocketException | EOFException ex) {
                System.out.println("ERROR: Servidor desconnectat" + ex);
            }

        } catch (SocketException ex) {
            System.out.println("ERROR: No s'ha trobat el servidor" + ex);
        }

    }
}
