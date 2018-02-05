package cat.proven.psp.sincronisme.agencia;

/**
 *
 * @author carlos
 */
public class Agencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AgenciaViatges objAg = new AgenciaViatges();
 
        //creem els dos fils sobre la mateixa instància
        Thread Fil_1 = new Thread(objAg);
        Thread Fil_2 = new Thread(objAg);
        Fil_1.setName("Client 1");
        Fil_2.setName("Client 2");

        Fil_1.start();
        Fil_2.start();
    }
    
}
