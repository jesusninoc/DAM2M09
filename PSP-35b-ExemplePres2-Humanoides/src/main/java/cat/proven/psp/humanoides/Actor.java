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
public class Actor extends Thread{
    private Escenario mundo; // escenario en el que se mueve
    private Habitacion donde; //habitacion en la que esta
    private String nombre; //identificador

    public Actor(Escenario mundo, String nombre) {
        this.mundo = mundo;
        this.nombre = nombre;
        this.situarEn(0);
    }
    
    private void navegar() {
        try {
            sleep ((long) (Math.random() *100.0));
        }
        catch (InterruptedException e){
            
        }
    }
    
    
    
}
