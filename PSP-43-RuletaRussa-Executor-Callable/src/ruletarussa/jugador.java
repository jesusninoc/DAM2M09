/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruletarussa;

/**
 *
 * @author dmalb
 */
import static java.lang.Thread.sleep;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class jugador implements Callable{
    
    String nom;
    pistola pistola;
    int njugs;
    private boolean viu=true;
    
    public jugador(String nom, pistola pistola)
    {
        this.nom = nom; 
        this.pistola = pistola;
        this.njugs = pistola.getnjugs();
        
    }
    
    @Override
    public String call() {

        while(this.njugs>1){    //mentres estiguis viu i quedin contrincants la partida seguei
            njugs=pistola.getnjugs();
            /*try {
                    sleep((int)(1000)); // PAUSA DRAMÀTICA
            } catch (InterruptedException e) {}*/
            viu = pistola.disparar(nom);
            if (!viu){
               return nom+" MORT AMB "+pistola.getnjugs()+" JUGADORS VIUS";
            }
        }       
        //System.out.println("Felicitats! "+this.nom+" ha guanyat");
        return nom+" VIU";
    }
}
