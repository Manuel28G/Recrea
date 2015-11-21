/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import View.Modulos;
import View.Practice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Manuel
 */

public class WindosCreate extends JPanel {
    JButton JB1;
    int MateriasCont;
    JButton []BT_Botones;//arreglo de botones
    JLabel []LB_Materias;// Se agregan los Label asociados a los botones, al boton[i] le corresponde el Label[i]
    JPanel PN_Materia;
    ActionListener ActList;
    //Marcos que simulan los bordes de la pizarra
    JPanel Marco=new JPanel();
    JPanel Marco2=new JPanel();
    JPanel Marco3=new JPanel();
    JPanel Marco4=new JPanel();


    public WindosCreate(String rutaArchivo){
        MateriasCont=Model.AccionXML.ContarEtiquetas(rutaArchivo);
        BT_Botones = new JButton[MateriasCont];
        LB_Materias=new JLabel[MateriasCont];
    }
    

    /***
     * El action listener para los botones de la clase Modulos
     * @param Md 
     */
    public void WindowsHijo(final Modulos Md){
      ActList=new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                Md.actionPerformed(e);
            }
        };  
        
    }
    /**
     * El action listener para los botones de la clase Practice
     * @param Pc 
     */
    public void WindowsHijo(final Practice Pc){
     ActList=new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                Pc.actionPerformed(e);
            }
        };  
        
    }
    
    /**
     * 
     * @param rutaArchivo La ruta del archivo que se leera
     * @param PN_Contenedor Panel que tendra la ventana 
     * @param tipo El tipo de contenido (etiqueta) que se leera
     * @return Panel lleno con todo los botones,TextBox etc
     */
    public JPanel AreaPractica(String rutaArchivo,JPanel PN_Contenedor,String tipo){
        
    return PN_Contenedor;
    }
    
    /***
     * metodo donde se encontrara el jpanel que contiene los botones
     * @param rutaArchivo Ruta del archivo que se accederá
     * @param PN_Botones Panel que se llenará con los botones
     * @return  Panel lleno con los botones correspondientes
     */
     public  JPanel mostrarBot(String rutaArchivo,JPanel PN_Botones){
      PN_Botones = new JPanel(new GridLayout(3, 3, 0, 10));
        //int cont=0;
       // boolean nt=true;
        try{
        for(int i=0; i<BT_Botones.length; i++){//ciclo para crear, añadir, establecer propiedades a los botones
            BT_Botones[i] =Botones(new ImageIcon(Util.IMAGE_CERO_PATH),Model.AccionXML.InformacionEtiqueta(rutaArchivo, null, i),50,50);
            LB_Materias[i] = new JLabel(Model.AccionXML.InformacionEtiqueta(rutaArchivo, null, i));
            LB_Materias[i].setHorizontalAlignment(SwingConstants.CENTER);
            PN_Materia = new JPanel(new GridLayout(2,1));
            PN_Materia.add(BT_Botones[i]);
            PN_Materia.add(LB_Materias[i]);
            PN_Materia.setBorder(new EmptyBorder(0, 0, 0, 0));
            PN_Botones.add(PN_Materia);
            //Color de fondo verde pizarron
            PN_Materia.setBackground(new Color(86,204,117));
            PN_Botones.setBackground(new Color(86,204,117));
       

           
        }//fin ciclo
        return PN_Botones;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
     /***
      * Se crea un TextBox/TextField con todas las configuraciones
      * @return 
      */
     public JTextField CajaDeTexto(){
         
     return null;
     }
    /**
     * Se creará el texto de acuerdo a cierta configuracion
     * @param mensaje Mensaje añadido al Jlabel
     * @param tamaño "GRANDE,MEDIADO,PEQUEÑO"
     * @param color "NEGRO,ROJO,AZUL,VERDE"
     * @return 
     */
     public JLabel Texto(String mensaje,String tamaño,String color){
         JLabel texto=new JLabel();
         int altura;
         int size=0;
         
         switch(tamaño){
             case "GRANDE":
                 size=24; break;
             case "MEDIANO": 
                 size=12;break;
             case "PEQUEÑO": 
                 size=6;break;
         }
         switch(color){
             case "NEGRO":
         texto.setBackground(Color.BLACK); break;
             case "ROJO":
         texto.setBackground(Color.RED); break;
             case "AZUL":
         texto.setBackground(Color.BLUE); break;  
             case "VERDE": 
         texto.setBackground(Color.GREEN);break;
            
         }
         
         texto.setFont(new java.awt.Font("Tahoma", 0, size)); 
         texto.setText(mensaje);
         return texto;
     }
     
     /**
      * 
      * @param img imagen del boton
      * @param name nombre del boton (programacion)
      * @param x  tamaño de anchura
      * @param y tamaño de altura
      * @return boton con las configuraciones necesarias
      */
    public JButton Botones(ImageIcon img,String name,int x,int y){
        JButton Bt=new JButton(img);
        Bt.setActionCommand(name);
        Bt.setSize(x, y);
        //this.add(Bt);
        //Bt.setLocation(PosX,PosY);
        Bt.setName(name);
        Bt.addActionListener(ActList);
        Bt.setBorder(BorderFactory.createEmptyBorder());
        Bt.setContentAreaFilled(false);
        //Bt.setBorderPainted(false);
        Bt.setFocusPainted(false);
        Bt.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        Bt.addMouseListener(null);
        //Bt.setRolloverIcon(new ImageIcon("src/View/Image/tiza.png")); para hacer efcto de resaltado
        return Bt;
    }

    
    
    private void add(JButton Bt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

