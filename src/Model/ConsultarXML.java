/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 * clase que agrupa los métodos para consultar información en los archivos XML
 * @author Manuel Goncalves L.
 */
public class ConsultarXML {

    /***
     * método para contar las etiquetas o nodos principales de un archivo XML
     * @param Documento ruta del documento que se leera, usar MateriasPath
     * @return cantidad de etiquetas hijo que tiene el documento
     */
public static int ContarEtiquetas(String Documento,String nivel) throws JDOMException, IOException, Exception{
                                          
       
      SAXBuilder builder = new SAXBuilder();
      org.jdom2.Document doc = builder.build(Documento);
      Element nodo=doc.getRootElement();
      List<Element> nodos;

       if(!nivel.equals("")){
          nodo=elementoNodo(nivel,nodo.getChildren());
       }
      return nodo.getChildren().size();
    
    }

    


/***
 * Retorna un elemento de "elementos" que coincida con el nombre "texto"
 * @param texto  Informacion a consultar 
 * @param elementos elementos a consular ara buscar coincidencia
 * @return si se coincide la información se retorna el elemento sinó se retorna Null
 * @throws Exception 
 */
private static Element elementoNodo(String texto,List<Element> elementos) throws Exception{
         Element nodo=null;
         for(Element el: elementos){
            if(el.getName().trim().equals(texto.trim())||el.getText().trim().equals(texto.trim())){
                nodo=el;
                break;
            }
         }
          if(nodo==null)
              throw new Exception("Error al intentar encontrar el nodo: ConsultarXML.elementoNodo()");
          
          return nodo;
      
      }
/***
 * Metodo para solicitar la informacion de una etiqueta en específico
 * @param Documento documento que se inspecionará
 * @param Variable variabel dentro de la etiqueta que se buscará si se desea el texto entre la etiqueta se coloca Null
 * @param indice indice donde se encuentra la informacion
 * @param Ruta si se requiere se coloca la ruta para llegar a la información requerida sino se coloca null
 * @return
 * @throws JDOMException 
 */
public static String InformacionEtiqueta(String Documento,String Variable,int indice,String Ruta) throws JDOMException, IOException, Exception{
     //Se crea un SAXBuilder para poder parsear el archivo
    String Respuesta="";
    String [] rut;
    SAXBuilder builder = new SAXBuilder();
    if( !Ruta.equals(""))
        rut=Ruta.split(Util.SEPARADOR_DIRECTORIO);
    else
        rut=new String[0];
        org.jdom2.Element rootNode ;
        File xmlFile = new File(Documento );
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

        if(!Variable.equals("")){
            if(Variable.equals(Util.ETIQUETA_NOMBRE))
                Respuesta=tabla.getName();
            else
                Respuesta = tabla.getAttributeValue(Variable);}
        else
            Respuesta=tabla.getText(); 

        return Respuesta;
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
