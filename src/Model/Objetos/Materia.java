/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 * @version 1.0
 */
public class Materia {
        
    private String nombre;
   // public Image imagen; 
    private String imagenURL;
    private int nivel;
    private String descripcion;
    private List<Leccion> asignaturas;
    private List<Repaso> repaso;
    
//Constructores
    
    public void Materia(){
     
        setNombre("");
        setImagenURL("");
        setNivel(0);
        setDescripcion("");
        setAsignaturas(new ArrayList<Leccion>());
        setRepaso(new ArrayList<Repaso>());
        
    }
    public void Materia(String nbr,String img,int nvl,List<Leccion> asg,List<Repaso> rps,String dsc){
        setNombre(nbr);
        setImagenURL(img);
        setNivel(nvl);
        setAsignaturas(asg);
        setRepaso(rps);
        setDescripcion(dsc);
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
    public String getDescripcion() {
        return descripcion;
    }
    public List<Leccion> getAsignaturas() {
        return asignaturas;
    }
    public List<Repaso> getRepaso() {
      return repaso;
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
    public void setAsignaturas(List<Leccion> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public void setRepaso(List<Repaso> repaso) {
        this.repaso = repaso;
    }
    
    

    
}
