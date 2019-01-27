/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Pauessa
 */
public class Telefon implements Serializable{
    private int telefon;

    public Telefon() {
    }

    public Telefon(int telefon) {
        this.telefon = telefon;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
    
}
