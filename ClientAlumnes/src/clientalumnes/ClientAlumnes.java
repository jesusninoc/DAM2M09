/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientalumnes;

import ws.Nota;

/**
 *
 * @author mercedes
 */
public class ClientAlumnes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nota notaM01= getNota("m01");
        System.out.println("Obtenido --> " + notaM01.getNomAssignatura() + " "+ notaM01.getNota());
    }

    private static Nota getNota(java.lang.String id) {
        ws.WSAlumnes_Service service = new ws.WSAlumnes_Service();
        ws.WSAlumnes port = service.getWSAlumnesPort();
        return port.getNota(id);
    }
    
}
