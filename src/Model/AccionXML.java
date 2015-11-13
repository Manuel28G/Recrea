/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.MateriasPath;
import Controller.Util;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.jdom2.JDOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


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
public static int ContarEtiquetas(String Documento){
      try{                                            

      SAXBuilder builder = new SAXBuilder();
      org.jdom2.Document doc = builder.build(Documento);
      return doc.getRootElement().getChildren().size();
    
    }
          
      
     
      catch(Exception ex){
         System.out.println("Error en puertoTransporte: "+ex);
         return -1;
      }
    
}
/***
 * se retornara la informacion de la etiqueta que deseamos obtener P.EJE nombre
 * @param Documento ruta del documento 
 * @param Variable que se desea obtener si es null retorna texto
 * @param indice Posicion de la etiqueta a examinar
 */
public static String InformacionEtiqueta(String Documento,String Variable,int indice) throws JDOMException{
     //Se crea un SAXBuilder para poder parsear el archivo
    String Respuesta="";
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(Documento );
   try{
        //Se crea el documento a traves del archivo
        org.jdom2.Document document = (org.jdom2.Document) builder.build( xmlFile );
 
        //Se obtiene la raiz 'tables'
        org.jdom2.Element rootNode = document.getRootElement();
 
        //Se obtiene la lista de hijos de la raiz 'tables'
        List list = rootNode.getChildren( );

            //Se obtiene el elemento 'tabla'
            org.jdom2.Element tabla = (org.jdom2.Element) list.get(indice);
 
            //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
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


public static void Materias() throws ParserConfigurationException, SAXException{
    try{                                            
      org.w3c.dom.Element e= null ;
      org.w3c.dom.Document doc=null;
      Node nodo2=null;
      NodeList hijo;
      XPathFactory xpathFactory = XPathFactory.newInstance();
      XPath xpath = xpathFactory.newXPath();
      DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
      doc = documentBuilder.parse(new InputSource(new FileInputStream(MateriasPath.MATERIAS_XML_PATH)));
                //con Xpath podremos recorrer el XML poniendo la estructura que se desea recorrer en el primer parametro de evaluate()
      //hijo=(NodeList) xpath.evaluate("Cero/Ejercicio/Eje", doc,XPathConstants.NODESET);
      hijo=(NodeList) xpath.evaluate("Materias", doc,XPathConstants.NODESET);
      System.out.println(hijo.item(0).getNodeName());
      System.out.println(hijo.item(0).getLocalName());
      System.out.println(hijo.item(0).getTextContent());
    
    }
          
      
     
      catch(Exception ex){
         System.out.println("Error en puertoTransporte: "+ex);
      }
  
    
}

/*
public ArrayList retornarMaterias(String NombreBusc){
    
      org.jdom2.Element root,e= null ;
      org.w3c.dom.Document doc=null;
      Node nodo2=null;
      NodeList hijo;
      ArrayList Mensajes=new ArrayList();
      
     SAXBuilder  builder = new SAXBuilder();

      try{
          
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
        doc = documentBuilder.parse(new InputSource(new FileInputStream(Util.MENSAJES_XML_PATH)));
        hijo=doc.getElementsByTagName(Util.MENSAJE_TAG);
        System.out.println(hijo.getLength());
        int cont=0;
        for(int i=0;i<hijo.getLength();i++){
            nodo2=hijo.item(i);
          System.out.println("destino: "+nodo2.getChildNodes().item(5).getTextContent());
          
            if(NombreBusc.equals(nodo2.getChildNodes().item(5).getTextContent().toString())){
                Mensajes.add(nodo2.getChildNodes().item(0).getTextContent().toString());
                Mensajes.add(nodo2.getChildNodes().item(1).getTextContent().toString());
                cont++;
            }
       
        }
      }
      catch(Exception ex){
         System.out.println("Error en puertoTransporte:"+ex);
      }
       
  return Mensajes;
    
    
}
*/
}
