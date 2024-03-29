/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Util;
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * Clase que crea el dialogo para importar los archivos XML previamente creados
 * en la aplicación
 * @author Manuel Goncalves L.
 */
public class ImportarXMLDialog extends javax.swing.JFileChooser {
    
    int seleccion;
    File DirDestino;// directorio donde se copiaran los archivos 
    File DirRecrea;//Donde se copiaran todos los archivos existentes en recrea
    File DirOrigen;//Donde reciden los archivos XML de recrea
    File ArchOrigen;//archivo XML origen
    File[] ArchDestinos;//todos los archivos seleccionados
   // File ArchDestino;//Archivo XML destino
    FileNameExtensionFilter filtro = new FileNameExtensionFilter(".xml","xml");
    String archivoNombre;
    String strDestino;
    
    public ImportarXMLDialog(){
        
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setMultiSelectionEnabled(true);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showOpenDialog(new JFrame());
    }
    /**
     * Constructor
     * @param cG componente donde se va a desplegar el ImpotarXMLDialog
     */
    public ImportarXMLDialog(Component cG){
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setMultiSelectionEnabled(true);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       this.setFileFilter(filtro);
       seleccion = this.showOpenDialog(cG);
    }
    
   /**
    * obtiene la ruta seleccionada 
    * @return retorna la ruta seleccionada
    */
    private int getStatus(){
        return seleccion;
    }
    
    /**
     * Método que ejecuta el cargar  los archivos en la ruta que se especificará
     */
 public void Cargar()
 {
      if(this.getStatus()==JFileChooser.APPROVE_OPTION){
        ArchDestinos=this.getSelectedFiles();
        DirDestino=new File(Util.ARCHIVOS_XML_PATH);
        DirDestino.mkdir();
        for(File ArchDestino:ArchDestinos)
        {
        if(ArchDestino.isFile())
            DirOrigen=new File(ArchDestino.toString());
        else
            return;
        DirDestino=new File(Util.ARCHIVOS_XML_PATH+Util.SEPARADOR_DIRECTORIO+ArchDestino.getName());
        System.out.println(DirOrigen);
        System.out.println(DirDestino);
        CrearXML(DirOrigen,DirDestino.toString());
        }
      }
                  
 }
               
           
     
     
 /**
 * Método que crea los archivos en la dirección seleccionada 
 * @param fileOrigen archivo origen 
 * @param rutaArchivo ruta del archivo destino
 */
private static void CrearXML(File fileOrigen,String rutaArchivo) {
   try{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document docmt = db.parse(fileOrigen);  
    Source source = new DOMSource(docmt);
    Result result = new StreamResult(new java.io.File(rutaArchivo)); 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, result);
   }
   catch(Exception e){
       System.out.println("Error al crear archivo GuardarXMLDialog:"+e);
   
   }
}
}
