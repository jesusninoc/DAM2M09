/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.ruletarussa;

import java.util.Random;
/**
 *
 * @author dmalb
 */
public class pistola {
 
    private int njugs;
    
    public int getnjugs(){
        return this.njugs;
    }
    
    public pistola(int njugs)
    {
        this.njugs = njugs;
    }
 
    public  synchronized boolean  disparar(String jugador)
    {
        boolean viu=true;
        if (njugs ==1) return viu;  //condició de victoria
        System.out.println(jugador + " agafa la pistola...");
        Random rand = new Random();
        int randomNum = rand.nextInt(6);//num aleatori entre 0-5 (un revolver te 6 bales)
        if (randomNum==0){
            viu = false; //BANG!
            this.njugs--; //un jugador menys a la partida
            System.out.println("BANG!!!");
        }else{
            System.out.println("clic");
            viu = true;
        }
        this.notify();
        return viu;
    }

    
}