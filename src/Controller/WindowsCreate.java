/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.BotonRecrea;
import Componentes.BotonSalirRecrea;
import Componentes.LabelRecrea;
import Componentes.PanelRecrea;
import Contrato.ContratoBotones;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

public class WindowsCreate extends JPanel {
    private final JButton []BT_Botones;//arreglo de botones
    private final JLabel []LB_Materias;// Se agregan los Label asociados a los botones, al boton[i] le corresponde el Label[i]
    private PanelRecrea PN_Materia;
    //private final String LetrasTamaño;
    //private final String LetrasColor;
    private final PanelRecrea PN_Botones ;
    private BotonRecrea boton ;
    private final ContratoBotones ctoGen;//contrato general de la interfaz que se le añadira 
    private final BotonSalirRecrea salir;
    private final PanelRecrea PanelGeneral;//panel donde se agregar todas los componenetes y al final el boton de salir si es el caso 
    private GridBagLayout GridBL;
    private final GridBagConstraints GridBC ;

    public WindowsCreate(int MateriasCont,ContratoBotones ctoGeneral){
        ctoGen=ctoGeneral;
        salir=new BotonSalirRecrea(ctoGeneral,false);
        BT_Botones = new JButton[MateriasCont];
        LB_Materias=new JLabel[MateriasCont];
        GridBL=new GridBagLayout();
        GridBC=new GridBagConstraints();
        PanelGeneral=new PanelRecrea(GridBL);
        //Se crea el panel con un GridBagLayout lo que permite modificar
        //el espacio para los componentes
        this.configuracionGridContraint();
        PN_Botones= new PanelRecrea(new GridLayout((MateriasCont/3)+1, 3,10,10));
    }
    



    /***
     * metodo donde se encontrara el jpanel que contiene los botones
     * @param materias Materias que se cargaran en el tablero
     * @param PN_BTN
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
        this.PanelGeneral.add(PN_Botones,GridBC);
        return PanelGeneral;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
 
      /***
     * metodo donde se encontrara el jpanel que contiene los botones
     * @param lecciones
     * @param PN_BTN
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
        
        
       this.PanelGeneral.add(PN_Botones,GridBC);
       GridBC.gridy=1;//se agregarña en  la fila de la posicion 1
       this.PanelGeneral.add(salir,GridBC);
       return PanelGeneral;
        }
        catch(Exception ex){
            System.out.println("Exepcion encontrada en: "+ex);
            return null;
        }
    }
     
     private void configuracionGridContraint(){
        GridBC.ipady = 0; 
        GridBC.insets = new Insets(0,10,0,10);  //top padding
        GridBC.weightx = 0.5;
        GridBC.weighty = 0;
        GridBC.fill=GridBagConstraints.HORIZONTAL;//se ajusta horizontalmente
        GridBC.gridy=0;
        GridBC.gridx=0;
     }
     
     
    
    
   
}

