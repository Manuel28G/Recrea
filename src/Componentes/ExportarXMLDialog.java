/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Util;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ExportarXMLDialog extends javax.swing.JFileChooser {
    int seleccion;
    File DirDestino;// directorio donde se copiaran los archivos 
    File DirRecrea;//Donde se copiaran todos los archivos existentes en recrea
    File DirOrigen;//Donde reciden los archivos XML de recrea
    File ArchOrigen;//archivo XML origen
    File ArchDestino;//Archivo XML destino
    FileNameExtensionFilter filtro = new FileNameExtensionFilter(".xml","xml");
    String archivoNombre;
    String strDestino;
    
    public ExportarXMLDialog(){
        
       this.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showSaveDialog(new JFrame());//puede ser new JFrame()
    }
    
    /**
     * 
     * @param cG 
     */
   public ExportarXMLDialog(Component cG){
       this.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showSaveDialog(cG);//puede ser new JFrame()
   }
    private int getStatus(){
        return seleccion;
    }
   public void Guardar(){
      try{
       if(this.getStatus()==JFileChooser.APPROVE_OPTION){
        DirDestino=this.getSelectedFile();
        DirRecrea=new File(DirDestino+Util.DIRECTORIO_RECREA);
        DirRecrea.mkdir();
        DirOrigen = new File(Util.ARCHIVOS_XML_PATH);
        File[] listOfFiles = DirOrigen.listFiles(); 
        for (int i = 0; i < listOfFiles.length; i++) 
           {
               if (listOfFiles[i].isFile()) 
               {
                   archivoNombre = listOfFiles[i].getName();
                   if (archivoNombre.endsWith(".xml") || archivoNombre.endsWith(".XML"))
                   {
                       ArchOrigen=new File(DirOrigen+Util.SEPARADOR_DIRECTORIO+archivoNombre);
                       ArchDestino=new File(DirRecrea+Util.SEPARADOR_DIRECTORIO+archivoNombre);
                       System.out.println(ArchDestino);
                       System.out.println(ArchOrigen);
                       CrearXML(ArchOrigen,ArchDestino.toString());
                   }
               }
           }
    }
    }
    catch(Exception e){}
     
   }

private static void CrearXML(File fileOrigen,String rutaArchivo) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
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
