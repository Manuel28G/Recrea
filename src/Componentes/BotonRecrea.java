/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Controller.Util;
import java.awt.Color;
import java.awt.Insets;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Manuel
 */
public class BotonRecrea extends JButton {
    private Configuracion config=new Configuracion();
    
    public BotonRecrea(){
        super();
    }
    
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
     * @param texto 
     */
    public BotonRecrea(String texto){
        super();
        this.setText(texto);
        configuracion();
    }
    /**
      * 
      * @param img  imagen que se le asignará al boton 
      * @param name nombre del boton (programación)
      * @param x  tamaño de anchura
      * @param y tamaño de altura
      * @return boton con las configuraciones necesarias
      */
    public JButton BotonConfig(String img,String name,int x,int y){
        ImageIcon imagen=new ImageIcon(Util.IMAGE_PATH+img);
        File resaltadoF=new File(Util.IMAGE_PATH+Util.IMAGEN_RESALTADO+img);
        this.setIcon(imagen);
        this.setActionCommand(name);
        this.setSize(x, y);
        this.setName(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        this.addMouseListener(null);
        if(resaltadoF.exists())
             this.setRolloverIcon(new ImageIcon(resaltadoF.getPath())); 
        return this;
    }
    /**
     * Con este metodo definimos el ActionListener correspondiente al Boton 
     * @param tipo "Opciones" "Siguiente" "Regresar" "Sonido"
     * @param actGen Interface del Form que se quiere agregar el actionListener
     */
    private void TipoDeBoton(String tipo,ContratoBotones actGen){
        switch(tipo)
        {
            case Util.BOTON_TIPO_OPCION:
                this.addActionListener(ActionsListener.ActionOpciones(actGen));
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
}
