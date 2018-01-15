package cat.proven.hilos;

/**
 *
 * @author mercedes
 */
public class Hilo2 implements Runnable {
    private Thread miHilo = null;

    public Hilo2(String name) {
        miHilo = new Thread(this, name);
        miHilo.start();
    }
    
    

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "" + miHilo.getName());
            try {
                miHilo.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
            }            
        }
        System.out.println("FIN! " + miHilo.getName());
    }
}
