/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.ComboBoxRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Model.ConsultarXML;
import Model.Objetos.Actividad;
import Model.Objetos.Materia;
import Model.Objetos.Ejercicio;
import Model.Objetos.EntidadGeneral;
import Model.Objetos.Leccion;
import Model.Objetos.Persona;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import org.jdom2.JDOMException;
/**
 *
 * @author Manuel
 */
public class ControllerConsultar {
   private int materiasCont;
   private final String rutaMateria;
   private List<Materia> materias;
   private List<Leccion> lecciones;
   private List<Ejercicio> ejercicios;
   private List<Actividad> actividades;
   private final EntidadGeneral egMAT=new Materia();
   private final EntidadGeneral egLEC=new Leccion();
   private final EntidadGeneral egEJE=new Ejercicio();
    private Persona persona;
    
   /**
    * Constructor 
    */
    public ControllerConsultar(){
        
        rutaMateria=Util.RUTA_MATERIA_XML;
        
    }
    
    /**
    * Constructor
    * @param rutaArchivo ruta del archivo que contiene el documento con las materias
    */
    public ControllerConsultar(String rutaArchivo){
        
        rutaMateria=rutaArchivo;
        
    }
    /**
     * Método para consultar la cantidad de materias registradas en el sistema y
     * preparar el entorno en base a esto
     */
    private void consultarMaterias(){
        try{
        materias=new ArrayList<>();
        materiasCont=Model.ConsultarXML.ContarEtiquetas(rutaMateria,"");
        for(int i=0;i<materiasCont;i++){
            Materia materia= new Materia();
            materias.add(materia);
        }
        }
        catch(Exception ex){
            
        }
    }
   /**
    * Método para obtener la respuesta realizada por el usuario
    * @param comp componente que contiene la respuesta
    * @return la respuesta realizada por el usuario
    */
    public String ObtenerRespuesta(Component comp){
      try{
       switch(comp.getClass().getSimpleName()){
           case Util.COMPONENTE_TEXTBOX_RECREA: return RespTextField((TextBoxRecrea)comp);
           case Util.COMPONENTE_NUMBERBOX_RECREA:return RespTextField((NumberBoxRecrea)comp);
           case Util.COMPONENTE_VF_RECREA:return RespRadioButton((VFRecrea)comp);
       }}
      catch(Exception ex){
          
          System.out.println("Error en Obtener Respuesta: ");
          System.out.println(ex);
          System.out.println("componente: "+comp);
          System.out.println("StackTrace: "+ex.getStackTrace().toString());
          System.out.println("Causa: "+ex.getCause());
          System.out.println("Thread: "+ex.getSuppressed().toString());
      }
       return "";
   }
       /**
    * Método para obtener el tipo de respuesta
    * @param comp componente que contiene la respuesta
    * @return "Número" si es de número o "Caracter" si es cualquier tipo(String)
    */
    public String ObtenerTipoRespuesta(Component comp){
      try{
       String respuesta=Util.RESPUESTA_TIPO_STRING;
       switch(comp.getClass().getSimpleName()){
           case Util.COMPONENTE_NUMBERBOX_RECREA: respuesta=Util.RESPUESTA_TIPO_NUMERO;
       }
      return respuesta;
      }
      catch(Exception ex){
          
          System.out.println("Error en Obtener Respuesta: ");
          System.out.println(ex);
          System.out.println("componente: "+comp);
          System.out.println("StackTrace: "+ex.getStackTrace().toString());
          System.out.println("Causa: "+ex.getCause());
          System.out.println("Thread: "+ex.getSuppressed().toString());
      }
       return "";
   }
   /**
    * Método que retorna la respuesta seleccionada por el usuario en la
    * seccion de Verdadero o falso
    * @param resp Componente VFRecrea que contiene los radio button de verdad o falso
    * @return respuesta seleccionada por el usuario; retorna vacio si no selecciono algo
    */
    private String RespRadioButton(VFRecrea resp){
       if(resp.rbFalso.isSelected())
           return Util.RESPUESTA_VF_FALSO;
       else
       if(resp.rbVerdad.isSelected())
           return Util.RESPUESTA_VF_VERDADERO;
       else
           return "";
           
       
   }
   /**
    * Método que retorna la respuesta de los TexboxRecrea y NumberBoxRecrea
    * @param textResp componente TBRecrea o NBRecrea
    * @return respuesta realizada por el usuario
    */
    private String RespTextField(JTextField textResp){
    return textResp.getText();
   }
   
    /**
     * Método para cargar las materias asociadas a la aplicación
     * @return listado de materias totales en la aplicación
     */
    public List<Materia> cargarMateria(){
        try{
        int i=0;
        List<Materia> respuesta=new ArrayList<>();
        consultarMaterias();
        for(Materia mt:materias ){
           mt.setNombre(Model.ConsultarXML.InformacionEtiqueta(rutaMateria, "", i,"").trim()); 
           mt.setImagenURL(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.IMAGEN_ATRIBUTE, i,"").trim());
           mt.setHijoURL(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.XML_ATRIBUTE, i,"").trim());
           mt.setNivel(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(rutaMateria,Util.NIVEL_ATRIBUTE, i,"").trim()));
           mt.setAsignaturas(cargarLeccion(mt)); 
           i++;
           respuesta.add(mt);
         }
        materias=respuesta;
        return materias;
        }
        catch(JDOMException ex){
            System.out.println("Error encontrado en ControllerConsultar.CargarMateria: "+ex);
            return null;
        }
        
        catch(Exception ex){
            System.out.println("Error encontrado en ControllerConsultar.CargarMateria: "+ex);
            return null;
        }
     
    }
   /**
    * Método para cargar las lecciones asociadas a una materia en específico
    * @param mt materia que contiene las lecciones a cargar
    * @return listado de lecciónes asociadas a la materia consultada
    * @throws JDOMException 
    */
    private List<Leccion> cargarLeccion(Materia mt) {
        
        int contHijo;
        lecciones=new ArrayList<>();
        try{
        String ruta=Util.ARCHIVOS_XML_PATH+mt.getHijoURL();
        contHijo=Model.ConsultarXML.ContarEtiquetas(ruta,"");
        for(int i=0;i<contHijo;i++ ){
            Leccion leccion=new Leccion();
            leccion.setNombre(Model.ConsultarXML.InformacionEtiqueta(ruta, "", i,"").trim());
            leccion.setImagenURL(Model.ConsultarXML.InformacionEtiqueta(ruta,Util.IMAGEN_ATRIBUTE, i,"").trim());
            leccion.setNivel(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(ruta,Util.NIVEL_ATRIBUTE, i,"").trim()));
            leccion.setEjercicios(cargarEjercicio(leccion,ruta));
            lecciones.add(leccion);
        }
        
        return lecciones;
        }
        catch(Exception ex){
            System.out.println("Error encontrado en ControllerConsultar.cargarLeccion: "+ex);
            return lecciones;
        }
        
    }
    /**
     * Método para cargar los ejercicios asociados a una lección en específico
     * @param lc leccion que se consultará para cargar los ejercicios asociados
     * @param Ruta ruta fisica donde recide el archivo de la lección
     * @return listado con los ejercicios relacionados a la lección consultada
     */
    private List<Ejercicio> cargarEjercicio(Leccion lc,String Ruta){
        ejercicios=new ArrayList<>();
        try{
        int contHijo= Model.ConsultarXML.ContarEtiquetas(Ruta,lc.getNombre());
        
        for(int i=0;i<contHijo;i++ ){
            Ejercicio ejercicio=new Ejercicio();
            ejercicio.setEjercicio(Model.ConsultarXML.InformacionEtiqueta(Ruta, Util.PREGUNTA_ATRIBUTE, i,lc.getNombre()).trim());
            ejercicio.setRespuesta(Model.ConsultarXML.InformacionEtiqueta(Ruta,"", i,lc.getNombre()).trim());
            ejercicio.setTipo(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.TIPO_ATRIBUTE, i,lc.getNombre()).trim());
            ejercicio.setPuntos(Integer.parseInt(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.PUNTOS_ATRIBUTE, i,lc.getNombre()).trim()));
            ejercicio.setNombre(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.FECHA_ATRIBUTE, i,lc.getNombre()).trim());
            ejercicios.add(ejercicio);
        }
        return ejercicios;
        }
        catch(Exception ex){
            System.out.println("Error en carga Ejercicio:"+ex.toString()+
                               " "+ejercicios.size()+" "+ejercicios.get(ejercicios.size()-2).getNombre()
                               +" Leccion "+lc.getNombre()
                               +" Ruta: "+Ruta);
        }
        return ejercicios;
    }
    /**
     * Método para cargar el comboBox con las materias en el sistema
     * @param cbRecrea Componente ComboBoxRecrea al cual se cargará las materias
     * @return Componente ComboBoxRecrea con las matérias cargadas
     */
    public ComboBoxRecrea CargarComboBoxMateria(ComboBoxRecrea cbRecrea){
        try{
            
        materias= cargarMateria();
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
     /**
     * Método para cargar el comboBox con las lecciones de una materia en particular
     * @param cbRecrea Componente ComboBoxRecrea al cual se cargará las lecciones
     * @param mt materia con la cual se filtrará solo las lecciones asociadas a esta
     * @return Componente ComboBoxRecrea con las lecciones cargadas
     */
    public ComboBoxRecrea CargarComboBoxLeccion(ComboBoxRecrea cbRecrea,Materia mt){
        try{
        lecciones= mt.getAsignaturas();
        cbRecrea.RemoveAllRecrea();
        
        egLEC.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egLEC);
        
        for(Leccion lc:lecciones)
            cbRecrea.AddItemRecrea(lc);
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            return null;
        }
    }
      /**
     * Método para cargar el comboBox con las fechas de creacion de los ejercicios 
     * de una leccion en particular
     * @param cbRecrea Componente ComboBoxRecrea al cual se cargará los ejercicios
     * @param lc Leccion con la cual se filtrará solo los ejercicios asociadas a esta
     * @return Componente ComboBoxRecrea con las fechas de los ejercicios correspondientes
     */
    public ComboBoxRecrea CargarComboBoxEjercicio(ComboBoxRecrea cbRecrea,Leccion lc){
        try{
        ejercicios= lc.getEjercicios();
        cbRecrea.RemoveAllRecrea();
        
        egEJE.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egEJE);
        
        for(Ejercicio ejc:ejercicios)
            cbRecrea.AddItemRecrea(ejc);
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            
            System.out.println(e);
            System.out.println("StackTrace: "+e.getStackTrace().toString());
            System.out.println("Causa: "+e.getCause());
            System.out.println("Thread: "+e.getSuppressed().toString());
            return null;
        }
    }
     /**
      * Método para cargar los tipos de ejercicios disponibles en la aplicación
      * donde cada uno cumple una función distinta y brinda al usuario mayor 
      * fácilidad de construir sus lecciones y responder las mismas
      * @param cbRecrea comboBoxRecrea donde se cargar los tipos de ejercicios
      * @return ComboBoxRecrea con los tipos de ejercicios ya cargados
      */
    public ComboBoxRecrea CargarComboBoxTipoEjercicio(ComboBoxRecrea cbRecrea){
        try{
        cbRecrea.RemoveAllRecrea();
        int cantEjer;
        String subRuta;
        String rutaXML=Util.ARCHIVOS_XML_PATH+Util.CONFIGURACION_XML;
        cantEjer=ConsultarXML.ContarEtiquetas(rutaXML,Util.CONFIGURACION_TIPO_EJERCICIO);
        
        egEJE.setNombre(Util.COMBOBOX_SELECCIONAR);//coloca la palabra principal al comboBox
        cbRecrea.AddItemRecrea(egEJE);
        
        for(int Cont=0;Cont<cantEjer;Cont++)
        {
            EntidadGeneral egEJE2=new EntidadGeneral();
            subRuta=Util.CONFIGURACION_TIPO_EJERCICIO;
            egEJE2.setNombre(ConsultarXML.InformacionEtiqueta(rutaXML,"",Cont,subRuta));
            cbRecrea.AddItemRecrea(egEJE2);
        }
        return cbRecrea;
        }
        catch(Exception e)
        {
            System.out.println("Error en cargarComboBoxMateria: "+e);
            
            System.out.println(e);
            System.out.println("StackTrace: "+e.getStackTrace().toString());
            System.out.println("Causa: "+e.getCause());
            System.out.println("Thread: "+e.getSuppressed().toString());
            
            return null;
        }
    }

    
    /**
     * Método para cargar las actividades asociadas a un usuario en particular
     * @return listado con las actividades realizadas por el usuario
     */
    private List<Actividad> CargarActividades(){
        actividades=new ArrayList<>();
        String Ruta=Util.RUTA_PERSONA_XML;
        String etiqueta=Util.PERSONA_ACTIVIDADES_TAG;
        Actividad actividad=new Actividad();
         try{
        int contHijo= Model.ConsultarXML.ContarEtiquetas(Ruta,etiqueta);
        
        for(int i=0;i<contHijo;i++ ){
            actividad=new Actividad();
            actividad.SetDia(Model.ConsultarXML.InformacionEtiqueta(Ruta, Util.DIA_ATRIBUTE, i,etiqueta).trim());
            actividad.SetFecha(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.FECHA_ATRIBUTE, i,etiqueta).trim());
            actividad.SetHora(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.HORA_ATRIBUTE, i,etiqueta).trim());
            actividad.SetNombre(Model.ConsultarXML.InformacionEtiqueta(Ruta,"", i,etiqueta).trim());
            actividad.SetPtosObtenidos(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.NOTA_ATRIBUTE, i,etiqueta).trim());
            actividad.SetPuntosTotales(Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.NOTA_TOTAL_ATRIBUTE, i,etiqueta).trim());
            actividades.add(actividad);
        }
        return actividades;
        }
        catch(Exception ex){
            System.out.println("Error en carga Actividades:"+ex.toString()+
                               " "+actividades.size()+" "+actividades.get(actividades.size()-2).GetNombre()
                               +" Actividad "+ actividad.GetNombre()
                               +" Ruta: "+Ruta);
        }
        return actividades;
    }
   /**
    * Método para cargar el usuario del sistema
    * @return usuario del sistema con toda su información
    */
    public Persona CargarPersona(){
        persona=new Persona();
         String Ruta=Util.RUTA_PERSONA_XML;
         try{
        int contHijo= Model.ConsultarXML.ContarEtiquetas(Ruta,"");
        
        for(int i=0;i<contHijo;i++ ){
            String resp=Model.ConsultarXML.InformacionEtiqueta(Ruta, "", i,"").trim();
            String nombreEtiqueta=Model.ConsultarXML.InformacionEtiqueta(Ruta,Util.ETIQUETA_NOMBRE, i,"").trim();
            switch(nombreEtiqueta){
                case Util.PERSONA_NOMBRE_TAG:persona.setNombre(resp);break;
                case Util.PERSONA_APELLIDO_TAG:persona.setApellido(resp);break;
            }
          }
        persona.setActividades(this.CargarActividades());
        }
        catch(Exception ex){
            System.out.println("Error en carga Persona:"+ex.toString()+
                               " Apellido"+persona.getApellido()
                               +" Nombre "+ persona.getNombre()
                               +" Ruta: "+Ruta);
        }
         
        return persona;
    }
    
    /**
     * Metodo que retorna la fecha actual del sistema
     * @return fecha actual del sistema
     */
    public String fechaActual(){
        DateFormat fechaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");//formato que queremos para guardar en el xml
        Date date=new Date(); //fecha actual
        return fechaActual.format(date);
    }
   /**
     * metodo para saber si hay un usuario creado en el sistema.
     * @return True: hay un usuario en el sistema,False: no hay usuario
     */
    public static boolean consultarUsuario(){
        return ConsultarXML.archivoCreado(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML);
    }
}

