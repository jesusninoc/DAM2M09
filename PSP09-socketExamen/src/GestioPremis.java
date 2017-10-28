
/**
 * Gestiona una llista de premis
 * Permet afegir premis en posicions concretes de la llista
 * I s'obtenen els premis si la posicio conte premi
 * Hi ha un màxim de 4 premis
 * 
 * 
 * @author alumne
 */
public class GestioPremis {

    private Boolean[] llistaPremis;

    /**
     * número màxim de premis
     */
    public static final int MAX_PREMIS = 4;

    /**
     * constructor
     *
     */
    public GestioPremis() {
        this.llistaPremis = new Boolean[10];
        for (int i = 0; i < 10; i++) {
            this.llistaPremis[i] = false;
        }
    }

    /**
     * Calcula el total de premis
     *
     * @return la quantitat de premis
     */
    public int countPremis() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (this.llistaPremis[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Afegeix un premi a la posició indicada
     *
     * @param pos posició per afegir el premi
     * @return true si s'ha afegit, 
     *         false si la posicio es incorrecta o si ja tenim el maxim de 
     * premis o si ja tenim premi en aquesta posicio
     */
    public Boolean afegirPremi(int pos) {
        //ja hi ha el màxim
        if (GestioPremis.MAX_PREMIS == this.countPremis()) {
            return false;
        }
        //posicio incorrecta
        if (pos < 0 || pos > 9) {
            return false;
        }
        //ja hi ha premi a la posicio
        if (this.llistaPremis[pos]) {
            return false;
        }

        this.llistaPremis[pos] = true;
        return true;
    }

    /**
     * Extreu el premi de la posició indicada, si hi ha
     *
     * @param pos posició per obtenir el premi
     * @return true si hi ha premi false si no hi ha premi
     */
    public Boolean obtenirPremi(int pos) {
        if (pos < 0 || pos > 9) {
            return false;
        }

        if (this.llistaPremis[pos] == true) {
            //si hi ha premi, el donem
            this.llistaPremis[pos] = false;
            return true;
        }
        return false;
    }

}
