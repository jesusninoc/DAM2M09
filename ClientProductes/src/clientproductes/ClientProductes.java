/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientproductes;

import products.Product;
import products.WSproducts_Service;

/**
 *
 * @author alumne
 */
public class ClientProductes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        WSproducts_Service ws = new WSproducts_Service();
       
        Product p = ws.getWSproductsPort().getProduct("");
        
        System.out.println(p.getNombre());
        
    }
    
}
