
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alumne
 */
public class FileServer {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String ruta = "";
        Path fp;
        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Server is started");

            while (true) {

                System.out.println("Esperant nou client... ");

                // Esperar client
                Socket socket = server.accept();

                try {
                    System.out.println("Client connectat: " + socket.getRemoteSocketAddress());

                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    DataInputStream dis = new DataInputStream(socket.getInputStream());

                    // Llegir la ruta del fitxer del client
                    ruta = dis.readUTF();

                    // Comprovem si el fitxer existeix 
                    //amb java.io.File seria:
                    //while (!(new File(ruta).isFile())) {                 

                    //using new java.nio.file package
                    // tutorial https://docs.oracle.com/javase/tutorial/essential/io/index.html
                    // check https://docs.oracle.com/javase/tutorial/essential/io/legacy.html
                    fp = Paths.get(ruta);
                    // while (!Files.exists(fp)) { //nomes si existeix                       
                    while (!Files.isReadable(fp)) { //mirem si existeix i si el podem llegir
                    
                        // Si no existeix indiquem al client que no existeix
                        // i seguim esperant una ruta correcta.
                        dos.writeUTF("/FNF;");
                        ruta = dis.readUTF();
                        fp = Paths.get(ruta);
                    }
                    
                    // Creem el reader del fitxer amb la ruta que ha enviat el client
                     BufferedReader reader = new BufferedReader(new FileReader(fp.toFile()));
                   
                     //si no utilitzem file.nio.file.Path
                    //BufferedReader reader = new BufferedReader( new FileReader(ruta) );

                    String linea;

                    // Anem llegint linea a linea el fitxer
                    while ((linea = reader.readLine()) != null) {
                        // Enviem la linea al client
                        dos.writeUTF(linea);
                    }

                    // Quan hem llegit tot el fitxer informem al client que hem acabat
                    dos.writeUTF("/EOF;");

                    // IMPORTANT: tanquem el fitxer
                    reader.close();

                } catch (SocketException ex) {
                    System.out.println("Client desconnectat... ");

                }

            }
            
        } catch (BindException ex) {
            System.out.println("El port ja està agafat");

        }
    }

}
