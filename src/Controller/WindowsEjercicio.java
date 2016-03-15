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
 * Clase para crear las ventanas de los ejercicios
 * @author Manuel Goncalves L.
 */
public class WindowsEjercicio {
    
    private final GridBagLayout GridBL=new GridBagLayout();
    private final GridLayout GridL1y3x= new GridLayout(1,3,10,10);
    
    private final Border blackline = BorderFactory.createLineBorder(Color.white,2);
    private final Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    private final Configuracion config =new Configuracion();
    private final  Border bordeRespuesta=BorderFactory.createTitledBorder(loweredbevel,Util.TITULO_RESPUESTA,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
    private Border bordePregunta= BorderFactory.createTitledBorder( blackline, Util.TITULO_PREG_CONTENIDO,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));

    private final PanelRecrea PN_Ejercicio= new PanelRecrea(GridBL);
    private final PanelRecrea PN_OpcionesEjer=new PanelRecrea(GridL1y3x);
    
    private Component compResp;
    
    private final LabelRecrea a1= new LabelRecrea(),a2= new LabelRecrea();
    private final TAreaRecrea contenido=new TAreaRecrea();
    private final BotonSeguirRecrea seguir;
    private final BotonSalirRecrea salir;
    
    private final GridBagConstraints GridBC ;
    private final ContratoBotones ctoEjercicio;
    
    private BotonRecrea b1, b2, b3;
    private final Random rm;
    private BotonRecrea sonidoBt;
    private final String sonidoImg="sonido.png";
    
    /**
     * Metodo para obtener el componente con la respuesta
     * @return Componente con la respuesta (Boton,TextBox, NumberBox, VF)
     */
    public Component getComponenteRespuesta(){
        return compResp;
    }
    /**
     * Método para obtener el listado con los botones de la respuesta
     * @return lista con botones de posibles respuesta
     */
    public List<BotonRecrea> getBotones(){
      List<BotonRecrea> lsBtones=  new ArrayList<>();
      lsBtones.add(b1);
      lsBtones.add(b2);
      lsBtones.add(b3);
        return lsBtones;
    }

    //CONFIGURACION DE LA VENTANA
    
    /**
     * Constructor
     * @param ctoGen Contrato general de la ventana donde se construira el ejercicio
     */
    public  WindowsEjercicio(ContratoBotones ctoGen){
        ctoEjercicio=ctoGen;
        seguir=new BotonSeguirRecrea(ctoEjercicio);
        salir=new BotonSalirRecrea(ctoEjercicio,true);
        PN_Ejercicio.setLayout(GridBL);
        GridBC = new GridBagConstraints();
        rm=new Random();
        GridBC.ipady = 0; 
        GridBC.insets = new Insets(0,10,0,10);  //Margenes (Arriba,izquierda,abajo,derecha)
        GridBC.weightx = 0.5;
        GridBC.weighty = 0;   //si requiere un espacio extra 
        
            }
    
    /**
     * Método para definir como se reajustara el componente y su posición 
     * @param PosX posición con respecto al eje X
     * @param PosY posición con respecto al eje Y
     * @param FHorizontal true: se ajustara horizontal; False: se ajustara en ambos sentidos
     * @param PageStart  True: se posicionará al inicio del recuadro; False: se posicionará al final del recuadro
     */
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
    
    /**
     * Método principal que realiza la configuración de la ventana
     * @param ejc ejercicio a mostrar
     * @param CantEjer Cantidad de ejercicios totales, para desplegar por pantalla
     * @param persona persona que realiza el ejercicio
     * @return PanelRecrea con la configuración de todos los componentes
     */
    public PanelRecrea ConfigurarWindows(Ejercicio ejc,String CantEjer,String persona){

        //texto que va en la esquina superior izquierda con la cantidad de ejer.
        a1.setText(CantEjer);
        a1.setHorizontalAlignment(SwingConstants.LEFT);
        
        //texto que va en el centro con el nombre de la persona.
        a2.setText(persona);
        a2.setHorizontalAlignment(SwingConstants.CENTER);
        
        sonidoBt=new BotonRecrea(Util.BOTON_TIPO_SONIDO,this.ctoEjercicio);
        sonidoBt.BotonConfig(sonidoImg, Util.BOTON_TIPO_SONIDO);
        
        configGeneral();
        
   
        GridBC.gridwidth=3;
        
        configRespuesta(ejc, PN_OpcionesEjer);
        configContenido(ejc);
        return PN_Ejercicio;
    }
    /**
     * Método que realiza la configuracion general para la ventana
     */
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
    /**
     * Método para la configuracion básica de los componentes
     * @param ejc ejercicio que se presentará por pantalla
     */
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
    
    //FIN DE CONFIGURACIÓN DE VENTANA
    
    
    /***
     * Método para la configuracion de la respuesta dependiendo al tipo
     * @param ejc ejercicio que se va a resolver
     * @param panel panel que contendrá los componentes para el ejercicio
     */
    private void configRespuesta(Ejercicio ejc,PanelRecrea panel){
        ConstraintConfig(0,2,true,false);    
        String[] resp=ejc.getTipo().split(":");
        PN_OpcionesEjer.setBorder(bordeRespuesta);
        switch(resp[0]){
            case Util.EJERCICIO_TIPO_BOTON:RespBotones(ejc,panel,resp[1]);
            bordePregunta= BorderFactory.createTitledBorder( blackline, Util.TITULO_PREG_BOTONES,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
            break;
            case Util.EJERCICIO_TIPO_ESCRIBIR:RespTextField(ejc,panel,resp[1]);
            tituloBorderEscribir(resp[1]);
            break;
            case Util.EJERCICIO_TIPO_VF:RespVF(ejc,panel);
            bordePregunta= BorderFactory.createTitledBorder( blackline, Util.TITULO_PREG_VERDADERO_FALSO,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
            break;
        }
    }
    
    private void tituloBorderEscribir(String tipo){
        switch(tipo){
            case Util.EJERCICIO_TIPO_RESP_LETRA:
                bordePregunta= BorderFactory.createTitledBorder( blackline, Util.TITULO_PREG_TEXTBOX_LETRAS,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
                break;
                
            case Util.EJERCICIO_TIPO_RESP_NUMERO:
                bordePregunta= BorderFactory.createTitledBorder( blackline, Util.TITULO_PREG_TEXTBOX_NUMEROS,TitledBorder.LEFT,TitledBorder.TOP,config.SetTamaño(Util.CONFIG_TAMAÑO_LETRA_INTERMED),config.SetColor(Util.CONFIG_COLOR_LETRA_BLANCO));
                break;
            
        }
        
    }
    /**
     * Metodo para crear los botones en la zona de respuesta
     * @param ejc el Objeto ejercicio
     * @param panel el panel contenedor que se colocará en la zona de resp.
     * @param tipoBoton cn esto sabremos el tipo de boton(Letras,Números): TOMAR EN CUENTA PARA FUTURO DESARROLLO
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
            int random=(int)(rm.nextDouble() * 3 + 0);//con esto tenemos un rango del random del [0,3]
            switch (random){
                case 0: panel=agregarBotones(b1,b3,b2,panel); break;
                case 1: panel=agregarBotones(b2,b1,b3,panel); break;
                case 2: panel=agregarBotones(b3,b2,b1,panel); break;
                case 3: panel=agregarBotones(b2,b3,b1,panel); break;
            }
            
            PN_Ejercicio.add(panel,GridBC); 
            PN_Ejercicio.compEnUso=panel;
            this.compResp=new BotonRecrea();
    }
    /**
     * Método para agregar los botones rotando la posición de los mismos 
     * dependiendo como se pase por parámetro
     * @param b1 BotonRecrea1
     * @param b2 BotonRecrea2
     * @param b3 BotonRecrea3
     * @param panel PanelRecrea donde se agregaran los botones
     * @return PanelRecrea que contiene los botones agregados
     */
    private PanelRecrea agregarBotones(BotonRecrea b1,BotonRecrea b2,BotonRecrea b3,PanelRecrea panel){
        
       panel.add(b1);
       panel.add(b2);
       panel.add(b3);
       return panel;
    }
    
    
    /**
     * Método para asignar los valores de manera aleatoria a las posibles respuestas
     * @param b1 boton que contendrá la respuesta correcta
     * @param b2 botonRecrea2
     * @param b3 botonRecrea3 
     * @param resp respuesta correcta al ejercicio
     */
    private void valorRespuesta(BotonRecrea b1,BotonRecrea b2,BotonRecrea b3,int resp){
        b1.setText(Integer.toString(resp));
        b1.setName(Integer.toString(resp));
        int random;
        
        
        if(resp==0){
            random=(int)(rm.nextDouble() * (5) + 1);//con esto tenemos un rango del random del [1,6]
            b2.setText(Integer.toString(random));
            b2.setName(Integer.toString(random));

            random=(int)(rm.nextDouble() * (10) + 10);//con esto tenemos un rango del random del [10,20]
            b3.setName(Integer.toString(random));            
            b3.setText(Integer.toString(random));
        }
        else
        if(resp%10==0){
            
            //se crean dos random ya que para la multiplicación no puede ser el rango desde uno 
            //porque daria habrían dos respuestas iguales
            random=(int)(rm.nextDouble() * 5 + 2);//con esto tenemos un rango del random del [2,7]
            b2.setName(Integer.toString(resp*random));
            b2.setText(Integer.toString(resp*random));   
            
            random=(int)(rm.nextDouble() * 4 + 1);//con esto tenemos un rango del random del [1,5]
            b3.setName(Integer.toString(resp-random));
            b3.setText(Integer.toString(resp-random));
        }else
            if(resp%2==0){

                random=(int)(rm.nextDouble() * 5 +1);//con esto tenemos un rango del random del [1,5]
                b2.setText(Integer.toString(resp/2));
                b3.setText(Integer.toString(resp+random));
                b2.setName(Integer.toString(resp/2));
                b3.setName(Integer.toString(resp+random));
            }else
                if(resp%5==0){
                    //se crean dos random ya que para la multiplicación no puede ser el rango desde uno 
                    //porque daria habrían dos respuestas iguales
                    random=(int)(rm.nextDouble() * 4 + 2);//con esto tenemos un rango del random del [2,4]
                    b2.setText(Integer.toString(resp*random));
                    b2.setName(Integer.toString(resp*random));
                    
                    random=(int)(rm.nextDouble() * 3 + 1);//con esto tenemos un rango del random del [1,3]

                    b3.setText(Integer.toString(resp + random));
                    b3.setName(Integer.toString(resp + random));
                }else
                    {
                    random=(int)(rm.nextDouble() * (resp-1) + 1);//con esto tenemos un rango del random del [1,resp-1]
                    b2.setText(Integer.toString(resp-random));
                    b2.setName(Integer.toString(resp-random));
                    b3.setName(Integer.toString(resp+random));            
                    b3.setText(Integer.toString(resp+random));
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
        switch(tipoTF){
            case Util.EJERCICIO_TIPO_RESP_NUMERO: 
                NumberBoxRecrea nbRecrea=new NumberBoxRecrea();
                nbRecrea.setHorizontalAlignment(NumberBoxRecrea.CENTER);
                panel.add(nbRecrea); 
                PN_Ejercicio.compEnUso=nbRecrea;
                compResp=nbRecrea;//agregamos el NumberBox al at que se pasara a la ventana "Practica"
                break;
            case Util.EJERCICIO_TIPO_RESP_LETRA: 
                TextBoxRecrea tbRecrea=new TextBoxRecrea();
                tbRecrea.setHorizontalAlignment(TextBoxRecrea.CENTER);
                panel.add(tbRecrea);
                PN_Ejercicio.compEnUso=tbRecrea;
                compResp=tbRecrea;//agregamos el TextBox al at que se pasara a la ventana "Practica"
                break;
            
        }
        
            PN_Ejercicio.add(panel,GridBC);
    }
}
