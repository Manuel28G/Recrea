/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Configuracion;
import javax.swing.JLabel;

/**
 *
 * @author Manuel Goncalves L.
 */
public class LabelRecrea extends JLabel {
    
    private final String tamañoTxt="INTERMEDIO";
    private final String colorTxt="BLANCO";
    private final int size=0;
    private final String tipografia="Tahoma";
    private final Configuracion config=new Configuracion();
    /**
     * Constructor
     * @param msj mensaje que contendrá el Label
     * @param tmño tamaño del mensaje "GRANDE","INTERMEDIO","MEDIANO","PEQUEÑO"
     * @param clr color del mensaje "BLANCO","NEGRO","ROJO","AZUL"
     */
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
