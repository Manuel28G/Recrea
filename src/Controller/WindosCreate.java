/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import View.Modulos;
import View.Inicio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jdom2.JDOMException;

/**
 *
 * @author Manuel
 */

public class WindosCreate extends JPanel {
    private JButton JB1;
    private int MateriasCont;
    private JButton []BT_Botones;//arreglo de botones
    private JButton BT_BotonReg;
    private JLabel []LB_Materias;// Se agregan los Label asociados a los botones, al boton[i] le corresponde el Label[i]
    private JPanel PN_Materia;
    private ActionListener ActList;
    //Marcos que simulan los bordes de la pizarra
    private JPanel Marco=new JPanel();
    private JPanel Marco2=new JPanel();
    private JPanel Marco3=new JPanel();
    private JPanel Marco4=new JPanel(); 
    private String LetrasTamaño;
    private String LetrasColor;
    private JPanel PN_Botones ;
    private List<Materia> materias;
    private List<Ejercicio> ejercicios;


    public WindosCreate(int MateriasCont){
        BT_Botones = new JButton[MateriasCont];
        LB_Materias=new JLabel[MateriasCont];
        //Configuracion
        LetrasTamaño="GRANDE";
        LetrasColor="BLANCO";
        //Fin configuracion
        PN_Botones= new JPanel(new GridLayout(10, 3,10,10)){
           @Override
         public void paintComponent(Graphics g)
            { 
              Image imagenFondo=new ImageIcon(Util.IMAGE_PATH+"Pizarra.png").getImage();
             g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);

            }
       };
    }
    

    /***
     * El action listener para los botones de la clase Modulos
     * @param Md 
     */
    public void WindowsHijo(final Modulos Md){
      ActList=new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    Md.actionPerformed(e);
                } catch (JDOMException ex) {
                    Logger.getLogger(WindosCreate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          
        };  
      
    }
    /**
     * El action listener para los botones de la clase Inicio
     * @param Pc 
     */
    public void WindowsHijo(final Inicio Pc){
     ActList=new ActionListener() 
        {
            @Override
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
     * @param materias Materias que se cargaran en el tablero
     * @param PN_Botones Panel que se llenará con los botones
     * @return  Panel lleno con los botones correspondientes
     */
     public  JPanel mostrarBot(List<Materia> materias,JPanel PN_BTN){
     
        try{
         int i=0;
        for(Materia mt:materias){//ciclo para crear, añadir, establecer propiedades a los botones
            BT_Botones[i] =Botones(mt.getImagenURL(),mt.getNombre(),50,50);
            //LB_Materias[i] = new JLabel(mt.getNombre());
            LB_Materias[i]=Texto(mt.getNombre(),LetrasTamaño,LetrasColor);
            LB_Materias[i].setHorizontalAlignment(0);
            PN_Materia = new JPanel(new GridLayout(2,1))
            {
              @Override
              public void paintComponent(Graphics g)
                 { 
                   Image imagenFondo=new ImageIcon(Util.IMAGE_PATH+"Pizarra.png").getImage();
                  g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);

                 }
            }; 
            PN_Materia.add(BT_Botones[i]);
            PN_Materia.add(LB_Materias[i]);
            PN_Materia.setBorder(new EmptyBorder(0, 0, 0, 0));
            PN_Botones.add(PN_Materia);
            i++;

           
        }//fin ciclo
        return PN_Botones;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
 
      /***
     * metodo donde se encontrara el jpanel que contiene los botones
     * @param materias Materias que se cargaran en el tablero
     * @param PN_Botones Panel que se llenará con los botones
     * @return  Panel lleno con los botones correspondientes
     */
     public  JPanel mostrarBotEj(List<Leccion> lecciones,JPanel PN_BTN){
        try{
         int i=0;
        for(Leccion mt:lecciones){//ciclo para crear, añadir, establecer propiedades a los botones
            BT_Botones[i] =Botones(mt.getImagenURL(),mt.getNombre(),50,50);
            LB_Materias[i] =Texto(mt.getNombre(),LetrasTamaño,LetrasColor);
            System.out.println(mt.getNombre());
            LB_Materias[i].setHorizontalAlignment(SwingConstants.CENTER);
            PN_Materia = new JPanel(new GridLayout(2,1))
            {
              @Override
              public void paintComponent(Graphics g)
                 { 
                   Image imagenFondo=new ImageIcon(Util.IMAGE_PATH+"Pizarra.jpg").getImage();
                  g.drawImage(imagenFondo, 0,0,getWidth(),getHeight(),null);

                 }
            };
            PN_Materia.add(BT_Botones[i]);
            PN_Materia.add(LB_Materias[i]);
            PN_Materia.setBorder(new EmptyBorder(0, 0, 0, 0));
            PN_Botones.add(PN_Materia);
            i++;

           
        }//fin ciclo
        
       BT_BotonReg=Botones("Regresar.png","Regresar",50,50);
       PN_Botones.add(BT_BotonReg);
        return PN_Botones;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
    
     
    /**
     * Se creará el texto de acuerdo a cierta configuracion
     * @param mensaje Mensaje añadido al Jlabel
     * @param tamaño "GRANDE,MEDIADO,PEQUEÑO"
     * @param color "NEGRO,ROJO,AZUL,VERDE"
     * @return 
     */
     private JLabel Texto(String mensaje,String tamaño,String color){
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
         texto.setForeground(Color.BLACK); break;
             case "ROJO":
         texto.setForeground(Color.RED); break;
             case "AZUL":
         texto.setForeground(Color.BLUE); break;  
             case "BLANCO": 
         texto.setForeground(Color.WHITE);break;
            
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
    private JButton Botones(String img,String name,int x,int y){
        ImageIcon imagen=new ImageIcon(Util.IMAGE_PATH+img);
        JButton Bt=new JButton(imagen);
        Bt.setActionCommand(name);
        Bt.setSize(x, y);
        Bt.setName(name);
        Bt.addActionListener(ActList);
        Bt.setBorder(BorderFactory.createEmptyBorder());
        Bt.setContentAreaFilled(false);
        //Bt.setBorderPainted(false);
        Bt.setFocusPainted(false);
        Bt.setMargin(new Insets(0, 0, 0, 0));//(int top, int left, int bottom, int right)
        Bt.addMouseListener(null);
        Bt.setRolloverIcon(new ImageIcon(Util.IMAGE_PATH+"Resaltar"+img)); 
        return Bt;
    }

    
   
}

