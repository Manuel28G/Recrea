/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Model.Objetos.Ejercicio;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;


/**
 *
 * @author Manuel
 */
public class AccionXML {

    /***
     * 
     * @param Documento ruta del documento que se leera, usar MateriasPath
     * @return cantidad de etiquetas hijo que tiene el documento
     */
public static int ContarEtiquetas(String Documento,String nivel){
      try{                                            
       
      SAXBuilder builder = new SAXBuilder();
      org.jdom2.Document doc = builder.build(Documento);
      Element nodo=doc.getRootElement();;
      List<Element> nodos;

       if(nivel!=""){
          nodo=elementoNodo(nivel,nodo.getChildren());
       }
      return nodo.getChildren().size();
    
    }
      
  
          

     
      catch(Exception ex){
         System.out.println("Error en puertoTransporte: "+ex);
         return -1;
      }
    
}

/***
 * 
 * @param texto
 * @param elementos
 * @return
 * @throws Exception 
 */
public static Element elementoNodo(String texto,List<Element> elementos) throws Exception{
         Element nodo=null;
         for(Element el: elementos){
            if(el.getName().equals(texto))
                nodo=el;
         }
          if(nodo==null)
              throw new Exception("Error al intentar encontrar el nodo: AccionesXML.elementoNodo()");
          
          return nodo;
      
      }
/***
 * 
 * @param Documento
 * @param Variable
 * @param indice
 * @param Ruta
 * @return
 * @throws JDOMException 
 */
public static String InformacionEtiqueta(String Documento,String Variable,int indice,String Ruta) throws JDOMException{
     //Se crea un SAXBuilder para poder parsear el archivo
    String Respuesta="";
    String [] rut;
    SAXBuilder builder = new SAXBuilder();
    if(Ruta!=null)
        rut=Ruta.split("/");
    else
        rut=new String[0];
    org.jdom2.Element rootNode ;
    File xmlFile = new File(Documento );
   try{
        //Se crea el documento a traves del archivo
        org.jdom2.Document document = (org.jdom2.Document) builder.build( xmlFile );
        //Se obtiene la raiz 'tables'
         rootNode=document.getRootElement();
         for(int i=0;i<rut.length;i++)
            rootNode = elementoNodo(rut[i],rootNode.getChildren());
        //Se obtiene la lista de hijos de la raiz 'tables'
        
        List list = rootNode.getChildren( );
        //Se obtiene el elemento 'tabla'
        org.jdom2.Element tabla = (org.jdom2.Element) list.get(indice);
        if(Variable!=null)
            Respuesta = tabla.getAttributeValue(Variable);
        else
            Respuesta=tabla.getText(); 

        return Respuesta;
   }
   catch(Exception ex){
       return null;
   }
    
}

//terminar
/***
 * 
 * @param Documento
 * @param Variable
 * @param indice
 * @param Recorrido
 * @return
 * @throws XPathExpressionException
 * @throws ParserConfigurationException 
 */
public static String InformacionSubEtiqueta(String Documento,String Variable,int indice,String Recorrido) throws XPathExpressionException, ParserConfigurationException{
    DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
    String Respuesta="";
    try{
        org.w3c.dom.Document doc = documentBuilder.parse(new InputSource(new FileInputStream(Documento)));  
        
        Node etiquetaHija = (Node)(XPathFactory.newInstance().newXPath().evaluate(Recorrido, doc, XPathConstants.NODE));  
        
        if (etiquetaHija!=null){  
            List list= (List) etiquetaHija.getChildNodes();
            org.jdom2.Element tabla = (org.jdom2.Element) list.get(indice);
            if(Variable!=null)
                Respuesta = tabla.getAttributeValue(Variable);
            else
                Respuesta=tabla.getText(); 
            return Respuesta;  
        }  
    }
    catch(Exception ex){
        
    }
    return Respuesta;
}

}
