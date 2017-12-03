/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumne
 */
@WebService(serviceName = "Frase")
public class Frase {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "numParaules")
    public int numParaules(@WebParam(name = "frase") String frase) {
        String[] paraules= frase.split(" ");
        return paraules.length;
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "numLletres")
    public int numLletres(@WebParam(name = "frase") String frase) {
        String frase2 = frase.replaceAll(" ", "");
        return frase2.length();
    }
}
