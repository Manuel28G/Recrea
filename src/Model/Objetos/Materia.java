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
public class Materia extends General {
        
    private String hijoURL;//La ruta al archivo de la leccion correspondiente a la materia
    private List<Leccion> asignaturas;
    private List<Repaso> repaso;
    
//Constructores
    
    public void Materia(){
     
        setNombre("");
        setImagenURL("");
        setHijoURL("");
        setNivel(0);
        setDescripcion("");
        setAsignaturas(new ArrayList<Leccion>());
        setRepaso(new ArrayList<Repaso>());
        
    }
    public void Materia(String nbr,String img,String hijo,int nvl,List<Leccion> asg,List<Repaso> rps,String dsc){
        setNombre(nbr);
        setImagenURL(img);
        setHijoURL(hijo);
        setNivel(nvl);
        setAsignaturas(asg);
        setRepaso(rps);
        setDescripcion(dsc);
        
    }
    
//Get's 
   public String getHijoURL() {
        return hijoURL;
    }
    public List<Leccion> getAsignaturas() {
        return asignaturas;
    }
    public List<Repaso> getRepaso() {
      return repaso;
    }
//Set's
    public void setHijoURL(String hijURL) {
        this.hijoURL = hijURL;
    }
    public void setAsignaturas(List<Leccion> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public void setRepaso(List<Repaso> repaso) {
        this.repaso = repaso;
    }

    
    

    
}
