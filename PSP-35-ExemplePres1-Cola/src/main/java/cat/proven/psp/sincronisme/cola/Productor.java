package cat.proven.psp.sincronisme.cola;

/**
 *
 * @author alumne
 */
public class Productor extends Thread {

    private Cola _buffer;

    public Productor(Cola c) {
        _buffer = c;
    }

    @Override
    public void run() {
        int valor = 0;
        while (true) {
            _buffer.almacenar(valor);
            System.out.println("Productor " + valor);
            valor++;
        }
    }
}
