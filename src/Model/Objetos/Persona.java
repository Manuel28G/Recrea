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
 */
public class Persona extends EntidadGeneral {
    
    private String apellido;
    private List<Materia> materiasCursadas;
    
    public Persona(){
        setNombre("");
        setApellido("");
        setMateriasCursadas(null);
        setNivel(0);
    }
    public Persona(String nbre,String aplldo,List<Materia> mtrias,int nvl){
        setNombre(nbre);
        setApellido(aplldo);
        setMateriasCursadas(mtrias);
        setNivel(nvl);
    }
    
    
    public String getApellido(){
        return apellido;
    }
    public List<Materia> getMateriasCursadas(){
        return materiasCursadas;
    }
    public void setApellido(String apll){
        this.apellido=apll;
    }
    public void setMateriasCursadas(List<Materia> mtsCurs ){
        this.materiasCursadas=mtsCurs;
    }
}
