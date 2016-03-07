/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import javax.swing.JLabel;

/**
 *
 * @author Manuel
 */
public class LabelRecrea extends JLabel {
    
    private String tamañoTxt="INTERMEDIO";
    private String colorTxt="BLANCO";
    private int size=0;
    private String tipografia="Tahoma";
    private Configuracion config=new Configuracion();
    
    public LabelRecrea(String msj,String tmño, String clr){
        Texto(msj, tmño, clr);
    }
    
    public LabelRecrea(){
        super();
        Texto("",tamañoTxt,colorTxt);
    }
    
     public LabelRecrea(String msj){
        Texto(msj,tamañoTxt,colorTxt);
    }
 /*    public void setTamaño(String tamaño){
          switch(tamaño){
             case "GRANDE":
                 size=24; break;
             case "INTERMEDIO":
                 size=18; break;
             case "MEDIANO": 
                 size=12;break;
             case "PEQUEÑO": 
                 size=6;break;
         }
     }
     public void setColor(String color){
          
        
         switch(color){
             case "NEGRO":
         this.setForeground(Color.BLACK); break;
             case "ROJO":
         this.setForeground(Color.RED); break;
             case "AZUL":
         this.setForeground(Color.BLUE); break;  
             case "BLANCO": 
         this.setForeground(Color.WHITE);break;
            
         }
     }*/
     
    /**
     * Se creará el texto de acuerdo a cierta configuracion
     * @param mensaje Mensaje añadido al Jlabel
     * @param tamaño "GRANDE,MEDIADO,PEQUEÑO"
     * @param color "NEGRO,ROJO,AZUL,VERDE"
     * @return 
     */
     private void Texto(String mensaje,String tamaño,String color){
         config.SetConfiguracion(color, tamaño, this);
         this.setText(mensaje);
     }
     
}
