/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Configuracion;
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
    
    /**
     * Método que transforma en transparente el TextArea
     */
  private void SetTransparent(){
        clr= new Color(0,0,0,0);
        this.setOpaque(false);
        this.setBackground(clr);
    }
  /**
   * Configuracion para cambiar el color y tamaño del texto
   * por defecto es color Blanco y de tamaño Grande
   */
  public void SetConfigText(){
    config.SetConfiguracion(color, tamaño, this);
  }
  /**
   * Configuración general para que de salto de línea al llegar al limite horizontal
   * del textAreaRecrea
   */
  private void Configuracion(){
    this.setLineWrap(true);
    this.setWrapStyleWord(true);
  }
    
  public TAreaRecrea (){
    super(10,1); 
    Configuracion();
    SetTransparent();
    }
  /**
   * Constructor 
   * @param msj mensaje que se asigna al textAreaRecrea
   */
  public TAreaRecrea(String msj){
   super(10,1);
   this.setText(msj);
   Configuracion();
   SetTransparent();
  }

  
}
