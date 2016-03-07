/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Util;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Manuel Goncalves L.
 */
public class TAreaRecrea extends JTextArea{
    private Color clr;
    private final Configuracion config=new Configuracion();
    private final String color=Util.CONFIG_COLOR_LETRA_BLANCO;
    private final String tamaño=Util.CONFIG_TAMAÑO_LETRA_GRANDE;
    
  private void SetTransparent(){
        clr= new Color(0,0,0,0);
        this.setOpaque(false);
        this.setBackground(clr);
    }
  
  public void SetConfigText(){
    config.SetConfiguracion(color, tamaño, this);
  }
  
  private void Configuracion(){
    this.setLineWrap(true);
    this.setWrapStyleWord(true);
  }
    
  public TAreaRecrea (){
    super(10,1); 
    Configuracion();
    SetTransparent();
    }
  public TAreaRecrea(String msj){
   super(10,1);
   this.setText(msj);
   Configuracion();
   SetTransparent();
  }

  
}
