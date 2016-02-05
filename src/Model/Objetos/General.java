/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;

import java.util.List;

/**
 *
 * @author Manuel
 * @version 1.0
 */
public class General {
    private String nombre;
    private String imagenURL;
    private int nivel;
    private String descripcion;
    
    //Get's 
    public String getNombre() {
        return nombre;
    }
    public String getImagenURL() {
        return imagenURL;
    } 
     public int getNivel() {
        return nivel;
    }
    public String getDescripcion() {
        return descripcion;
    }
 

//Set's
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
