/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class FraseClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

       System.out.println("Escriu una frase: ");
       String frase = scan.nextLine();
       
       int paraules = numParaules(frase);
       int lletres = numLletres(frase);
        System.out.println("La frase '"+ frase + "' té "+ paraules + " paraules i " + lletres +" lletres");
    }

    private static int numLletres(java.lang.String frase) {
        exam.Frase_Service service = new exam.Frase_Service();
        exam.Frase port = service.getFrasePort();
        return port.numLletres(frase);
    }

    private static int numParaules(java.lang.String frase) {
        exam.Frase_Service service = new exam.Frase_Service();
        exam.Frase port = service.getFrasePort();
        return port.numParaules(frase);
    }
    
}
