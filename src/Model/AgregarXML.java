/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import static Model.CrearXML.XMLBasic;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Manuel
 * @version %I%, %G%
 * @since 1.0.0
 */
public class AgregarXML {
    
    
    
    
    /***
 * Metodo para agregar las actividades realizadas por el usuario
 * @param fecha fecha en que fue realizada la actividad
 * @param hora hora en que fue realizada la actividad
 * @param dia  dia de la semana en que se realizo la prueba ejemplo "Miercoles"
 * @param calf calificacion optenida en la actividad
 * @param Curso tema o curso que se realizo 
 * @since 1.0.0
 */
public static void XMLPersonaActAdd(String fecha,String hora,String dia,String calf,String Curso){
    try{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML));  
    Element root=document.getDocumentElement();
    Element actAdd=document.createElement(Util.PERSONA_ACTIVIDAD_CHILD);
    actAdd.setTextContent(Curso);
    actAdd.setAttribute(Util.FECHA_ATRIBUTE, fecha);
    actAdd.setAttribute(Util.HORA_ATRIBUTE, hora);
    actAdd.setAttribute(Util.NOTA_ATRIBUTE, calf);
    actAdd.setAttribute(Util.DIA_ATRIBUTE, dia);
    NodeList lsNode=root.getElementsByTagName(Util.PERSONA_ACTIVIDADES_TAG);//(Element)root.getElementsByTagName(Util.PERSONA_ACTIVIDAD_TAG);
    Element pr=(Element)lsNode.item(0);
    
    pr.appendChild(actAdd);
    document.normalize();  
    CrearXML.CrearXML(document,Util.PERSONA_XML+Util.ARCHIVO_XML);
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage()+" "+e);
    }
    
}


/***
 * Metodo para agregar una materia al contenido de RECREA
 * @param img nombre de la imagen que se encuentra entre los archivos de recrea: puede usar "default.jpg" si no conoce
 * @param nivl nivel de dificultad de la materia (se puede colocar por grado del colegio)
 * @param xml Nombre con que se guardará el archivo XML
 * @param materia  nombre de la materia a agregar
 * @since 1.0.0
 */
public static void XMLMateriasAdd(String img,String nivl,String xml,String materia){
   try{
    String archivo=Util.MATERIAS_TAG+Util.ARCHIVO_XML;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+archivo));  
    Element root=document.getDocumentElement();
    Element actAdd=document.createElement(Util.MATERIA_CHILD);
    actAdd.setTextContent(materia);
    actAdd.setAttribute(Util.IMAGEN_ATRIBUTE, img);
    actAdd.setAttribute(Util.NIVEL_ATRIBUTE, nivl);
    actAdd.setAttribute(Util.XML_ATRIBUTE, xml+Util.ARCHIVO_XML);
    root.appendChild(actAdd);
    document.normalize();  
    CrearXML.CrearXML(document,archivo);
    XMLBasic(xml);
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage()+" "+e);

    }
    
}

/**
 * Metodo para agregar una lección a una materia
 * @param nivel nivel de dificultad de la materia (se puede colocar por grado del colegio)
 * @param imagen nombre de la imagen que se encuentra entre los archivos de recrea: puede usar "default.jpg" si no conoce
 * @param leccion Nombre de la leccion que se agregará
 * @param archivoXML Archivo XML de la la materia que se le agregara la lecció ejemplo "Numeros.xml"
 * @since 1.0.0
 */
public static void XMLLeccionAdd(String nivel,String imagen,String leccion,String archivoXML){
     try{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+archivoXML));  
    Element root=document.getDocumentElement();
    Element actAdd=document.createElement(Util.LECCION_TAG);
    actAdd.setTextContent(leccion);
    actAdd.setAttribute(Util.IMAGEN_ATRIBUTE, imagen);
    actAdd.setAttribute(Util.NIVEL_ATRIBUTE, nivel);
    root.appendChild(actAdd);
    document.normalize();  
    CrearXML.CrearXML(document,archivoXML);
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage()+" "+e);
    }
}

/**
 *  Metodo asignar ejercicio a lección
 * @param tipo Tipo de ejercicio (Numero,Letra,VF,TextBox,NumberBox)
 * @param pregunta pregunta o información que saldrá en pantalla 
 * @param pts puntos asignados al ejercicio como clasificación a la dificultad
 * @param resp respuesta correcta del ejercicio
 * @param xmlFile Archivo XML donde se encuentra la materia y la leccion que se le agregará el ejercicio
 * @param nombreLeccion nombre de la leccion que se le agregará el ejercicio
 * @since 1.0.0
 * @author Manuel Goncalves L.
 */
public static void XMLEjercicioAdd(String tipo,String pts,String pregunta,String resp,String xmlFile,String nombreLeccion){
      try{
    DateFormat fechaActual = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");//formato que queremos para guardar en el xml
    Date date=new Date(); //fecha actual
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    String archivoRuta=Util.ARCHIVOS_XML_PATH+xmlFile;
    System.out.println(archivoRuta);
    Document document = db.parse(new File(archivoRuta));  
    Element root=document.getDocumentElement();
    Element actAdd=document.createElement(Util.EJERCICIO_TAG);
    actAdd.setTextContent(resp);
    actAdd.setAttribute(Util.TIPO_ATRIBUTE, tipo);
    actAdd.setAttribute(Util.PUNTOS_ATRIBUTE, pts);
    actAdd.setAttribute(Util.PREGUNTA_ATRIBUTE, pregunta);
    actAdd.setAttribute(Util.FECHA_ATRIBUTE,fechaActual.format(date));
    NodeList lsNode=root.getElementsByTagName(Util.LECCION_TAG);//(Element)root.getElementsByTagName(Util.PERSONA_ACTIVIDAD_TAG);
   for(int i=0;i<lsNode.getLength();i++){
       Node elemtn=lsNode.item(i).getFirstChild();
       System.out.println("prim:"+elemtn.getTextContent());
       System.out.println("seg:"+nombreLeccion);
       if(nombreLeccion.equals(elemtn.getTextContent().trim())){
           lsNode.item(i).appendChild(actAdd);
           break;
       }
   }
    
    document.normalize();  
    CrearXML.CrearXML(document,xmlFile);
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage()+" "+e);
     
    }
    
    
}
}
