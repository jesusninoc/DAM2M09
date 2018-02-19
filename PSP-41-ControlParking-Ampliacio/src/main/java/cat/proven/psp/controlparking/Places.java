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
public class Places {
    
    private String matricula;
    private int preu;

    /**
     *
     * @param matricula
     * @param preu
     */
    public Places(String matricula, int preu) {
        this.matricula = matricula;
        this.preu = preu;
    }
    
    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public int getPreu() {
        return preu;
    }

    /**
     *
     * @param preu
     */
    public void setPreu(int preu) {
        this.preu = preu;
    }
    
}
