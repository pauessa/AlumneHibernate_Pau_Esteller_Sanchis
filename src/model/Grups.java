/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Pauessa
 */
public class Grups implements Serializable{
    private String codi;
    private Nivell nivell;
    private Alumnes delegat;
    private Set<Alumnes> alumnes;

    public Grups(String codi, Nivell nivell, Alumnes delegat, Set<Alumnes> alumnes) {
        this.codi = codi;
        this.nivell = nivell;
        this.delegat = delegat;
        this.alumnes = alumnes;
    }

    

    public Grups() {
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Nivell getNivell() {
        return nivell;
    }

    public void setNivell(Nivell nivell) {
        this.nivell = nivell;
    }

    public Set<Alumnes> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(Set<Alumnes> alumnes) {
        this.alumnes = alumnes;
    }

    @Override
    public String toString() {
        return "Grups{" + "codi=" + codi + ", nivell=" + nivell + ", delegat=" + delegat + '}';
    }
    
    
}