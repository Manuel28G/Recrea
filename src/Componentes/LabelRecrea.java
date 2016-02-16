/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Manuel
 */
public class LabelRecrea extends JLabel {
    
    public LabelRecrea(String msj,String tmño, String clr){
        Texto(msj, tmño, clr);
    }
    
    public LabelRecrea(){
        Texto("","GRANDE","BLANCO");
    }
    
     public LabelRecrea(String msj){
        Texto(msj,"GRANDE","BLANCO");
    }
    /**
     * Se creará el texto de acuerdo a cierta configuracion
     * @param mensaje Mensaje añadido al Jlabel
     * @param tamaño "GRANDE,MEDIADO,PEQUEÑO"
     * @param color "NEGRO,ROJO,AZUL,VERDE"
     * @return 
     */
     private void Texto(String mensaje,String tamaño,String color){
         int size=0;
         
         switch(tamaño){
             case "GRANDE":
                 size=24; break;
             case "MEDIANO": 
                 size=12;break;
             case "PEQUEÑO": 
                 size=6;break;
         }
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
         
         this.setFont(new java.awt.Font("Tahoma", 0, size)); 
         this.setText(mensaje);
     }
     
}
