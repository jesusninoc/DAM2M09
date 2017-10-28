
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;
import java.net.BindException;

/**
 *
 * @author alumne
 */
public class GameServer {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int posInt;
        String posString;

        String ordre;
        String resposta;
        
        //inicialitzem la GestioPremis 
        GestioPremis premis = new GestioPremis();

        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Game Server is started");

            while (true) {

                //initialitzacions per cada client:

                //initialitzo l'ordre rebuda
                ordre = "";
                //initialitzo la resposta
                resposta = "";

                System.out.println("Esperant nou client... ");
                Socket socket = server.accept();

                System.out.println("Client connectat: " + socket.getRemoteSocketAddress());

                try {
                    // input stream per rebre missatges del client
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    // output stream per enviar missatges al client
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    do {
                        // Espero rebre ordres del client
                        ordre = din.readUTF();

                        // Mostro per pantalla l'ordre rebuda
                        System.out.println("Client diu: " + ordre);
                      
                        // Si no és la ordre de sortir analitzem l'ordre per fer
                        // la tasca corresponent
                        if (!"QUIT".equals(ordre)) {

                            //processar l'ordre, fer la tasca i omplir la resposta
                            if (ordre.startsWith("PUT")) {
                                //ordre per afegir un premi
                                
                                //comprovem si ja hi ha el màxim numero de premis
                                if (premis.countPremis() == GestioPremis.MAX_PREMIS) {
                                    resposta = "QUANTITAT MÀXIMA DE PREMIS (TOTAL " + premis.countPremis() + " PREMIS)";
                                } else {
                                    //Obtenim la posició i comprovem que esta entre 0 i 9
                                    // Del string ordre agafem el substring de la posicio 3 fins el final
                                    // i o pasem a int
                                    posString = ordre.substring(3);
                                    try {
                                        //convertim de string a int
                                        posInt = Integer.parseInt(posString);
                                        //comprovem que sigui un valor entre 0 i 10
                                        if (posInt >= 0 && posInt < 10) {
                                            //mostrar per pantalla la ordre que executarem
                                             System.out.println("Ordre a executar PUT, posició " + posString);
                                            //si la posicio es vàlida, afegim el premi
                                            if (premis.afegirPremi(posInt)) {
                                                resposta = "NOU PREMI AFEGIT A LA POSICIÓ " + posString + " (TOTAL " + premis.countPremis() + " PREMIS)";
                                            } else {
                                                resposta = "PREMI NO AFEGIT (TOTAL " + premis.countPremis() + " PREMIS)";
                                            }
                                        } else {
                                            //posició numérica pero no vàlida
                                            resposta = "ERROR: posició incorrecta " + posString;
                                        }
                                    } catch (NumberFormatException ex) {
                                        //excepció al passar de string a int
                                        resposta = "ERROR: posició no numérica " + posString;
                                    }
                                }

                            } else if (ordre.startsWith("GET")) {
                                //ordre per obtenir premi
                                
                                //extraiem la posicio
                                posString = ordre.substring(3);
                                try {
                                    //convertim de string a int
                                    posInt = Integer.parseInt(posString);
                                    //comprovem que sigui un valor entre 0 i 10
                                    if (posInt >= 0 && posInt < 10) {
                                        //mostrar per pantalla la ordre que executarem
                                        System.out.println("Ordre a executar GET, posició " + posString);
                                        //amb el metode obtenirPremi, retorna true quan hi ha premi
                                        if (premis.obtenirPremi(posInt)) {
                                            resposta = "HAS GUANYAT UN PREMI!!!";
                                        } else {
                                            resposta = "HO SENTIM, NO HAS ENCERTAT!!! (QUEDEN " + premis.countPremis() + " PREMIS)";
                                        }

                                    } else {
                                         //posició numérica pero no vàlida
                                        resposta = "ERROR: posició incorrecta " + posString;
                                    }
                                } catch (NumberFormatException ex) {
                                     //excepció al passar de string a int
                                    resposta = "ERROR: posició no numérica " + posString;
                                }
                            } else {
                                //ordre no correspon ni a PUT ni GET ni QUIT
                                resposta = "ERROR: No entenc l'ordre rebuda: " + ordre;

                            }

                            //enviar resposta al client
                            dos.writeUTF(resposta);

                            //mostrar per pantalla (sortida standard) la resposta enviada
                            System.out.println("Resposta enviada: " + resposta);

                        } else {
                            System.out.println("Client desconnectat (fi de transmissió)");
                        }

                    } while (!"QUIT".equals(ordre));

                    din.close();
                    dos.close();
                    socket.close();

                } catch (SocketException | EOFException ex) {
                    System.out.println("Client desconnectat");
                    System.out.println("Excepció: " + ex);
                } catch (Exception ex) {
                    System.out.println("Error amb la connexió...");
                    System.out.println("Excepció: " + ex);
                }

            }

        } catch (BindException ex) {
            System.out.println("El port ja està agafat");
            System.out.println("Excepció: " + ex);

        }

    }
}
