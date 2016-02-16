/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Objetos.Materia;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.JDOMException;
/**
 *
 * @author Manuel
 */
public class CargarInformacion {
   private int materiasCont;
   private String rutaMateria;
   private List<Materia> materias;
   private List<Leccion> lecciones;
   private List<Ejercicio> ejercicios;
   
    public CargarInformacion(String rutaArchivo){
        
        materias=new ArrayList<Materia>();
        materiasCont=Model.ConsultarXML.ContarEtiquetas(rutaArchivo,"");
        rutaMateria=rutaArchivo;
        for(int i=0;i<materiasCont;i++){
            Materia materia= new Materia();
            materias.add(materia);
        }
        
    }
    
    public List<Materia> cargarMateria() throws JDOMException{
        int i=0;
        List<Materia> respuesta=new ArrayList<Materia>();
        for(Materia mt:materias ){
           mt.setNombre(Model.ConsultarXML.InformacionEtiqueta(rutaMateria, null, i,null).trim()); 
           mt.setImagenURL(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.IMAGEN_ATRIBUTE, i,null).trim());
           mt.setHijoURL(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.XML_ATRIBUTE, i,null).trim());
           mt.setNivel(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.NIVEL_ATRIBUTE, i,null).trim()));
           mt.setAsignaturas(cargarLeccion(mt)); 
           i++;
           respuesta.add(mt);
         }
        materias=respuesta;
        return materias;
     
    }
    
    private List<Leccion> cargarLeccion(Materia mt) throws JDOMException{
        
        int contHijo;
        String ruta=Util.ARCHIVOS_XML_PATH+mt.getHijoURL();
        contHijo=Model.ConsultarXML.ContarEtiquetas(ruta,"");
        lecciones=new ArrayList<Leccion>();
        for(int i=0;i<contHijo;i++ ){
            Leccion leccion=new Leccion();
            leccion.setNombre(Model.ConsultarXML.InformacionEtiqueta(ruta, null, i,null).trim());
            leccion.setImagenURL(Model.ConsultarXML.InformacionEtiqueta(ruta,Util.IMAGEN_ATRIBUTE, i,null).trim());
            leccion.setNivel(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(ruta,Util.NIVEL_ATRIBUTE, i,null).trim()));
            leccion.setEjercicios(cargarEjercicio(leccion,ruta));
            lecciones.add(leccion);
        }
        return lecciones;
    }
      
    private List<Ejercicio> cargarEjercicio(Leccion lc,String Ruta){
        ejercicios=new ArrayList<Ejercicio>();
        try{
        int contHijo= Model.ConsultarXML.ContarEtiquetas(Ruta,lc.getNombre());
        
        for(int i=0;i<contHijo;i++ ){
            Ejercicio ejercicio=new Ejercicio();
            ejercicio.setEjercicio(Model.ConsultarXML.InformacionEtiqueta(Ruta, Util.PREGUNTA_ATRIBUTE, i,lc.getNombre()).trim());
            ejercicio.setRespuesta(Model.ConsultarXML.InformacionEtiqueta(Ruta,null, i,lc.getNombre()).trim());
            ejercicio.setTipo(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.TIPO_ATRIBUTE, i,lc.getNombre()).trim());
            ejercicios.add(ejercicio);
        }
        return ejercicios;
        }
        catch(Exception ex){
            System.out.println("Error en carga Ejercicio:"+ex.toString());
        }
        return ejercicios;
    }
/*    
    public List<Repaso> cargarRepaso(Materia mt){
        List<Repaso> repasos=new ArrayList<Repaso>();
        int contHijo=Model.ConsultarXML.ContarEtiquetas(Util.ARCHIVOS_XML_PATH + mt.getHijoURL());

        String ruta;
         for(int i=0;i<contHijo;i++ ){
             
            
            Leccion leccion=new Leccion();
            ruta=Util.ARCHIVOS_XML_PATH+mt.getHijoURL();
            leccion.setNombre(Model.ConsultarXML.InformacionEtiqueta(ruta, null, rm));
            leccion.setImagenURL(Model.ConsultarXML.InformacionEtiqueta(ruta,Util.IMAGEN_TAG, rm));
            leccion.setNivel(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.NIVEL_TAG, i)));
            lecciones.add(leccion);
        }
        
        return repasos;
    }
    
    
   public Repaso randomRepaso(Leccion lc){
       Repaso rs=new Repaso();
       int minimo=0;
       int maximo=Model.ConsultarXML.ContarEtiquetas(Util.ARCHIVOS_XML_PATH + .getHijoURL());
       int rm= minimo + (int)(Math.random()*maximo); 
       
       return rs;
       
   }*/

}
