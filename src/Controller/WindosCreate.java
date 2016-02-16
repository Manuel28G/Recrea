/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.BotonRecrea;
import Componentes.LabelRecrea;
import Componentes.PanelRecrea;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import Contrato.ContratoGeneral;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Manuel
 */

public class WindosCreate extends JPanel {
    private JButton []BT_Botones;//arreglo de botones
    private JButton BT_BotonReg;
    private JLabel []LB_Materias;// Se agregan los Label asociados a los botones, al boton[i] le corresponde el Label[i]
    private PanelRecrea PN_Materia;
    private String LetrasTamaño;
    private String LetrasColor;
    private PanelRecrea PN_Botones ;
    private BotonRecrea boton ;
    private ContratoGeneral ctoGen;


    public WindosCreate(int MateriasCont,ContratoGeneral ctoGeneral){
        ctoGen=ctoGeneral;
        BT_Botones = new JButton[MateriasCont];
        LB_Materias=new JLabel[MateriasCont];
        //Configuracion
        LetrasTamaño="GRANDE";
        LetrasColor="BLANCO";
        //Fin configuracion
        PN_Botones= new PanelRecrea(new GridLayout(5, 3,10,10));
    }
    



    /***
     * metodo donde se encontrara el jpanel que contiene los botones
     * @param materias Materias que se cargaran en el tablero
     * @param PN_Botones Panel que se llenará con los botones
     * @return  Panel lleno con los botones correspondientes
     */
     public  PanelRecrea mostrarBot(List<Materia> materias,JPanel PN_BTN){
     
        try{
         int i=0;
        for(Materia mt:materias){//ciclo para crear, añadir, establecer propiedades a los botones
            boton=new BotonRecrea("Opciones", ctoGen);
            BT_Botones[i] =boton.BotonConfig(mt.getImagenURL(),mt.getNombre(),50,50);
            //LB_Materias[i] = new JLabel(mt.getNombre());
            LB_Materias[i]=new LabelRecrea(mt.getNombre());
            LB_Materias[i].setHorizontalAlignment(0);
            PN_Materia = new PanelRecrea(new GridLayout(2,1));
           
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
     public  PanelRecrea mostrarBotEj(List<Leccion> lecciones,JPanel PN_BTN){
        try{
         int i=0;
        for(Leccion mt:lecciones){//ciclo para crear, añadir, establecer propiedades a los botones
            boton=new BotonRecrea("Opciones", ctoGen);
            BT_Botones[i] =boton.BotonConfig(mt.getImagenURL(),mt.getNombre(),50,50);
            LB_Materias[i] =new LabelRecrea(mt.getNombre());
            LB_Materias[i].setHorizontalAlignment(SwingConstants.CENTER);
            PN_Materia = new PanelRecrea(new GridLayout(2,1));
            PN_Materia.add(BT_Botones[i]);
            PN_Materia.add(LB_Materias[i]);
            PN_Materia.setBorder(new EmptyBorder(0, 0, 0, 0));
            PN_Botones.add(PN_Materia);
            i++;

           
        }//fin ciclo
        
       boton=new BotonRecrea("Regresar", ctoGen);
       BT_BotonReg=boton.BotonConfig("Regresar.png","Regresar",50,50);
       PN_Botones.add(BT_BotonReg);
        return PN_Botones;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
    
    
   
}

