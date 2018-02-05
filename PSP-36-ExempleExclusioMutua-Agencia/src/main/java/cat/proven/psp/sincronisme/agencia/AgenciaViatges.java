package cat.proven.psp.sincronisme.agencia;

/**
 *
 * @author carlos
 */
public class AgenciaViatges implements Runnable {
 
private SeientsAvio sa = new SeientsAvio();
 
public void run(){
    gestioSeientsAvio(3);
    if(sa.getSeientsLliures()<=0)
    System.out.println("No hi ha seients lliures");
}
 
public synchronized void gestioSeientsAvio(int numSeientsReserva){
 
    System.out.println(Thread.currentThread().getName() + " té la clau del cadenat");
    
    //Comprovem si hi ha seients suficients
    if(sa.getSeientsLliures()>=numSeientsReserva)
    {
        System.out.println(Thread.currentThread().getName()+" farà una reserva de "+ numSeientsReserva +" places");
        try {
        Thread.sleep(1000); //adormim el fil 1 segon
        }
        catch (InterruptedException ex) {
        ex.printStackTrace();
        }
       //Fem la reserva dels seients
        sa.reservaSeients(numSeientsReserva);
 
        System.out.println(Thread.currentThread().getName() + " Reserva realitzada amb èxit."+" Les places lliures són "+sa.getSeientsLliures());
    }else{
        System.out.println("No hi ha places suficients pel client." + Thread.currentThread().getName()+" Les places lliures són "+sa.getSeientsLliures());
        try {
        Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
        ex.printStackTrace();
        }
    }
 
    System.out.println(Thread.currentThread().getName() + " deixa la clau del cadenat.");
 
  }

}

 
