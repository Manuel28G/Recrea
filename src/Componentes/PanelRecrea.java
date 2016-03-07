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
 *
 * @author Manuel
 */
public class PanelRecrea extends JPanel {
    
    public Component compEnUso;
  
    public PanelRecrea(){
        super();
    }
   //JPanel PN_Botones= new JPanel(new GridLayout(10, 3,10,10));
    public PanelRecrea(GridLayout gL){
      this.setLayout(gL);
    }
    public PanelRecrea(GridBagLayout gBL){
      this.setLayout(gBL);
    }
    
   @Override
    public void paintComponent(Graphics g)
    { 
      Image imagenFondo=new ImageIcon(Util.IMAGE_PATH+"Pizarra.png").getImage();
     g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);

    }
    
   


}
