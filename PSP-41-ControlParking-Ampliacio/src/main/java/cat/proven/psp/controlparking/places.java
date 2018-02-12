/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlparking;

/**
 *
 * @author alume
 */
public class places {
    
    private String matricula;
    private int preu;

    public places(String matricula, int preu) {
        this.matricula = matricula;
        this.preu = preu;
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }
    
}
