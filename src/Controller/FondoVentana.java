/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Manuel
 */
public  class FondoVentana extends javax.swing.JPanel {
   
     private ImageIcon fondo;
     
     
     public FondoVentana(){
         
     }

      @Override
    public void paintComponent(Graphics g){
     // Dimension tamanio=getSize();
      super.paintComponent(g);
      Image imagenFondo=new ImageIcon(Util.IMAGE_CERO_PATH).getImage();
      g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);
   
    }
}
