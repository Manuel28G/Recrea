/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Repaso {
    
    private String imagenURL;
    private List<Ejercicio> ejercicios;
    private String descripcion;
    
//Constructor
    public void Repaso(){
        setImagenURL("");
        setEjercicios(new ArrayList<Ejercicio>());
        setDescripcion("");        

    }
    public void Repaso(String img,List<Ejercicio> ejr,String dsc){
        setImagenURL(img);
        setEjercicios(ejr);
        setDescripcion(dsc);
    }
    
//Get's    
    public String getImagenURL() {
        return imagenURL;
    }
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    public String getDescripcion() {
        return descripcion;
    }
    //Set's
    
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
