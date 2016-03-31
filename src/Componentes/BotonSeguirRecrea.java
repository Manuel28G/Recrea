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

/**
 * Clase que define el boton Seguir en Recrea
 * @author Manuel Goncalves L.
 */
public class BotonSeguirRecrea extends javax.swing.JButton{
    private final String imagen="Seguir.png";
    private final String texto="Seguir";
    private final ControllerAgregar ca;
    

    /***
     * Constructor
     * @param actGen  contrato de la interface en que se desplegara el boton
     */
    public BotonSeguirRecrea(ContratoBotones actGen) {
        ca=new ControllerAgregar();
        try{
        this.addActionListener(ActionsListener.ActionSiguiente(actGen));
        this.addMouseListener(ActionsListener.ActionSonidoBoton());
        this.BotonConfig(imagen,texto);
        }
        catch(IOException ex){
            System.out.println("Error encontrado en BotonSeguirRecrea tipo IOException: "+ex);
        }
    }
    
        public BotonSeguirRecrea(){
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
