/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Manuel
 */
public class ConsultarXML {

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

       if(!nivel.equals("")){
          nodo=elementoNodo(nivel,nodo.getChildren());
       }
      return nodo.getChildren().size();
    
    }
      catch(Exception ex){
         System.out.println("Error en ConsultarXML.contarEtiquetas: "+ex);
         return -1;
      }
    
}

/***
 * Retorna un elemento de "elementos" que coincida con el nombre "texto"
 * @param texto
 * @param elementos
 * @return
 * @throws Exception 
 */
public static Element elementoNodo(String texto,List<Element> elementos) throws Exception{
         Element nodo=null;
         for(Element el: elementos){
            if(el.getName().equals(texto)){
                nodo=el;
                break;
            }
         }
          if(nodo==null)
              throw new Exception("Error al intentar encontrar el nodo: ConsultarXML.elementoNodo()");
          
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
        rut=Ruta.split(Util.SEPARADOR_DIRECTORIO);
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
public static String InformacionEtiquetaRec(String Documento,String Variable,String nombre){
     //Se crea un SAXBuilder para poder parsear el archivo
    String Respuesta="";
    File xmlFile = new File(Documento );
   try{
        
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document document = db.parse(xmlFile);  
    org.w3c.dom.Element root=document.getDocumentElement();
        NodeList lsNode=root.getElementsByTagName(Util.LECCION_TAG);//(Element)root.getElementsByTagName(Util.PERSONA_ACTIVIDAD_TAG);
   for(int i=0;i<lsNode.getLength();i++){
       Node elemtn=lsNode.item(i).getFirstChild();
       System.out.println("prim:"+elemtn.getTextContent());
       if(nombre.equals(elemtn.getTextContent())){
            Respuesta = elemtn.getParentNode().getAttributes().getNamedItem(Variable).getTextContent();
            System.out.println("Respuesta consultar: "+Respuesta);
        break;}
   }
   return Respuesta;
   }
   catch(Exception ex){
       return "";
   }
    
}

/**
 * Metodo para saber si un archivo existe 
 * @param archivoRuta ruta del archivo a consultar
 * @return true: si existe el archivo, false: si no existe el archivo
 */
public static boolean archivoCreado(String archivoRuta){
  File folder= new File(archivoRuta);
  if(!folder.exists()){
      return false;
  } 
  return true;
}
}
