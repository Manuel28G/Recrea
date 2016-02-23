/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Controller.Util;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Manuel
 */
public class BotonRecrea extends JButton {
    
    
    public BotonRecrea(){
        super();
    }
    /**
     * Constructor de la clase BotonOpciones
     * @param tipo "Opciones" "Siguiente" "Regresar" "Sonido"
     * @param actGen Interface del Form que se quiere agregar el actionListener
     */
    public BotonRecrea(String tipo,ContratoBotones actGen){
        super();
        TipoDeBoton(tipo,actGen);
        
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
        this.setIcon(imagen);
        this.setActionCommand(name);
        this.setSize(x, y);
        this.setName(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        this.addMouseListener(null);
        this.setRolloverIcon(new ImageIcon(Util.IMAGE_PATH+"Resaltar"+img)); 
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
