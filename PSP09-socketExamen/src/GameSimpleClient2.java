
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * * * @author alumne
 */
public class GameSimpleClient2 {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String entradaTeclat;
        String respostaServidor;
        
        String rutaConfigFile = "files/config.cfg";
        String gameIP;
        int gamePort;
        
        System.out.println("Test Game Server");

        //obtenim la ip i el port d'un fitxer de configuracio
        if (!new File(rutaConfigFile).isFile()) {
            //si no trobem el fitxer acabem
            System.out.println("El fitxer de configuració config.cfg no existeix");
        } else {

            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(rutaConfigFile));

                gameIP = reader.readLine();
                gamePort = Integer.parseInt(reader.readLine());
                reader.close();
                System.out.println("LLegit fitxer de configuració config.cfg: IP=" + gameIP + " Port=" + gamePort);

                //Instanciem Scanner per llegir de l'entrada estandar 
                Scanner scan = new Scanner(System.in);

                try {
                    //iniciem el socket, indicant la IP del servidor i el port del servidor
                    //obtinguts del fitxer de configuració
//                Socket socket = new Socket("localhost", 7000);
                    Socket socket = new Socket(gameIP, gamePort);
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

                            //enviar al servidor l'ordre pel socket
                            dos.writeUTF(entradaTeclat);
                            
                            // Un cop enviada l'ordre al servidor, si no he enviat l'ordre de desconexió (QUIT)
                            // espero la resposta del Server i la mostro per pantalla
                            if (!"QUIT".equals(entradaTeclat)) {
                                //rebre resposta del servidor pel socket
                                respostaServidor = dis.readUTF();
                                //mostrar la resposta en pantalla (sortida stàndard) a l'usuari
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

            } catch (IOException ex) {
                System.out.println("ERROR: Error llegint fitxer de configuració config.cfg" + ex);
            }

        }
    }
}
