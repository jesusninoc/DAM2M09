/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Product;

/**
 *
 * @author alumne
 */
@WebService(serviceName = "WSproducts")
public class WSproducts {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "id") String id) {
        
        Product p = new Product("qqqw", "sadadasdasdasdasd", 10F);
        
        return p;
    }
    
    @WebMethod(operationName = "getProducts")
    public List<Product> getProducts(@WebParam(name = "id") String id) {
        
        List<Product> productes = new ArrayList<>();
        
        Product p = new Product("qqqw", "sadadasdasdasdasd", 10F);
        Product p1= new Product("aaaaa", "sssssss", 10F);
        Product p2 = new Product("1111", "rrrr", 10F);
        
        productes.add(p);
        productes.add(p1);
        productes.add(p2);
        
        return productes;
    }
    
    
}
