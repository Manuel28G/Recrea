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

/**
 * Clase que define el boton Seguir en Recrea
 * @author Manuel Goncalves L.
 */
public class BotonSeguirRecrea extends javax.swing.JButton{
    private final String imagen="Seguir.png";
    private final String texto="Seguir";
    

    /***
     * Constructor
     * @param actGen  contrato de la interface en que se desplegara el boton
     */
    public BotonSeguirRecrea(ContratoBotones actGen) {
        try{
        this.addActionListener(ActionsListener.ActionSiguiente(actGen));
        this.addMouseListener(ActionsListener.ActionSonidoBoton());
        this.BotonConfig(imagen,texto);
        }
        catch(IOException ex){
            System.out.println("Error encontrado en BotonSeguirRecrea tipo IOException: "+ex);
        }
    }
    
        public BotonSeguirRecrea(){
            
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
        ImageIcon imagen=new ImageIcon(Util.IMAGE_PATH+img);
        File resaltadoF=new File(Util.IMAGE_PATH+Util.IMAGEN_RESALTADO+img);
        ImageIcon resaltado=new ImageIcon(resaltadoF.getPath());
        this.setActionCommand(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setIcon(imagen);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        if(resaltadoF.exists())
            this.setRolloverIcon(resaltado); 
    }

}
