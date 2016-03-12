/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Controller.Util;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *Clase que define el boton Salir en Recrea
 * @author Manuel Goncalves L.
 */
public class BotonSalirRecrea extends JButton {
    private final String imagen="Regresar.png";
    private final String texto="Regresar";
    private final String salirTexto="Salir";
    private final String salirImagen="salir.png";

    /**
     * Constructor
     * @param actGen
     * @param salir si es boton de salir se colocará la palabra "Salir", sino será "Regresar"
     */
    public BotonSalirRecrea(ContratoBotones actGen,boolean salir) {
        try{
        this.addActionListener(ActionsListener.ActionSalir(actGen));
        this.addMouseListener(ActionsListener.ActionSonidoBoton());
        }
         catch(IOException ex){
          System.out.println("Error encontrado en BotonSalirRecrea de tipo IOException: "+ ex);
      }
       
        if(salir)
            this.BotonConfig(salirImagen,salirTexto);
        else
            this.BotonConfig(imagen,texto);
    }
        public BotonSalirRecrea(){
            
        this.BotonConfig(imagen,texto);
    }
    /**
      * Método que define la configuración del boton 
      * @param img  imagen que se le asignará al boton 
      * @param name nombre del boton (programación)
      * @return boton con las configuraciones necesarias
      */
    private void BotonConfig(String img,String name) {
        this.setText("");
        ImageIcon imagenIcon=new ImageIcon(Util.IMAGE_PATH+img);
        File resaltadoF=new File(Util.IMAGE_PATH+Util.IMAGEN_RESALTADO+img);
        ImageIcon resaltado=new ImageIcon(resaltadoF.getPath());
        this.setActionCommand(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setIcon(imagenIcon);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        if(resaltadoF.exists())
            this.setRolloverIcon(resaltado); 
    }
    
    
}
