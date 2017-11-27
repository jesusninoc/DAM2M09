package cat.proven;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService (serviceName = "Saluda")
public class MyWebService {
    @WebMethod(action = "dirHola")
    @WebResult(name="saludoresult")
    public String HelloService(@WebParam(name="nom") String name, @WebParam(name="edat") int age){
        return "Hello " + name + " you are " + age + " years old.";
    }
}
