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
public class Leccion extends EntidadGeneral{
    
    private List<Ejercicio> ejercicios;
    
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
   
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
  
//Set's
   
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
  

}
