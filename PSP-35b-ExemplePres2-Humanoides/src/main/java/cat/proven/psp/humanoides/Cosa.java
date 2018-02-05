/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.humanoides;

/**
 *
 * @author mercedes
 */
public class Cosa {
    private int x,y,z; //posicion 3D
    private int nom; //identificador de cada objeto

    public Cosa(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Cosa() {
        this (0,0,0);
    }
    
    public void putNombre(int n){
        this.nom = n;
    }
    
    public Boolean mayorQue(Cosa c) {
        boolean mayor = false;
        
        if (this.x > c.x) {mayor = true;}
        else if (this.y > c.y) {mayor = true;}
        else if (this.z > c.z) {mayor = true;}        
        return mayor;
    }
    
    public String toString() {
        String str;
        
        str = "C" + this.nom + " (" + this.x + ", " + this.y + ", " +
                this.z + ")";
        return str;
    }
    
}//fin Cosa
