/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerAgregar {
    
    
    public void AgregarMateria(String img,String nivl,String materia){
        String xml= materia.replace(" ", "");
        int maxLong=xml.length();
        if(maxLong>14)
            maxLong=15;
        xml=xml.substring(0,maxLong);
        Model.AgregarXML.XMLMateriasAdd(img,nivl, xml, materia);
    }
    
    public void AgregarLeccion(String nivel,String imagen,String leccion,String xmlFile){
        ControllerConsultar cc= new ControllerConsultar();
        Model.AgregarXML.XMLLeccionAdd(nivel,imagen,leccion,xmlFile);
    }
    
    
    public void AgregarEjercicio(String tipo,String puntos,String pregunta,String Respuesta,String xmlFile,String Leccion){
       Model.AgregarXML.XMLEjercicioAdd(tipo,puntos,pregunta,Respuesta,xmlFile,Leccion);
    }
    
    
}
