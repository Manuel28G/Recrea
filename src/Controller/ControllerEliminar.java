/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.EliminarXML;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import Model.Objetos.Persona;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerEliminar {
    private String leccion;
    private String materia;
    private String archivoMateria;
    private String ejercicio;
    
    public ControllerEliminar(){
        
    }
     /**
     * Método para eliminar una materia de recrea
     * @param mt materia que se desea eliminar 
     * @return true si elimino lo desea; false si no lo hizo
     */
    public boolean EliminarMateria(Materia mt){
        materia=mt.getNombre();
        boolean resp;
        try{
        EliminarXML.BorrarMateria(materia);
        resp=true;
        }
        catch(ParserConfigurationException ex) {
         resp=false;
        }
        catch(SAXException ex){
         resp=false;
        }
        catch( IOException  ex){
         resp=false;   
        }
       catch( TransformerException ex){
         resp=false;  
       }
        catch(Exception ex){
          resp=false; 
        }
        return resp;
    }
        /**
     * Método para eliminar una leccion de recrea
     * @param lc leccion donde se encuentra el ejercicio
     * @param mt materia que contiene la leccion a eliminar 
     * @return true si elimino lo desea; false si no lo hizo
     */
    public boolean EliminarLeccion(Leccion lc,Materia mt){
        archivoMateria=mt.getHijoURL();
        leccion=lc.getNombre();
        try{
        EliminarXML.BorrarLeccion(leccion, archivoMateria);
        return true;
        }
        catch(ParserConfigurationException ex) {
            return false;
        }
        catch(SAXException ex){
            return false;
        }
        catch( IOException  ex){
            return false;
        }
       catch( TransformerException ex){
           return false;
       }
        catch(Exception ex){
           return false; 
        }
    }
    /**
     * Método para eliminar un ejercicio de recrea
     * @param ejc ejercicio que se desea eliminar
     * @param lc leccion donde se encuentra el ejercicio
     * @param mt materia que contiene la leccion y el ejercicio anteriormente descritos
     * @return true si elimino lo desea; false si no lo hizo
     */
    public boolean EliminarEjercicio(Ejercicio ejc,Leccion lc,Materia mt){
        archivoMateria=mt.getHijoURL();
        leccion=lc.getNombre();
        ejercicio=ejc.getNombre();
        try{
        EliminarXML.BorrarEjercicio(leccion, ejercicio, archivoMateria);
        return true;}
        catch(ParserConfigurationException ex) {
            return false;
        }
        catch(SAXException ex){
            return false;
        }
        catch( IOException  ex){
            return false;
        }
       catch( TransformerException ex){
           return false;
       }
        catch(Exception ex){
           return false; 
        }
    }
    /**
     * Metodo para eliminar al usuario registrado en recrea
     * @param usr usuario que se desea borrar, para esta version esto es indiferente
     * @return true si elimino lo desea; false si no lo hizo
     */
    public boolean EliminarUsuario(Persona usr){
        try{
        EliminarXML.BorrarPersona();
           return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
