/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.exruletarussa;

/**
 *
 * @author dmalb
 */
import java.util.Random;

public class pistola {
 
    public pistola()
    {
    }
 
    public boolean  disparar(String jugador)
    {
        boolean viu=true;
        System.out.println(jugador + " agafa la pistola...");
        Random rand = new Random();
        int randomNum = rand.nextInt(6);//num aleatori entre 0-5 (un revolver te 6 bales)
        if (randomNum==0){
            viu = false; //BANG!
            System.out.println("BANG!!!");
        }else{
            System.out.println("clic");
        }
        return viu;
    }

    
}