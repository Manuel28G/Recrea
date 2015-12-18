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
 * @version 1.0
 */
public class Leccion {
    
    private String nombre;
    private String imagenURL;
    private int nivel;
    private List<Ejercicio> ejercicios;
    private String descripcion;
    
    public void Leccion(){
       setNombre("");
       setImagenURL("");
       setNivel(0);
       setEjercicios(new ArrayList<Ejercicio>());
       setDescripcion("");
        
    }
    public void Leccion(String nbr,String img,int nvl,List<Ejercicio> ejr,String desc){
       setNombre(nbr);
       setImagenURL(img);
       setNivel(nvl);
       setEjercicios(ejr);
       setDescripcion(desc);
    }

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
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
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
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
