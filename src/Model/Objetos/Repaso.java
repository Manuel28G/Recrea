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
public class Repaso extends EntidadGeneral{
    
    private List<Ejercicio> ejercicios;
    
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
 
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    //Set's
    

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

}
