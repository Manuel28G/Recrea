/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Util;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Clase que define el Panel Recrea 
 * @author Manuel Goncalves L.
 */
public class PanelRecrea extends JPanel {
    
    private final String fondo=Util.IMAGE_PATH+"Pizarra.png";
    public Component compEnUso;//componente que está siendo usado en la actualidad
    //en el area de los ejercicios con esto podremos saber si la respuesta es un
    //textbox, numberBox, VF  o botones
  
    public PanelRecrea(){
        super();
    }
    
    public PanelRecrea(GridLayout gL){
      this.setLayout(gL);
    }
    public PanelRecrea(GridBagLayout gBL){
      this.setLayout(gBL);
    }
    /**
     * Este método pinta el fondo del panel
     * @param g el objeto grafica del panel
     */
   @Override
    public void paintComponent(Graphics g)
    { 
      Image imagenFondo=new ImageIcon(fondo).getImage();
     g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);

    }
    
   


}
