/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlbanc;

/**
 *
 * @author carlos
 */
public class recaudador extends Thread{
    
    monitor myMonitor;
    
    public recaudador(monitor myMonitor)
    {
        this.myMonitor = myMonitor;
        this.start();
    }
    
    public void run()
    {
        while (true)
        {
           myMonitor.recaudar(100);
        }
    }
    
}
