package cat.proven.psp.sincronisme.cola;

/**
 *
 * @author alumne
 */
public class Consumidor extends Thread {
    private Cola _buffer;

    public Consumidor(String name, Cola c) {
        super(name);
        _buffer = c;
    }

    @Override
    public void run() {
        int dato;
        int i = 0;
        while (i < 3) {
            dato = _buffer.extraer();
            System.out.println("Consumidor" + getName() + " " + dato);
            i++;
        }
    }
}
