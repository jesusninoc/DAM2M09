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
public class Escenario {
    private Habitacion[] elementos; //habitaciones del escenario
    private static final int n_cosas = 10 //num. cosas en la habitacion
            
    public Escenario(int num) {
        elementos = new Habitacion[num];
        for (int i = 0; i < num; i++) {
            elementos[i] = new Habitacion(n_cosas);
            
        }
        
    }
    public Habitacion getHabitacion(int ind){
        return elementos[ind];
    }
    
}
