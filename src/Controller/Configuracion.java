/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

/**
 * Clase para unificar la configuracion del tamaño del texto y color de los
 * componentes
 * @author Manuel Goncalves L.
 */
public class Configuracion {
 private int Size=6;
 private int maximoErrores=2;//maximo de errores encontrado entre palabras
 private final String tipografia=Util.LETRA_TIPO_TAHOMA;
 //Longitud maxima para los TextBox Recrea
 public static final int maxCaracteresTb= 25;
 //Longitud máxima para los númberBox Recrea porque int solo reconoce 2^31
 public static final int maxCaracteresNb =8; 
 private final String claveAcceso="recrea2016";
 
 public final int textoGrand=24;
 public final int textoInter=18;
 public final int textoMed=12;
 public final int textoPeque=6;
 
    /***
     * Metodo para la configuracion del color y el tamaño de los textos
     * @param Color Nombre del color (NEGRO,ROJO,AZUL,BLANCO)
     * @param tamaño tamaño de la letra (GRANDE,INTERMEDIO,MEDIANO,PEQUEÑO)
     */
    public void SetConfiguracion(String Color,String tamaño,Component cp){
     cp.setForeground(SetColor(Color));
     cp.setFont(SetTamaño(tamaño)); 
    }
    /**
     * Método para cambiar el color al texto
     * @param color Nombre del color (NEGRO,ROJO,AZUL,BLANCO)
     * @return Color deseado
     */
     public Color SetColor(String color){
          
        
         switch(color){
             case Util.CONFIG_COLOR_LETRA_NEGRO: return Color.BLACK;
             case Util.CONFIG_COLOR_LETRA_ROJO:return Color.RED;
             case Util.CONFIG_COLOR_LETRA_AZUL:return Color.BLUE; 
             case Util.CONFIG_COLOR_LETRA_BLANCO:return Color.WHITE;
            
         }
         
         return Color.BLACK;
     }
     /**
      * Método para cambiar el tamaño al texto
      * @param tamaño tamaño de la letra (GRANDE,INTERMEDIO,MEDIANO,PEQUEÑO) 
      * @return Font con el tamaño deseado
      */
     public Font SetTamaño(String tamaño){
          switch(tamaño){
             case Util.CONFIG_TAMAÑO_LETRA_GRANDE:
                 Size=textoGrand; break;
             case Util.CONFIG_TAMAÑO_LETRA_INTERMED:
                 Size=textoInter; break;
             case Util.CONFIG_TAMAÑO_LETRA_MED: 
                 Size=textoMed;break;
             case Util.CONFIG_TAMAÑO_LETRA_PEQUE: 
                 Size=textoPeque;break;
         }
          return new java.awt.Font(tipografia, 0, Size);
     }
     
     /**
      * Método que define la cantidad máxima de errores permitidos en un texto
      * por ejemplo si la respuesta es "CINCUENTA" y escribe "SINCUENTA" hay un error
      * @param maxErr cantidad de errores permitidos
      * @since valor por defecto 2
      */
     public void SetMaxErrores(int maxErr){
         this.maximoErrores=maxErr;
     }
     /**
      * Método para obtener la cantidad máxima de errores permitidos
      * por ejemplo si la respuesta es "CINCUENTA" y escribe "SINCUENTA" hay un error
      * @return cantidad máxima de errores permitidos
      */
     public int GetMaxErrores(){
         return this.maximoErrores;
     }
     /**
      * Retorna la clave de acceso para las secciones de administración de la aplicación
      * como lo es agregar/eliminar/modificar materia, leccion , ejercicio o usuario
      * @return clave para el acceso a la sección correspondiente
      */
     public String GetClave(){
         return this.claveAcceso;
     }
             
}
