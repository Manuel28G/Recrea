/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Manuel Goncalves L.
 */
public class EliminarXML {
    
    
    /**
     * Metodo para borrar el usuario asignado en Recrea
     */
    public static void BorrarPersona(){
        BorrarArchivo(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML);
    }
    /**
     * Método para borrar un ejercicio específico en recrea
     * @param leccion leccion donde se encuentra el ejercicio a eliminar
     * @param ejercicioFecha fecha única que identifica el ejercicio a eliminar
     * @param xmlFile  archivo donde se encuentra el ejercicio a eliminar
     */
    public static void BorrarEjercicio(String leccion,String ejercicioFecha,String xmlFile){
         try{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+xmlFile));  
    Element root=document.getDocumentElement();
    NodeList lsNode=root.getElementsByTagName(Util.LECCION_TAG);
    NodeList subNode;
    Node elemtn;
    Node sNode;
    
    for(int i=0;i<lsNode.getLength();i++){
       
       elemtn=lsNode.item(i).getFirstChild();
       if(leccion.equals(elemtn.getTextContent().trim())){
           subNode=lsNode.item(i).getChildNodes();
           for(int cont=1;i<subNode.getLength();cont+=2)
           {
               sNode=subNode.item(cont);
               if(ejercicioFecha.equals(sNode.getAttributes().getNamedItem(Util.FECHA_ATRIBUTE).getTextContent())){
                   lsNode.item(i).removeChild(sNode);
                   break;}
           }
           break;
       }
   }
    
    document.normalize();  
    CrearXML.CrearXML(document,xmlFile);
    }
    catch(Exception e)
    {
        /*
               System.out.println(sNode.getTextContent());
               System.out.println(sNode.getNodeName());
               System.out.println(sNode.getFirstChild());
               System.out.println(sNode.getNodeValue());
               System.out.println(sNode.getAttributes().getNamedItem(Util.FECHA_ATRIBUTE).getTextContent());
               System.out.println(sNode.getAttributes().getNamedItem(Util.FECHA_ATRIBUTE).getTextContent());*/
        System.out.println(e.getMessage()+" "+e);
     
    }
    }
    /**
     * Metodo para eliminar una lección entera  Advertencia:si elimina una 
     * lección se eliminaran todos sus ejercicios asociados.
     * @param leccion nombre de la lección a eliminar
     * @param xmlFile documento donde se encuentra la lección
     */
    public static void BorrarLeccion(String leccion,String xmlFile){
    try{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+xmlFile));  
        Element root=document.getDocumentElement();
        NodeList lsNode=root.getElementsByTagName(Util.LECCION_TAG);
        Node elemtn;
        for(int i=0;i<lsNode.getLength();i++){

           elemtn=lsNode.item(i).getFirstChild();
           if(leccion.equals(elemtn.getTextContent().trim())){
               elemtn=lsNode.item(i);
              elemtn.getParentNode().removeChild(elemtn);
               break;
           }
        }
         document.normalize();  
         CrearXML.CrearXML(document,xmlFile);
         }
         catch(Exception e)
         {
         System.out.println("Error en EliminarXml.BorrarLeccion:"+e);
         }
    }
    
    /**
     * Metodo para eliminar una materia de Recrea
     * Advertencia: al eliminar una materia se eliminar sus lecciones y 
     * ejercicios asignados a la misma.
     * @param materia 
     */
    public static void BorrarMateria(String materia){
     try{
        String xmlFile=Util.MATERIA_XML+Util.ARCHIVO_XML;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(Util.ARCHIVOS_XML_PATH+xmlFile));  
        Element root=document.getDocumentElement();
        NodeList lsNode=root.getElementsByTagName(Util.MATERIA_CHILD);
        Node elemtn;
        String xmlLeccion;
        for(int i=0;i<lsNode.getLength();i++){

           elemtn=lsNode.item(i).getFirstChild();
           System.out.println(elemtn.getTextContent().trim());
           System.out.println(materia);
           if(materia.equals(elemtn.getTextContent().trim())){
              xmlLeccion=elemtn.getParentNode().getAttributes().getNamedItem(Util.XML_ATRIBUTE).getTextContent();
              elemtn=lsNode.item(i);
              BorrarArchivo(xmlLeccion);
              elemtn.getParentNode().removeChild(elemtn);
               break;
           }
        }
         document.normalize();  
         CrearXML.CrearXML(document,xmlFile);
         }
         catch(Exception e)
         {
         System.out.println("Error en EliminarXml.BorrarMateria:"+e);
         }
    }
    /**
     * Metodo que elimina todo los archivos en Recrea
     */
    public static void BorrarTodo(){
        
    }
    
    /**
     * Metodo para eliminar un archivo de Recrea
     * @param xmlFile archivo con la extension ".xml" que sera borrado
     */
     private static void BorrarArchivo(String xmlFile){
        File personaFile=new File(Util.ARCHIVOS_XML_PATH+xmlFile);
        if(personaFile.exists())
            personaFile.delete();
    }
}
