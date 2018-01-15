/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.printcharrunnable;

/**
 *
 * @author alumne
 */
public class PrintCharRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Creem els objectes de la classe runnable

            PrintChar pc1 = new PrintChar('a', 10000);
            PrintChar pc2 = new PrintChar('b', 10000);
            PrintChar pc3 = new PrintChar('c', 10000);

            // Creem threads que executin els objectes de la classe runnable
            Thread thread1 = new Thread(pc1);
            Thread thread2 = new Thread(pc2);
            Thread thread3 = new Thread(pc3);

            // Executem els fils
            thread1.start();
            thread2.start();
            thread3.start();

            // Esperem la finalització dels fils
            thread1.join();
            thread1.join();
            thread1.join();

            System.out.println("Final Fil Principal");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
