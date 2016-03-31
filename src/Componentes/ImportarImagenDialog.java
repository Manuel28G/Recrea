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
 * Clase que crea el dialogo para Importar los archivos(Imagenes)  
 * @author Manuel Goncalves L.
 */
public class ImportarImagenDialog extends javax.swing.JFileChooser {
     int seleccion;
    private File DirDestino;// directorio donde se copiaran los archivos 
   // private File DirRecrea;//Donde se copiaran todos los archivos existentes en recrea
    private File DirOrigen;//Donde reciden los archivos XML de recrea
    //private File ArchOrigen;//archivo XML origen
    private File ArchDestino;//Archivo XML destino
    private final FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes",new String []{"png","jpg","jpeg"});
   // private String archivoNombre;
   // private String strDestino;
    
    public ImportarImagenDialog(){
        
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showOpenDialog(new JFrame());
    }
    /**
     * Constructor
     * @param cG componente donde se va a desplegar el importarImagenDialog
     */
    public ImportarImagenDialog(Component cG){
       this.setFileSelectionMode( JFileChooser.FILES_ONLY);
       this.setFileFilter(filtro);
       this.setAcceptAllFileFilterUsed(false);//para solo aceptar los archivos puesto en los filtros
       seleccion = this.showOpenDialog(cG);
    }
    
    /**
     * Método que ejecuta el cargar los archivos de la ruta que se especificará
     */
 public void Cargar()
 {
    if(this.getStatus()==JFileChooser.APPROVE_OPTION){
        ArchDestino=this.getSelectedFile();
        DirDestino=new File(Util.RUTA_SRC+Util.IMAGE_PATH);
        DirDestino.mkdir();
        if(ArchDestino.isFile())
            DirOrigen=new File(ArchDestino.toString());
        else
            return;
        DirDestino=new File(DirDestino+Util.SEPARADOR_DIRECTORIO+ArchDestino.getName());
        ImportarImagen(DirOrigen,DirDestino);}
                  
 }
               
    /**
    * obtiene la ruta seleccionada 
    * @return retorna la ruta seleccionada
    */    
     public int getStatus(){
         return seleccion;
     }
     
 /**
  * Metodo que importa las imagenes al sistema
  * @param fileOrigen archivo a importar
  * @param rutaArchivo ruta del archivo donde se guardará
  */
private void ImportarImagen(File fileOrigen,File rutaArchivo) {
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
