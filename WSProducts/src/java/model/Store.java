/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author alumne
 */
@XmlRootElement(name = "products")
public class Store {
    
    List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    @XmlElement
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product p)
    {
        products.add(p);
    }
    
}
