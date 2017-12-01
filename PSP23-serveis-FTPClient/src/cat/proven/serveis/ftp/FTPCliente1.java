/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.serveis.ftp;

import java.io.*;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author mercedes
 */
public class FTPCliente1 {

    // Datos para la conexion
    String server = "ftp.rediris.es";
    String username = "anonymous";
    String password = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FTPCliente1 ftpc1 = new FTPCliente1();

        //en mi servidor de FTP
//        Listar("prova");
//        getFile("prova/prova.txt","download.txt");
        //en servidor FTP de rediris
        ftpc1.Listar("/");
        ftpc1.getFile("welcome.msg", "bienvenida.txt");
    }

    // Muestra la lista de ficheros
    private void Listar(String path) {
        // Cliente de conexion a FTP
        FTPClient ftp = new FTPClient();

        int respuesta, i;
        String[] lista;

        try {
            System.out.println("CONECTANDO AL SERVIDOR FTP");
            // Conectando e identificandose con el servidos
            ftp.connect(server);
            ftp.login(username, password);
            // Entrando a modo pasivo
            ftp.enterLocalPassiveMode();

            // Obteniendo respuesta del servidos
            respuesta = ftp.getReplyCode();
            System.out.println("RESPUESTA" + respuesta);

            // Si la respuesta del servidor indica podemos pasar procedemos 
            if (FTPReply.isPositiveCompletion(respuesta) == true) {
                System.out.println("LISTANDO ARCHIVOS");

                lista = ftp.listNames(path);

                for (i = 0; i < lista.length; i++) {

                    System.out.println(lista[i]);
                }
                // Si no avisamos
            } else {
                System.out.println("ERROR DE CONEXION");
            }

            // en ambos casos terminaos sesion
            ftp.logout();
            // Y nos desconectamos
            ftp.disconnect();

            // Esta excepcion se lanza en caso de algun error durante el proceso 
        } catch (IOException e) {
            System.out.println("Error de conexion");
        }
    }

    private void getFile(String remoteFilePath, String fileOutput) {

        // Cliente de conexion a FTP
        FTPClient ftp = new FTPClient();

        int respuesta, i;
        String[] lista;

        try {
            System.out.println("CONECTANDO AL SERVIDOR FTP");
            // Conectando e identificandose con el servidos
            ftp.connect(server);
            ftp.login(username, password);
            // Entrando a modo pasivo
            ftp.enterLocalPassiveMode();

            // Obteniendo respuesta del servidos
            respuesta = ftp.getReplyCode();
            System.out.println("RESPUESTA" + respuesta);

            // Si la respuesta del servidor indica podemos pasar procedemos 
            if (FTPReply.isPositiveCompletion(respuesta) == true) {

                File downloadFile1 = new File(fileOutput);
                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                boolean success = ftp.retrieveFile(remoteFilePath, outputStream1);
                outputStream1.close();

                if (success) {
                    System.out.println("Fitxer descarregat correctament...");
                } else {
                    System.out.println("El fitxer no s'ha pogut descarregar...");
                }

                // Si no avisamos
            } else {
                System.out.println("ERROR DE CONEXION");
            }

            // en ambos casos terminaos sesion
            ftp.logout();
            // Y nos desconectamos
            ftp.disconnect();

            // Esta excepcion se lanza en caso de algun error durante el proceso 
        } catch (IOException e) {
            System.out.println("ERROR DE CONEXION");
            // e.printStackTrace();
        }

    }

}
