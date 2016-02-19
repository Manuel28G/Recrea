/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Manuel Goncalves L.
 */
public class TAreaRecrea extends JTextArea{
    private Color clr;
    
  private void SetTransparent(){
        clr= new Color(0,0,0,0);
        this.setOpaque(false);
        this.setBackground(clr);
        this.setOpaque(false);
        this.setBackground(clr);
      
        // Working.. As it wants to be transparent.
        this.setOpaque(false);
        this.setBackground(clr);
    }
    
  public TAreaRecrea (){
    SetTransparent();
    
   this.setColumns(20);
   this.setRows(5);
   this.setText("2Bienvenido a Recrea el lugar donde\ntu y yo practicaremos matemáticas\n\n¡Empezemos!\npor cierto ¿Cómo te llamas?");
        
    }
  public TAreaRecrea(String msj){
   SetTransparent();
   this.setText(msj);
   this.setColumns(20);
   this.setRows(5);
   this.setText("2Bienvenido a Recrea el lugar donde\ntu y yo practicaremos matemáticas\n\n¡Empezemos!\npor cierto ¿Cómo te llamas?");
        
  }
  
}
