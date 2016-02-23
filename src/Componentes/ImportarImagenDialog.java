/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Util;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ImportarImagenDialog extends javax.swing.JFileChooser {
     int seleccion;
    File DirDestino;// directorio donde se copiaran los archivos 
    File DirRecrea;//Donde se copiaran todos los archivos existentes en recrea
    File DirOrigen;//Donde reciden los archivos XML de recrea
    File ArchOrigen;//archivo XML origen
    File ArchDestino;//Archivo XML destino
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes",new String []{"png","jpg","jpeg"});
    String archivoNombre;
    String strDestino;
    
    public ImportarImagenDialog(){
        
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showOpenDialog(new JFrame());
    }
    
    public ImportarImagenDialog(Component cG){
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setFileFilter(filtro);
       seleccion = this.showOpenDialog(cG);
    }
    
 public void Cargar()
 {
        ArchDestino=this.getSelectedFile();
        DirDestino=new File(Util.IMAGE_PATH);
        DirDestino.mkdir();
        if(ArchDestino.isFile())
            DirOrigen=new File(ArchDestino.toString());
        else
            return;
        DirDestino=new File(DirDestino+Util.SEPARADOR_DIRECTORIO+ArchDestino.getName());
        System.out.println(DirOrigen);
        System.out.println(DirDestino);
        ImportarImagen(DirOrigen,DirDestino.toString());
                  
 }
               
           
     public int getStatus(){
         return seleccion;
     }
     
 
private void ImportarImagen(File fileOrigen,String rutaArchivo) {
 try{
    FileInputStream fis = new FileInputStream(fileOrigen); //inFile -> Archivo a copiar
    FileOutputStream fos = new FileOutputStream(rutaArchivo); //outFile -> Copia del archivo
    FileChannel inChannel = fis.getChannel(); 
    FileChannel outChannel = fos.getChannel(); 
    inChannel.transferTo(0, inChannel.size(), outChannel); 
    fis.close(); 
    fos.close();
}catch (Exception ex) {
System.err.println("Error al Generar Copia en ImportarImagen: "+ ex);
}
}
}
