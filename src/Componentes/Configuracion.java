/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * Clase para unificar la configuracion del tamaño del texto y color de los
 * componentes
 * @author Manuel Goncalves L.
 */
public class Configuracion {
 private Color clr;
 private Font fondo;
 private int Size=6;
 private int maximoErrores=2;//maximo de errores encontrado entre palabras
 //por ejemplo si la respuesta es "CINCUENTA" y escribe "SINCUENTA" hay un error
 private String tipografia="Tahoma";
    /***
     * Metodo para la configuracion del color y el tamaño de los textos
     * @param Color
     * @param tamaño 
     */
    public void SetConfiguracion(String Color,String tamaño,Component cp){
     cp.setForeground(SetColor(Color));
     cp.setFont(SetTamaño(tamaño)); 
    }
    
     public Color SetColor(String color){
          
        
         switch(color){
             case "NEGRO": return Color.BLACK;
             case "ROJO":return Color.RED;
             case "AZUL":return Color.BLUE; 
             case "BLANCO":return Color.WHITE;
            
         }
         
         return Color.BLACK;
     }
     
     public Font SetTamaño(String tamaño){
          switch(tamaño){
             case "GRANDE":
                 Size=24; break;
             case "INTERMEDIO":
                 Size=18; break;
             case "MEDIANO": 
                 Size=12;break;
             case "PEQUEÑO": 
                 Size=6;break;
         }
          return new java.awt.Font(tipografia, 0, Size);
     }
     
     public void SetMaxErrores(int maxErr){
         this.maximoErrores=maxErr;
     }
     public int GetMaxErrores(){
         return this.maximoErrores;
     }
             
}
