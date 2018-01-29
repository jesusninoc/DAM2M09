/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.xatclient;

import java.io.DataInputStream;
import java.net.*;

/**
 * Xat Client. Thread que llegeix del stream d'entrada del socket
 *  i la mostra per pantalla
 * 
 * És un bucle infinit, acaba quan detecta socket tancat (per excepció) 
 * o quan acaba el procés pare
 * 
 * @author alumne
 */
public class InputSocketController extends Thread {

    Socket socket;
    String user;

    /**
     *
     * @param socket
     * @param user
     */
    public InputSocketController(Socket socket, String user) {
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
            System.out.println("InputSocketController: Canal desconnectat");
        } catch (Exception ex) {
            System.out.println("InputSocketController: Excepció -> " + ex.getMessage());
        }       

    }

}
