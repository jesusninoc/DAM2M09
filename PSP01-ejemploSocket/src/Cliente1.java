
import java.io.DataInputStream;
import java.io.IOException;
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
public class Cliente1 {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.127.53", 9500);
            System.out.println("Cliente1: Conectat! a " + s.getRemoteSocketAddress());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String a = dis.readUTF();
            System.out.println("Cliente1:Server says: " + a);
            System.out.println("escriu per tancar");
            System.in.read();
            s.close();
        } catch (IOException ex) {
            ex.getLocalizedMessage();
            //Logger.getLogger(Cliente1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
