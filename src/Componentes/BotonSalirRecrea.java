/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Controller.ControllerAgregar;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *Clase que define el boton Salir en Recrea
 * @author Manuel Goncalves L.
 */
public class BotonSalirRecrea extends JButton {
    private final String imagen="Regresar.png";
    private final String texto="Regresar";
    private final String salirTexto="Salir";
    private final String salirImagen="Salir.png";
    private final ControllerAgregar ca;

    /**
     * Constructor
     * @param actGen
     * @param salir si es boton de salir se colocará la palabra "Salir", sino será "Regresar"
     */
    public BotonSalirRecrea(ContratoBotones actGen,boolean salir) {
        ca=new ControllerAgregar();
        try{
        this.addActionListener(ActionsListener.ActionSalir(actGen));
        this.addMouseListener(ActionsListener.ActionSonidoBoton());
        }
         catch(IOException ex){
          System.out.println("Error encontrado en BotonSalirRecrea de tipo IOException: "+ ex);
      }
       
        if(salir)
            this.BotonConfig(salirImagen,salirTexto);
        else
            this.BotonConfig(imagen,texto);
    }
        public BotonSalirRecrea(){
            ca=new ControllerAgregar();
            this.BotonConfig(imagen,texto);
    }
    /**
      * Método que define la configuración del boton 
      * @param img  imagen que se le asignará al boton 
      * @param name nombre del boton (programación)
      * @return boton con las configuraciones necesarias
      */
    private void BotonConfig(String img,String name) {
        this.setText("");
        ca.agregarImagenBoton(img, this);
        this.setActionCommand(name);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
    }
    
    
}
