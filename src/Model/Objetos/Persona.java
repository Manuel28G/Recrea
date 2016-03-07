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
public final class Persona extends EntidadGeneral {
    
    private String apellido;
    private List<Actividad> actividadesRealizadas;
    
    public Persona(){
        setNombre("");
        setApellido("");
        setNivel(0);
        setActividades(new ArrayList<Actividad>());
    }
    public Persona(String nbre,String aplldo,int nvl){
        setNombre(nbre);
        setApellido(aplldo);
        setNivel(nvl);
        setActividades(new ArrayList<Actividad>());
    }
    
    
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apll){
        this.apellido=apll;
    }
    public void setActividades(List<Actividad> resp){
        actividadesRealizadas=resp;
    }
    public List<Actividad> getActividades(){
        return actividadesRealizadas;
    }
    public void addActividad(Actividad resp){
        actividadesRealizadas.add(resp);
    }
    
    public void resetActividades(){
        actividadesRealizadas=new ArrayList<Actividad>();
    }
}
