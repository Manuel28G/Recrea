/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class CrearXML {
    
/***
 * Se crea un archivo XML con la estructura básica
 * @param archivoNombre Nombre del archivo a crear 
 */
public static void XMLBasic(String archivoNombre) throws ParserConfigurationException, SAXException, IOException, TransformerException{

        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
       // Creamos el documento XML  
        DOMImplementation implementation = docBuilder.getDOMImplementation();
        Document document = implementation.createDocument(null,archivoNombre, null);
        //Indicamos donde lo queremos almacenar
        CrearXML(document,archivoNombre+Util.ARCHIVO_XML);
    
}
/**
 * Metodo para crear un XML
 * @param docmt documento que contiene la estructura del XML
 * @param nombreArchivo nombre del archivo a guardar XML
 * @throws ParserConfigurationException
 * @throws SAXException
 * @throws IOException
 * @throws TransformerConfigurationException
 * @throws TransformerException 
 */
protected static void CrearXML(Document docmt,String nombreArchivo) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
  File folder= new File(Util.ARCHIVOS_XML_PATH);
  if(!folder.exists()){
    folder.mkdirs();
  } 
    Source source = new DOMSource(docmt);
    //Indicamos donde lo queremos almacenar
    Result result = new StreamResult(new java.io.File(Util.ARCHIVOS_XML_PATH+nombreArchivo)); //nombre del archivo
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, result);
}

/***
 * Metodo en el cual se crea un usuario en RECREA
 * @param nombre nombre del usuario
 * @param apellido apellido del usuario
 * @param Ident identificador del usuario 
 */
public static void XMLPersona(String nombre,String apellido,String Ident) throws ParserConfigurationException, SAXException, IOException, TransformerException{
   
    XMLBasic(Util.PERSONA_XML);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(new InputSource(new FileInputStream(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+".xml" )));  
    
    Element elNbre=document.createElement(Util.PERSONA_NOMBRE_TAG);
    Element elApll=document.createElement(Util.PERSONA_APELLIDO_TAG);
    Element elIdent=document.createElement(Util.PERSONA_ID_TAG);
    Element elActiv=document.createElement(Util.PERSONA_ACTIVIDADES_TAG);
    Element rootNode ;
    elNbre.setTextContent(nombre);
    elApll.setTextContent(apellido);
    elIdent.setTextContent(Ident);
    
    rootNode=document.getDocumentElement();//Obtenemos la raiz del documento a consultar
    rootNode.appendChild(elNbre); //Agregamos los elementos hijos
    rootNode.appendChild(elApll);
    rootNode.appendChild(elIdent);
    rootNode.appendChild(elActiv);
    document.normalize();
    CrearXML(document,Util.PERSONA_XML+Util.ARCHIVO_XML);//creamos el documento con los nuevos valores


}


}
