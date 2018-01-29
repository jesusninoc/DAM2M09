/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.exemplecola;

/**
 *
 * @author alumne
 */
public class Cola {
    private int [] _datos;
    private int _sigEnt, _sigSal, _ocupados, _tamano;
    
    public Cola(int tam) {
        _datos=new int [tam];
        _tamano=tam;
        _ocupados=0;
        _sigEnt=1;
        _sigSal=1;
        
    }
    
    public synchronized void almacenar(int x){
        try{
            while (_ocupados == _tamano) wait();
            _datos[_sigEnt]=x;
            _sigEnt = (_sigEnt +1)% _tamano;
            _ocupados++;
            notify();
        }catch (InterruptedException e){
            System.out.println("ERROR: interruptedException");
        }
    }
    
    public synchronized int extraer(){
        int x=0;
        try{
            while (_ocupados == 0) wait();
            x= _datos[_sigSal];
            _sigSal = (_sigSal +1)% _tamano;
            _ocupados--;
            notify();
        }catch (InterruptedException e){
            System.out.println("ERROR: interruptedException");
        }        
       return x; 
    }
}
