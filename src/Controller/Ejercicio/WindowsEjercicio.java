/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Ejercicio;

import Model.Objetos.Ejercicio;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import Componentes.ActionsListener;
import Componentes.BotonRecrea;
import Componentes.LabelRecrea;
import Componentes.PanelRecrea;
import Contrato.ContratoBotones;
import Contrato.ContratoGeneral;

/**
 * se creara la ventan de ejercicios
 * @author Manuel
 */
public class WindowsEjercicio {
    
    private JScrollPane SP_Contenido;
    private final GridBagLayout GridBL=new GridBagLayout();
    private final GridLayout GridL1y3x= new GridLayout(1,3,10,10);
  //  private BotonRecrea botonOpt;
    
    
    private final PanelRecrea PN_Ejercicio= new PanelRecrea(GridBL);
    private final PanelRecrea PN_OpcionesEjer=new PanelRecrea(GridL1y3x);
    
    LabelRecrea a1= new LabelRecrea(),a2= new LabelRecrea(),a3= new LabelRecrea(),b= new LabelRecrea(),c1= new LabelRecrea(),c2= new LabelRecrea(),c3= new LabelRecrea();
    JButton b1=new JButton(),b2=new JButton(),b3=new JButton(),seguir=new JButton("SEGUIR"), contenido=new JButton("Contenido");
    private BotonRecrea salir;
    
    private GridBagConstraints GridBC ;
    private ContratoBotones ctoEjercicio;
    

    
    public  WindowsEjercicio(ContratoBotones ctoGen){
        ctoEjercicio=ctoGen;
        
        this.salir = new BotonRecrea("Regresar",ctoEjercicio);
        this.salir.setText("SALIR");
        
        PN_Ejercicio.setLayout(GridBL);
        GridBC = new GridBagConstraints();
        
        GridBC.ipady = 0; 
        GridBC.insets = new Insets(0,0,0,0);  //top padding
        GridBC.weightx = 0.5;
        GridBC.weighty = 0;   //request any extra vertical space
    }
    
    
    private void ConstraintConfig(int PosX, int PosY,boolean FHorizontal,boolean PageStart){
        GridBC.gridx=PosX;
        GridBC.gridy=PosY;
        if(FHorizontal)
            GridBC.fill=GridBagConstraints.HORIZONTAL;
        else
            GridBC.fill=GridBagConstraints.BOTH;
        if(PageStart)
            GridBC.anchor=GridBagConstraints.PAGE_START;
        else
            GridBC.anchor=GridBagConstraints.PAGE_END;
    }
    public PanelRecrea loquesa(Ejercicio ejc,String CantEjer,String persona){
        
        PN_Ejercicio.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        ConstraintConfig(2,0,true,true);
        a1.setText(CantEjer);
        a1.setHorizontalAlignment(SwingConstants.CENTER);
        PN_Ejercicio.add(a1,GridBC);

        ConstraintConfig(1,0,true,true);
        a2.setText(persona);
        a2.setHorizontalAlignment(SwingConstants.CENTER);
        PN_Ejercicio.add(a2,GridBC);
        
        a3.setText("Altavoz");
        a3.setHorizontalAlignment(SwingConstants.CENTER);
        
        ConstraintConfig(0,0,true,true);
        PN_Ejercicio.add(a3,GridBC);
        int val;
        if(ejc.getTipo().equals("NUMEROS")){
            val=Integer.parseInt(ejc.getRespuesta());
            b1.setText(Integer.toString(val+2));
            b1.addActionListener(ActionsListener.ActionOpciones(null));
            
            b2.setText(Integer.toString(val-1));
            b2.addActionListener(ActionsListener.ActionOpciones(null));
            
            b3.setText(Integer.toString(val));
            b3.addActionListener(ActionsListener.ActionOpciones(null));
        }
        
        PN_OpcionesEjer.add(b1);
        PN_OpcionesEjer.add(b2);
        PN_OpcionesEjer.add(b3);
  
           //reset to default
    
        ConstraintConfig(2,2,true,false);
        
        seguir.addActionListener(ActionsListener.ActionSalir(null));
        
        PN_Ejercicio.add(salir,GridBC);
        ConstraintConfig(1,2,true,false);
        PN_Ejercicio.add(PN_OpcionesEjer,GridBC);
        ConstraintConfig(0,2,true,false);
        PN_Ejercicio.add(seguir,GridBC);
            
            
        GridBC.weighty=1.0;
        GridBC.gridwidth=3;
        GridBC.gridheight=GridBagConstraints.RELATIVE;
        ConstraintConfig(0,1,false,false);
        
        contenido.setText(ejc.getEjercicio());
        contenido.setEnabled(false);
        SP_Contenido=new JScrollPane(contenido);
        
        
        SP_Contenido.setOpaque(false);
        PN_Ejercicio.add(SP_Contenido,GridBC);
        return PN_Ejercicio;
    }
}
