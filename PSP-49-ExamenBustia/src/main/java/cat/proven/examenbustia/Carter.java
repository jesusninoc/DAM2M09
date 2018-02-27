package cat.proven.examenbustia;

/**
 *
 * @author alumne
 */
public class Carter extends Thread{
    private Bustia bustia;
    private String nom;

    public Carter(String nom, Bustia b) {
    this.nom = nom;
    this.bustia = b;
    start();
    }
 
    @Override
    public void run() {
        while (true) {
           
            try {
            sleep((int)(Math.random() * 20000)); // Repartir les cartes abans de recollir mes
            } catch (InterruptedException e) {}

            bustia.recullCartes(nom);
           
       }
    }
}
