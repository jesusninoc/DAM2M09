package cat.proven.examenbustia;

/**
 *
 * @author alumne
 */
public class EscriptorCarta extends Thread{
    private Bustia bustia;
    private String nom;


    public EscriptorCarta(String nom, Bustia b) {
    this.nom = nom;
    this.bustia = b;
    start();
    }
 
    @Override
    public void run() {
        while (true) {
           
            try {
            sleep((int)(Math.random() * 10000)); // Triga una estona a escriure la carta
            } catch (InterruptedException e) {}

            bustia.deixaCarta(nom);
           
       }
    }
}
