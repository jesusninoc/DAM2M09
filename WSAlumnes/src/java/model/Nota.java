/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mercedes
 */
@XmlRootElement
public class Nota {
    String idAssignatura;
    String nomAssignatura;
    int nota;

    public Nota() {
    }

    public Nota(String idAssignatura, String nomAssignatura, int nota) {
        this.idAssignatura = idAssignatura;
        this.nomAssignatura = nomAssignatura;
        this.nota = nota;
    }

    public String getIdAssignatura() {
        return idAssignatura;
    }

    @XmlElement
    public void setIdAssignatura(String idAssignatura) {
        this.idAssignatura = idAssignatura;
    }

    public String getNomAssignatura() {
        return nomAssignatura;
    }

    @XmlElement
    public void setNomAssignatura(String nomAssignatura) {
        this.nomAssignatura = nomAssignatura;
    }

    public int getNota() {
        return nota;
    }

    @XmlElement
    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}

