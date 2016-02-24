/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.ComboBoxRecrea;
import Model.ConsultarXML;
import Model.Objetos.Materia;
import Model.Objetos.Ejercicio;
import Model.Objetos.EntidadGeneral;
import Model.Objetos.Leccion;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.JDOMException;
/**
 *
 * @author Manuel
 */
public class ControllerConsultar {
   private int materiasCont;
   private String rutaMateria;
   private List<Materia> materias;
   private List<Leccion> lecciones;
   private List<Ejercicio> ejercicios;
   private final EntidadGeneral egMAT=new EntidadGeneral();
   private final EntidadGeneral egLEC=new EntidadGeneral();
   private final EntidadGeneral egEJE=new EntidadGeneral();
   
    public ControllerConsultar(){
        
        materias=new ArrayList<Materia>();
        rutaMateria=Util.RUTA_MATERIA_XML;
        materiasCont=Model.ConsultarXML.ContarEtiquetas(rutaMateria,"");
        for(int i=0;i<materiasCont;i++){
            Materia materia= new Materia();
            materias.add(materia);
        }
        
    }
   
    public ControllerConsultar(String rutaArchivo){
        
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
    
    public ComboBoxRecrea CargarComboBoxMateria(ComboBoxRecrea cbRecrea){
        try{
            
        List<Materia> materias= cargarMateria();
        cbRecrea.RemoveAllRecrea();
        
        egMAT.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egMAT);
        cbRecrea.setSelectedIndex(0);
        for(Materia mt:materias)
            cbRecrea.AddItemRecrea(mt);
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            return null;
        }
    }

    public ComboBoxRecrea CargarComboBoxLeccion(ComboBoxRecrea cbRecrea,Materia mt){
        try{
        List<Leccion> Leccion= mt.getAsignaturas();
        cbRecrea.RemoveAllRecrea();
        
        egLEC.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egLEC);
        
        for(Leccion lc:Leccion)
            cbRecrea.AddItemRecrea(lc);
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            return null;
        }
    }
     
    public ComboBoxRecrea CargarComboBoxTipoEjercicio(ComboBoxRecrea cbRecrea){
        try{
        cbRecrea.RemoveAllRecrea();
        int cantEjer;
        String subRuta="";
        String rutaXML=Util.ARCHIVOS_XML_PATH+Util.CONFIGURACION_XML;
        cantEjer=ConsultarXML.ContarEtiquetas(rutaXML,Util.CONFIGURACION_TIPO_EJERCICIO);
        
        egEJE.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egEJE);
        
        for(int Cont=0;Cont<cantEjer;Cont++)
        {
            EntidadGeneral egEJE2=new EntidadGeneral();
            subRuta=Util.CONFIGURACION_TIPO_EJERCICIO;
            egEJE2.setNombre(ConsultarXML.InformacionEtiqueta(rutaXML,null,Cont,subRuta));
            cbRecrea.AddItemRecrea(egEJE2);
        }
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            return null;
        }
    }

    public String EtiquetaXMLMateria(String Materia){
        String doc=Util.RUTA_MATERIA_XML;
        String etiqueta=Util.XML_ATRIBUTE;
        return Model.ConsultarXML.InformacionEtiquetaRec(doc, etiqueta, Materia);
    }

}

