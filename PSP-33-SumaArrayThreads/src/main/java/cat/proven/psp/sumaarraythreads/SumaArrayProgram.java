/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.sumaarraythreads;

/**
 *
 * @author alumne
 */
public class SumaArrayProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int result;
        // Creem l'array
        int ARRAY_SIZE = 100000000;

        int[] arr = new int[ARRAY_SIZE];

        //Inicialització del vector
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // EXERCICI 2  - Calcula suma del vector, sense Threads
        result = sumaNoThreads(arr);
        System.out.println("Resultat sense threads:" + result);

        // EXERCICI 3 - Calcula suma amb 2 threads
        result = suma2Threads(arr);
        System.out.println("Resultat amb 2 threads:" + result);

        // EXERCICI 4 - Calcula suma amb número variable de threads
        // Variables de temps
        long startTime;
        long endTime;

        // Executem amb diferent nombre de fils
        //  ho provem des de 1 fil fins a 24 fils
        for (int i = 1; i < 25; i++) {

            startTime = System.currentTimeMillis();
            // Executo la suma del array amb i fils
            result = sumaNThreads(arr, i);

            endTime = System.currentTimeMillis();

            System.out.println(" Resultat amb " + i + " threads: " + result);
            System.out.println(" Temps: " + (endTime - startTime) + " milisegons");

        }
    }

    private static int sumaNoThreads(int[] arr) {
        // EXERCICI 2  - Calcula suma del vector, sense Threads
        SumaArray sumaArray = new SumaArray(arr, 0, arr.length - 1);
        sumaArray.run();
        return sumaArray.getSuma();

    }

    private static int suma2Threads(int[] arr) {
        // EXERCICI 3 - Calcula suma amb 2 threads
        try {
            SumaThread thread1 = new SumaThread(arr, 0, arr.length / 2 - 1);
            thread1.start();

            SumaThread thread2 = new SumaThread(arr, arr.length / 2, arr.length - 1);
            thread2.start();

            thread1.join();
            thread2.join();

            return (thread1.getSuma() + thread2.getSuma());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    private static int sumaNThreads(int[] arr, int numThreads) {
        int result = 0;
        try {

            // Array on tindrem tots els fils          
            SumaThread[] threads = new SumaThread[numThreads];

            // Calculem el tamany que tindrà cada part de l'array
            int size = arr.length / numThreads;

            // Creem els threads
            for (int i = 0; i < numThreads; i++) {

                // Si es el último sumo hasta el final porque la división puede no ser exacta    
                if (i == numThreads - 1) {
                    threads[i] = new SumaThread(arr, i * size, arr.length - 1);
                } else {
                    threads[i] = new SumaThread(arr, i * size, (i * size) + size - 1);
                }

            }

            // Executem els threads
            for (int i = 0; i < numThreads; i++) {
                threads[i].start();
            }

            // Esperem a que acabin
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }

            // Calculem la suma total amb el resultat de cada fil
            for (int i = 0; i < numThreads; i++) {
                {
                    result += threads[i].getSuma();
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

}
