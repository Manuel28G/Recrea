/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.CrearXML;
import Model.Objetos.Persona;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerCrear {
    
    /**
     * Método para crear un usuario nuevo
     * @param Nombre Nombre del usuario
     * @param Apellido Apellido del usuario
     * @return usuario creado
     */
    public static Persona CrearUsuario(String Nombre, String Apellido) {
        Persona usuario=new Persona();
        try{
        Random rm=new Random();
        String identificador=Integer.toString(rm.nextInt(100));
        CrearXML.XMLPersona(Nombre, Apellido,identificador);
        usuario.setNombre(Nombre);
        usuario.setApellido(Apellido);
        usuario.setDescripcion(identificador);

       }
       catch(Exception ex){
           
       }
       return usuario;
    }
   
    /**
     * Método para validar si la ruta del archivo Matéria existe ya que es escencial 
     * su existencia para el correcto funcionamiento de la aplicación
     * si no existe se creará la ruta y el archivo.
     * @return true si creo el archivo, false si hubo algun problema
     */
    public static boolean archivoMateria(){
        try{
        File file=new File(Util.RUTA_MATERIA_XML);
        if(!file.exists())
            CrearXML.XMLBasic(Util.MATERIAS_TAG);
        
        return true;
        }
        catch(ParserConfigurationException | SAXException | IOException | TransformerException ex){
            System.out.println("Error encontrado en ControllerConsultar.ExisteArchivoMateria: "+ex);
            return false;
        }
    }
    
}
