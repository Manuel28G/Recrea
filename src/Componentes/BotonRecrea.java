/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Controller.Configuracion;
import Contrato.ContratoBotones;
import Controller.Util;
import java.awt.Color;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Componente BotonRecrea que agrupa los tipos de botones en la aplicación
 * Tipos: Siguiente, salir, Sonido, Opciones
 * Opciones: es usado para los botones de materias,lecciones y opciones de respuesta
 * Sonido: Se implementará para el boton que caracterizará la reproduccion de sonido
 * salir: boton para salir de la leccion o ejercicio
 * Siguiente: boton para continuar 
 * @author Manuel Goncalves L.
 */
public class BotonRecrea extends JButton {
    private Configuracion config=new Configuracion();
    
    public BotonRecrea(){
        super();
    }
    /**
     * Método que define la configuración básica del boton 
     * como lo es su color, su fondo 
     */
    private void configuracion(){
        
        this.setBackground(Color.LIGHT_GRAY);
        this.setFont(config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED));
        this.setForeground(config.SetColor(Util.CONFIG_COLOR_LETRA_NEGRO));
    }
    
    /**
     * Constructor de la clase BotonOpciones
     * @param tipo "Opciones" "Siguiente" "Regresar" "Sonido"
     * @param actGen Interface del Form que se quiere agregar el actionListener
     */
    public BotonRecrea(String tipo,ContratoBotones actGen){
        super();
        TipoDeBoton(tipo,actGen);
      //  configuracion();
        }
    
    /**
     * Constructor de la clase BotonOpciones
     * @param texto texto que contendrá el boton
     */
    public BotonRecrea(String texto){
        super();
        this.setText(texto);
        configuracion();
    }
    /**
      * Método que define la configuración del boton 
      * @param img  imagen que se le asignará al boton 
      * @param name nombre del boton (programación)
      * @return boton con las configuraciones necesarias
      */
    public JButton BotonConfig(String img,String name){
        ImageIcon imagen=new ImageIcon(Util.IMAGE_PATH+img);
        File resaltadoF=new File(Util.IMAGE_PATH+Util.IMAGEN_RESALTADO+img);
        this.setIcon(imagen);
        this.setActionCommand(name);
        this.setName(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        this.addMouseListener(null);
        if(resaltadoF.exists())
             this.setRolloverIcon(new ImageIcon(resaltadoF.getPath()));  //cambia la imagen al poner el mouse sobre el boton
        return this;
    }
    /**
     * Con este metodo definimos el ActionListener correspondiente al Boton 
     * @param tipo "Opciones" "Siguiente" "Regresar" "Sonido"
     * @param actGen Interface del Form que se quiere agregar el actionListener
     */
    private void TipoDeBoton(String tipo,ContratoBotones actGen) {
      try{
        switch(tipo)
        {
            case Util.BOTON_TIPO_OPCION:
                this.addActionListener(ActionsListener.ActionOpciones(actGen));
                this.addMouseListener(ActionsListener.ActionSonidoBoton());
                
                break;
            case Util.BOTON_TIPO_SEGUIR:
                this.addActionListener(ActionsListener.ActionSiguiente(actGen));
                break;
            case Util.BOTON_TIPO_SALIR: 
                this.addActionListener(ActionsListener.ActionSalir(actGen));
                break;
            case Util.BOTON_TIPO_SONIDO:
                this.addActionListener(ActionsListener.ActionSonido(actGen));
                break;
        }
      }
      catch(IOException ex){
          System.out.println("Error encontrado en BotonRecrea.TipoBoton de tipo IOException: "+ ex);
      }
        
    }
}
