/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.exconcurrent;

/**
 *
 * @author alumne
 */
public class E_Adeu implements Runnable{
    

 public E_Adeu() {
       new Thread(this, "Adeu").start();
    }

 @Override
    public void run() {
        try {
            for (int x = 0; x < 5; x++) {
                Thread.sleep(1000);
                System.out.println("Adeu");
                
            }
        } catch (Exception e) {
        }
    }
}
