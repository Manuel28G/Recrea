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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author Manuel Goncalves L.
 */
public class BotonSeguirRecrea extends javax.swing.JButton{
    private final String imagen="Seguir.png";
    private final String texto="Seguir";
    

    /***
     * 
     * @param actGen  contrato de la interface en que se desplegara el boton
     * @param practica  true si es para el area practica el tamaño aumenta
     */
    public BotonSeguirRecrea(ContratoBotones actGen){
        
        this.addActionListener(ActionsListener.ActionSiguiente(actGen));
        this.BotonConfig(imagen,texto);
    }
        public BotonSeguirRecrea(){
            
        this.BotonConfig(imagen,texto);
    }
    /***
     * 
     * @param img
     * @param name
     * @param x
     * @param y 
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
