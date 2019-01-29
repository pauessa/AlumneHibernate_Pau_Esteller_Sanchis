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
public class Aula implements Serializable{
    private String codiAula;
    private String nombre;

    public Aula() {
    }

    public Aula(String codiAula, String nombre) {
        this.codiAula = codiAula;
        this.nombre = nombre;
    }

    public String getCodiAula() {
        return codiAula;
    }

    public void setCodiAula(String codiAula) {
        this.codiAula = codiAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
