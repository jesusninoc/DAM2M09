
import java.io.DataInputStream;
import java.net.*;

public class ServerMsg2 {

/*
    Provar cas error 'Usuari desconnectat:
    executar servidor
    executar client (es conectará al servidor)
    aturar client 
    --> el servidor ha de mostrar l'error i esperar al següent client
    */
    public static void main(String[] args) throws Exception {
        String s = "";
        // Instanciar un ServerSocket en el port 7000
        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server is started");
        while (true) {
            System.out.println("Servidor esperant connexió dels clients....");
            Socket socket = server.accept();
            System.out.println("Usuari connectat des de la IP: " + socket.getRemoteSocketAddress());
            try {
                // obtenir el InputStream del Socket (per rebre info del client), i utilitzem el DataInputStream
                DataInputStream din = new DataInputStream(socket.getInputStream());
                while (!".".equals(s)) {
                    //llegir amb metode readUTF
                    s = din.readUTF();
                    if (!".".equals(s)) {
                        //escriure a la sortida stàndard
                        System.out.println("Missatge:" + s);
                    }
                }
                System.out.println("Usuari desconnectat, rebut missatge final: " + s);
                
            } catch (SocketException ex) {
                //quan el client es desconnecta
                System.out.println("Usuari desconnectat, esperant nova connexió");
                System.out.println("Excepcio " + ex);
            }
            socket.close();
        }
    }
}
