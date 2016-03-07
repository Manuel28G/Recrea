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
 *
 * @author Manuel Goncalves L.
 */
public class VFRecrea extends PanelRecrea{
    private int dimX=145;
    private int dimY=23;
    private ButtonGroup btGroup=new ButtonGroup();
    public JRadioButton rbVerdad;
    public JRadioButton rbFalso;
    private int size=12;
    private String tipografia="Tahoma";
    private Color colorTexto=Color.WHITE;
    private java.awt.Font tipoTexto=new java.awt.Font(tipografia, 0, size);
    
    public VFRecrea(){
        super();
        rbVerdad=new JRadioButton("Verdadero");
        rbFalso=new JRadioButton("Falso");
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
