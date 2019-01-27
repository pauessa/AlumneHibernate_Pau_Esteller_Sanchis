/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Pauessa
 */
public class Alumnes implements Serializable{
    
    private int nexp;
    private String nom;
    private Telefon telefon;
    private Sexe sexe;
    private Date datanaix;
    private int susp;
    private Grups grup;
    private Set<Grups> grupos;

    public Alumnes(String nom, Telefon telefon, Sexe sexe, Date datanaix, int susp, Grups grup) {
        this.nom = nom;
        this.telefon = telefon;
        this.sexe = sexe;
        this.datanaix = datanaix;
        this.susp = susp;
        this.grup = grup;
    }

    



    public Alumnes() {
    }

    public int getNexp() {
        return nexp;
    }

    public void setNexp(int nexp) {
        this.nexp = nexp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

   

    public Date getDatanaix() {
        return datanaix;
    }

    public void setDatanaix(Date datanaix) {
        this.datanaix = datanaix;
    }

    public int getSusp() {
        return susp;
    }

    public void setSusp(int susp) {
        this.susp = susp;
    }

    public Grups getGrup() {
        return grup;
    }

    public void setGrup(Grups grup) {
        this.grup = grup;
    }

    public Set<Grups> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grups> grupos) {
        this.grupos = grupos;
    }



    @Override
    public String toString() {
        return "Alumnes{" + "nexp=" + nexp + ", nom=" + nom + ", telefon=" + telefon + ", sexe=" + sexe + ", datanaix=" + datanaix + ", susp=" + susp + ", grup=" + grup +'}';
    }
    
    
    
}
