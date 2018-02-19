package cat.proven.psp.matematiquesexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Programació paral·lela amb el framework executor de Java.
 * 
 * La classe fils implementa Callable.
 * 
 * Objectiu: Trobar tots els números divisibles per 2 i per 3 més petits de 100. 
 * Creant tasques per tal que verifiquin si un número és múltiple de 2 
 * i també crear tasques per veure si són múltiples de 3. 
 * Per últim s’han de mostrar els que són múltiples dels dos.
 * 
 * 
 * @author ioc
 */
public class MatematiquesExecutor {

    static class Divisor implements Callable<Boolean> {

        private int numero;
        private int divisor;

        public Divisor(int numero, int divisor) {
            this.numero = numero;
            this.divisor = divisor;
        }

        @Override
        public Boolean call() throws Exception {
            if ((numero % divisor) == 0) {
                return true;
            }
            return false;
        }
    }

    /**
     *
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(3);
        List<Divisor> llistaTasques2 = new ArrayList<Divisor>();
        List<Divisor> llistaTasques3 = new ArrayList<Divisor>();

        for (int i = 0; i < 100; i++) {
            Divisor calculaDivisor2 = new Divisor(i, 2);
            llistaTasques2.add(calculaDivisor2);
            Divisor calculaDivisor3 = new Divisor(i, 3);
            llistaTasques3.add(calculaDivisor3);

        }
        List<Future<Boolean>> llistaResultats2;
        llistaResultats2 = executor.invokeAll(llistaTasques2);
        List<Future<Boolean>> llistaResultats3;
        llistaResultats3 = executor.invokeAll(llistaTasques3);

        executor.shutdown();
        for (int i = 0; i < llistaResultats2.size(); i++) {
            Future<Boolean> resultat2 = llistaResultats2.get(i);
            Future<Boolean> resultat3 = llistaResultats3.get(i);
            try {
                if (resultat2.get() && resultat3.get()) {
                    System.out.println("Número " + i + " és divisible per 2 i per 3");
                    //System.out.println("Número "+i+ " és divisible per 2 :" + resultat2.get() + " i divisible per 3: "+ resultat3.get());
                }
            } catch (InterruptedException | ExecutionException e) {
            }
        }

    }
}
