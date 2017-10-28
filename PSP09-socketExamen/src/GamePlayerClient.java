
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
public class GamePlayerClient {

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

        System.out.println("Joc");
        System.out.println("===\n");

        //obtenim la ip i el port d'un fitxer de configuracio
        if (!new File(rutaConfigFile).isFile()) {
            //si no trobem el fitxer acabem
            System.out.println("ERROR: El fitxer de configuració config.cfg no existeix");
        } else {

            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(rutaConfigFile));

                gameIP = reader.readLine();
                gamePort = Integer.parseInt(reader.readLine());
                reader.close();
                //System.out.println("LLegit fitxer de configuració config.cfg: IP=" + gameIP + " Port=" + gamePort);

                //Instanciem Scanner per llegir de l'entrada estandar 
                Scanner scan = new Scanner(System.in);
                try {
                    //iniciem el socket, indicant la IP del servidor i el port del servidor
                    //obtinguts del fitxer de configuració
                    Socket socket = new Socket(gameIP, gamePort);

                    try {
                        // output stream per enviar missatges al servidor
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        // input stream per rebre missatges del servidor
                        DataInputStream dis = new DataInputStream(socket.getInputStream());

                        do {
                            //Demanem al usuari un numero per participar
                            System.out.println("Endevina on està el premi, de 0 a 9 (. per sortir)");
                            entradaTeclat = scan.nextLine();
                            if (".".equals(entradaTeclat)) {
                                //enviem al servidor l'ordre de tancar la connexió i acabem sense esperar resposta
                                dos.writeUTF("QUIT");
                            } else {
                                try {
                                    int posInt = Integer.parseInt(entradaTeclat);
                                    if (posInt >= 0 && posInt <= 9) {

                                        //envia l'ordre al servidor
                                        dos.writeUTF("GET" + entradaTeclat);

                                        //espera resposta del servidor
                                        respostaServidor = dis.readUTF();

                                        //mostra el resultat a l'usuari
                                        System.out.println(respostaServidor);
                                    } else {
                                        System.out.println("posició incorrecta...");
                                    }

                                } catch (NumberFormatException ex) {
                                    System.out.println("posició incorrecta...");
                                }
                            }

                        } while (!".".equals(entradaTeclat));

                        System.out.println("Fi de connexió");

                    } catch (SocketException | EOFException ex) {
                        System.out.println("ERROR: Servidor desconnectat");
                    }

                } catch (SocketException ex) {
                    System.out.println("ERROR: No s'ha trobat el servidor");
                }

            } catch (IOException ex) {
                System.out.println("ERROR: Error llegint fitxer de configuració config.cfg");
            }

        }
    }
}
