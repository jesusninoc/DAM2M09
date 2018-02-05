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
public class Juego {
    public static void main(String[] args) {
        final int N_HAB = 1; //habitaciones del escenario
        final int N_ACT = 2; //actores en el escenario
        
        Escenario = e new Escenario(N_HAB);
        Actor[] agente = new Actor[N_ACT];
        for (int i = 0; i < N_ACT; i++) {
            agente[i] = new Actor(e,"Agente " + i);
            agente[i].situarEn((int)(MathRandom() * N_HAB));
            agente[i].start();
        }
    }
    
}
