/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.psp.controlbanc;

/**
 *
 * @author alumne
 */
public class compteBancari {
    
    private double Saldo;
    
    public compteBancari()
    {
        this.Saldo = 0;
    }
    
    public void setSaldo(double quantitat)
    {
    this.Saldo = quantitat;
    }
    
    public double getSaldo()
    {
    return this.Saldo;
    }
            
}
