/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.chatclient;

import java.io.DataInputStream;
import java.net.*;

/**
 * Xat Client. Thread que llegeix del stream d'entrada del socket
 *  i la mostra per pantalla
 * 
 * @author alumne
 */
public class InputController extends Thread {

    Socket socket;
    String user;

    /**
     *
     * @param socket
     * @param user
     */
    public InputController(Socket socket, String user) {
        this.socket = socket;
        this.user = user;
    }

    public void run() {

        try {

            String s;
            while (true) {

                // LLegeix el que entra pel socket
                DataInputStream din = new DataInputStream(socket.getInputStream());

                s = din.readUTF();

                // Ho mostra per pantalla
                System.out.println(user + " said: " + s);

            }

        } catch (SocketException ex) {
            System.out.println("Input Controller: Desconnectat");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
