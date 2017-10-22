
import java.io.DataInputStream;
import java.net.*;

public class ServerMsg2 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server Exercici5 is started");
        while (true) {
            System.out.println("Server waiting client connection...");

            Socket socket = server.accept();
            System.out.println("Usuari connectat des de la IP:" + socket.getRemoteSocketAddress());

            try {
                String s = "";
                DataInputStream din = new DataInputStream(socket.getInputStream());
                while (!".".equals(s)) {
                    s = din.readUTF();

                    if (!".".equals(s)) {
                        System.out.println("Missatge:" + s);
                    }

                }

                System.out.println("Client desconnectat(missatge final:" + s + " )");
                
            } catch (SocketException ex) {
                System.out.println("Client desconnectat - Excepcion : " + ex.getLocalizedMessage());
                ex.printStackTrace();
            }
            
            socket.close();

        }

    }
}
