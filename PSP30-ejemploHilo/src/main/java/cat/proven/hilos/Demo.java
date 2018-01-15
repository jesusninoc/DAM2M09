package cat.proven.hilos;

/**
 *
 * @author mercedes
 */
public class Demo {
    public static void main(String[] args) {
        Hilo uno, dos;
        
        uno = new Hilo("Jamaica");
        dos = new Hilo("Fiji");
        
        //uno.start();
        //dos.start();

        uno.run();
        dos.run();
        
        System.out.println("main no hace nada");
    }
}
