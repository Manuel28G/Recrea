/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * Componente que contiene dos radiobutton para responder Verdadero o Falso
 * @author Manuel Goncalves L.
 */
public class VFRecrea extends PanelRecrea{
    private final int dimX=145;
    private final int dimY=23;
    private final ButtonGroup btGroup=new ButtonGroup();
    public JRadioButton rbVerdad;
    public JRadioButton rbFalso;
    private int size=12;
    private final String tipografia="Tahoma";
    private final Color colorTexto=Color.WHITE;
    private java.awt.Font tipoTexto=new java.awt.Font(tipografia, 0, size);
    private final String verdadero="Verdadero";
    private final String falso="Falso";
    
    public VFRecrea(){
        super();
        rbVerdad=new JRadioButton(verdadero);
        rbFalso=new JRadioButton(falso);
        rbVerdad.setFont(tipoTexto);
        rbVerdad.setForeground(colorTexto);
        rbFalso.setFont(tipoTexto);
        rbFalso.setForeground(colorTexto);
        this.setSize(dimX, dimY);
        btGroup.add(rbVerdad);
        btGroup.add(rbFalso);
        this.add(rbVerdad);
        this.add(rbFalso);
    }
    
    public void SetConfig(){
     size=18;
     tipoTexto=new java.awt.Font(tipografia, 0, size);
     rbFalso.setFont(tipoTexto);
     rbVerdad.setFont(tipoTexto);
    }
    

}
