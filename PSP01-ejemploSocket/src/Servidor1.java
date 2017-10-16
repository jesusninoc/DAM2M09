
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumne
 */
public class Servidor1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(9500);
            System.out.println("Servidor1: Esperant conexions");
            while (true) {

                Socket socket = server.accept();
                System.out.println("Servidor1: Client connectat...");

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("Servidor1: Hola " + socket.getRemoteSocketAddress() + " te has conectado a " + socket.getLocalSocketAddress());
                System.out.println("Servidor1: cliente en " + socket.getRemoteSocketAddress());
                socket.close();

            }
        } catch (IOException ex) {
            ex.getLocalizedMessage();
            //Logger.getLogger(Servidor1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
