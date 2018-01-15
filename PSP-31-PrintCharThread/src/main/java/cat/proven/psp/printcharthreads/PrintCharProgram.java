/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.printcharthreads;

/**
 *
 * @author alumne
 */
public class PrintCharProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       try 
       { 
        Thread primer = new PrintChar('a', 1000);
        Thread segon = new PrintChar('b', 1000);
        Thread tercer = new PrintChar('c', 1000);

         primer.start();
         segon.start();
         tercer.start();
         
         primer.join();
         segon.join();
         tercer.join();
        
         System.out.println("Final Fil Principal");
         }catch(Exception ex){
           System.out.println(ex.getMessage());
         }
    }
    
}
