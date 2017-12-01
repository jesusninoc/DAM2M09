/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Nota;

/**
 *
 * @author mercedes
 */
@WebService(serviceName = "WSAlumnes")
public class WSAlumnes {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNota")
    public Nota getNota(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Nota nota1 = new Nota("m01","Sistemes",9);
        return nota1;
    }
    
}
