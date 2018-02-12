/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlparking;

/**
 *
 * @author carlos
 */
public class ControlParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parking parking = new Parking(3);
        for (int i=1; i<= 4; i++) {
        Cotxe c = new Cotxe("Cotxe matrícula " + i, parking);
        }
        Pagament p = new Pagament(parking);
    }
    
}
