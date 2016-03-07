/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Objetos.Ejercicio;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.SwingConstants;
import Componentes.ActionsListener;
import Componentes.BotonRecrea;
import Componentes.BotonSalirRecrea;
import Componentes.BotonSeguirRecrea;
import Componentes.Configuracion;
import Componentes.LabelRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.PanelRecrea;
import Componentes.ScrollPaneRecrea;
import Componentes.TAreaRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Contrato.ContratoBotones;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * se creara la ventan de ejercicios
 * @author Manuel
 */
public class WindowsEjercicio {
    
    private final GridBagLayout GridBL=new GridBagLayout();
    private final GridLayout GridL1y3x= new GridLayout(1,3,10,10);
    
    private final Border blackline = BorderFactory.createLineBorder(Color.white,2);
    private final Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    
   // private final LabelRecrea lb=new LabelRecrea();
    private final Configuracion config =new Configuracion();
    private final  Border bordeRespuesta=BorderFactory.createTitledBorder(loweredbevel,"Respuesta",TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
    private final Border bordePregunta= BorderFactory.createTitledBorder( blackline, "Pregunta",TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));

    
    private final PanelRecrea PN_Ejercicio= new PanelRecrea(GridBL);
    private final PanelRecrea PN_OpcionesEjer=new PanelRecrea(GridL1y3x);
    
    private Component compResp;
    
    private LabelRecrea a1= new LabelRecrea(),a2= new LabelRecrea(),a3= new LabelRecrea(),b= new LabelRecrea(),c1= new LabelRecrea(),c2= new LabelRecrea(),c3= new LabelRecrea();
    //private PanelRecrea respuesta=new PanelRecrea();
    private TAreaRecrea contenido=new TAreaRecrea();
    private final BotonSeguirRecrea seguir;
    private final BotonSalirRecrea salir;
    
    private final GridBagConstraints GridBC ;
    private final ContratoBotones ctoEjercicio;
    
    private BotonRecrea b1, b2, b3;
    private Random rm;
    private BotonRecrea sonidoBt;
    
    public Component getComponenteRespuesta(){
        return compResp;
    }
    public List<BotonRecrea> getBotones(){
      List<BotonRecrea> lsBtones=  new ArrayList<BotonRecrea>();
      lsBtones.add(b1);
      lsBtones.add(b2);
      lsBtones.add(b3);
        return lsBtones;
    }

    
    public  WindowsEjercicio(ContratoBotones ctoGen){
        ctoEjercicio=ctoGen;
        seguir=new BotonSeguirRecrea(ctoEjercicio);
        salir=new BotonSalirRecrea(ctoEjercicio,true);
        PN_Ejercicio.setLayout(GridBL);
        GridBC = new GridBagConstraints();
        rm=new Random();
        GridBC.ipady = 0; 
        GridBC.insets = new Insets(0,10,0,10);  //top padding
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
    public PanelRecrea ConfigurarWindows(Ejercicio ejc,String CantEjer,String persona){

        a1.setText(CantEjer);
        a1.setHorizontalAlignment(SwingConstants.LEFT);
        

        a2.setText(persona);
        a2.setHorizontalAlignment(SwingConstants.CENTER);
        
        sonidoBt=new BotonRecrea(Util.BOTON_TIPO_SONIDO,this.ctoEjercicio);
        sonidoBt.BotonConfig("sonido.png", Util.BOTON_TIPO_SONIDO, 0, 0);
        
        configGeneral();
        
   
        GridBC.gridwidth=3;
        
        configRespuesta(ejc, PN_OpcionesEjer);
        configContenido(ejc);
        return PN_Ejercicio;
    }
    
    private void configGeneral(){
        
        ConstraintConfig(0,0,true,true);
        PN_Ejercicio.add(a1,GridBC);
        
        ConstraintConfig(1,0,true,true);
        PN_Ejercicio.add(a2,GridBC);
        
        ConstraintConfig(2,0,true,true);
        PN_Ejercicio.add(sonidoBt,GridBC);
        
        ConstraintConfig(0,3,true,false);
        PN_Ejercicio.add(salir,GridBC);
        
        ConstraintConfig(1,3,true,false);
        PN_Ejercicio.add(new PanelRecrea(),GridBC);
        
        ConstraintConfig(2,3,true,false);
        PN_Ejercicio.add(seguir,GridBC);
        
    }
    
    private void configContenido(Ejercicio ejc){
        ConstraintConfig(0,1,false,false);
        GridBC.weighty=1;
        ScrollPaneRecrea sp=new ScrollPaneRecrea();
        contenido.SetConfigText();
        contenido.setText(ejc.getEjercicio());
        contenido.setEditable(false);
        contenido.setEnabled(true);
        sp.add(contenido);
        sp.setViewportView(contenido);
        sp.getViewport().setOpaque(false);
        sp.setBorder(bordePregunta);
        
        PN_Ejercicio.add(sp,GridBC);
        
        sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum());
    }
    
    /***
     * 
     * @param ejc
     * @param panel 
     */
    private void configRespuesta(Ejercicio ejc,PanelRecrea panel){
        ConstraintConfig(0,2,true,false);    
        String[] resp=ejc.getTipo().split(":");
        PN_OpcionesEjer.setBorder(bordeRespuesta);
        switch(resp[0]){
            case Util.EJERCICIO_TIPO_BOTON:RespBotones(ejc,panel,resp[1]); break;
            case Util.EJERCICIO_TIPO_ESCRIBIR:RespTextField(ejc,panel,resp[1]); break;
            case Util.EJERCICIO_TIPO_VF:RespVF(ejc,panel);break;
        }
    }
    /**
     * Metodo para crear los botones en la zona de respuesta
     * @param ejc el Objeto ejercicio
     * @param panel el panel contenedor que se colocará en la zona de resp.
     * @param tipoBoton cn esto sabremos el tipo de boton(Letras,Números)
     */
    private void RespBotones(Ejercicio ejc, PanelRecrea panel,String tipoBoton){
            b1=new BotonRecrea(Util.BOTON_TIPO_OPCION,ctoEjercicio);
            b2=new BotonRecrea(Util.BOTON_TIPO_OPCION,ctoEjercicio);
            b3=new BotonRecrea(Util.BOTON_TIPO_OPCION,ctoEjercicio);
   
            int val=Integer.parseInt(ejc.getRespuesta());
            b1.addActionListener(ActionsListener.ActionOpciones(ctoEjercicio));
            b2.addActionListener(ActionsListener.ActionOpciones(ctoEjercicio));
            b3.addActionListener(ActionsListener.ActionOpciones(ctoEjercicio));
            
            this.valorRespuesta(b1, b2, b3, val);
            
            //agregamos de manera aleatoria la respuesta correcta
            int random=(int)(rm.nextDouble() * 2 + 0);//con esto tenemos un rango del random del [0,2]
            switch (random){
                case 0: panel=agregarBotones(b1,b3,b2,panel); break;
                case 1: panel=agregarBotones(b2,b1,b3,panel); break;
                case 2: panel=agregarBotones(b3,b2,b1,panel); break;
            }
            
            PN_Ejercicio.add(panel,GridBC); 
            PN_Ejercicio.compEnUso=panel;
            this.compResp=new BotonRecrea();
    }
    
    private PanelRecrea agregarBotones(BotonRecrea b1,BotonRecrea b2,BotonRecrea b3,PanelRecrea panel){
        
       panel.add(b1);
       panel.add(b2);
       panel.add(b3);
       return panel;
    }
    
    private void valorRespuesta(BotonRecrea b1,BotonRecrea b2,BotonRecrea b3,int resp){
        b1.setText(Integer.toString(resp));
        b1.setName(Integer.toString(resp));
        int random;
        if(resp%10==0){
            random=(int)(rm.nextDouble() * 4 + 1);//con esto tenemos un rango del random del [1,4]
            b3.setText(Integer.toString(resp-10));
            b2.setText(Integer.toString(resp*random));
            b3.setName(Integer.toString(resp-10));
            b2.setName(Integer.toString(resp*random));
        }else
            if(resp%2==0){

                random=(int)(rm.nextDouble() * 5 +1);//con esto tenemos un rango del random del [1,5]
                b2.setText(Integer.toString(resp/2));
                b3.setText(Integer.toString(resp+random));
                b2.setName(Integer.toString(resp/2));
                b3.setName(Integer.toString(resp+random));
            }else
                if(resp%5==0){
                     random=(int)(rm.nextDouble() * 3 + 1);//con esto tenemos un rango del random del [1,3]
                    b2.setText(Integer.toString(resp*random));
                    b3.setText(Integer.toString(resp + 5));
                    b2.setName(Integer.toString(resp*random));
                    b3.setName(Integer.toString(resp + 5));
                }
                    else
                    {
                    random=(int)(rm.nextDouble() * 25 + 1);//con esto tenemos un rango del random del [1,25]
                    b3.setText(Integer.toString(resp+random));
                    random=(int)(rm.nextDouble() * (resp-1) + 1);//con esto tenemos un rango del random del [1,resp-1]
                    b2.setText(Integer.toString(resp-random));
                    b2.setName(Integer.toString(resp-random));
                    b3.setName(Integer.toString(resp+random));
                    }
    }
  
    /**
     *   Metodo para crear las opciones V o F en la zona de respuesta  
     * @param ejc el Objeto ejercicio
     * @param panel el panel contenedor que se colocará en la zona de resp.
     */
    private void RespVF(Ejercicio ejc,PanelRecrea panel){
        VFRecrea vfRecrea=new VFRecrea();
        vfRecrea.SetConfig();
        panel.add(vfRecrea);
        PN_Ejercicio.add(panel,GridBC); 
        PN_Ejercicio.compEnUso=vfRecrea;
        
        compResp=vfRecrea;//agregamos el VFRecrea al at que se pasara a la ventana "Practica"
    }
    
    /**
     *  Metodo para crear los cuadro de texto en la zona de respuesta
     * @param ejc el Objeto ejercicio
     * @param panel el panel contenedor que se colocará en la zona de resp.
     * @param tipoBoton cn esto sabremos el tipo de TextField(Letras,Números)
     */
    private void RespTextField(Ejercicio ejc,PanelRecrea panel,String tipoTF){
        
        if(Util.EJERCICIO_TIPO_RESP_NUMERO.equals(tipoTF)){
            NumberBoxRecrea nbRecrea=new NumberBoxRecrea();
            nbRecrea.setHorizontalAlignment(NumberBoxRecrea.CENTER);
            panel.add(nbRecrea); 
            PN_Ejercicio.compEnUso=nbRecrea;
            
            compResp=nbRecrea;//agregamos el NumberBox al at que se pasara a la ventana "Practica"
        }
        else
        if(Util.EJERCICIO_TIPO_RESP_LETRA.equals(tipoTF))
        {
            TextBoxRecrea tbRecrea=new TextBoxRecrea();
            tbRecrea.setHorizontalAlignment(TextBoxRecrea.CENTER);
            panel.add(tbRecrea);
            PN_Ejercicio.compEnUso=tbRecrea;
            
            compResp=tbRecrea;//agregamos el TextBox al at que se pasara a la ventana "Practica"
        }
        
            PN_Ejercicio.add(panel,GridBC);
    }
}
