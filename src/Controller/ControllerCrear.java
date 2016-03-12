/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.ConsultarXML;
import Model.CrearXML;
import java.util.Random;
/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerCrear {
    
    /**
     * Método para crear un usuario nuevo
     * @param Nombre Nombre del usuario
     * @param Apellido Apellido del usuario
     */
    public static void CrearUsuario(String Nombre, String Apellido){
        Random rm=new Random();
        String identificador=Integer.toString(rm.nextInt(100));
        CrearXML.XMLPersona(Nombre, Apellido,identificador);
    }
    /**
     * metodo para saber si hay un usuario creado en el sistema.
     * @return True: hay un usuario en el sistema,False: no hay usuario
     */
    public static boolean consultarUsuario(){
        return ConsultarXML.archivoCreado(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML);
    }
   
    
}
