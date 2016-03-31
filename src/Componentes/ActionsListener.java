/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Contrato.ContratoGeneral;
import Controller.Util;
import Controller.Validaciones;
import Model.Objetos.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import View.Agregar.*;
import View.Eliminar.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que contiene las acciones correspondientes de cada componente
 * @author Manuel Goncalves L.
 */
public class ActionsListener {
 
  
    private static final Validaciones valid= new Validaciones();
    
  
    ///Action Botones
/**
 * Método para asociar las acciones de los botones con respecto al Mouse
 * en el mouseEntered se asocia el sonido para identificar cuando pase sobre un boton
 * en el mouseClicked se asocia el sonido para identificar cuando el usuario realiza el click sobre un componente
 * @return El MouseListener con todas las acciones asociadas
 * @throws IOException si no puede abrir el archivo de sonido 
 */
  public static MouseListener ActionSonidoBoton () throws IOException  {
     return new MouseListener() 
        {
            private Audio sonidoBoton;
            private Audio clicked;
            @Override
            public void mouseEntered(MouseEvent e)
            {
                
                try{
                sonidoBoton=new Audio(Util.RUTA_SONIDO_SOBREBOTON);
                sonidoBoton.Play();
                }catch(Exception ex){
                System.out.println("Error encontrado en reproducir sonido: "+ex);
                }
            }

                @Override
                public void mouseClicked(MouseEvent me) {
           
                }

                @Override
                public void mousePressed(MouseEvent me) {
                 try{
                    clicked=new Audio(Util.RUTA_SONIDO_CLICK);
                    clicked.Play();
                }
                catch(Exception ex){
                     System.out.println("Error encontrado en reproducir sonido CLICK: "+ex);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent me) { }

                @Override
                public void mouseExited(MouseEvent me) { }
            
        };  
  }
    

/**
 * Método que asocia el actionperfomed para los botones tipo OPCIONEs
 * @param cntGen contrato General de la interfaz
 * @return ActionListener 
 */
  public static ActionListener ActionOpciones (final ContratoBotones cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.ActionOpciones(e);
            }
        };  
  }
/**
 * Método que asocia el actionperfomed para los botones tipo SIGUIENTE
 * @param cntGen contrato General de la interfaz
 * @return ActionListener 
 */
  public static ActionListener ActionSiguiente (final ContratoBotones cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.ActionSiguiente(e);
            }
        };  
  }
/**
 * Método que asocia el actionperfomed para los botones tipo SALIR
 * @param cntGen contrato General de la interfaz
 * @return ActionListener 
 */
  public static ActionListener ActionSalir (final ContratoBotones cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.ActionSalir(e);
            }
        };  
  }
/**
 * Método que asocia el actionperfomed para los botones tipo SONIDO
 * @param cntGen contrato General de la interfaz
 * @return ActionListener 
 */
  public static ActionListener ActionSonido (final ContratoBotones cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.ActionSonido(e);
            }
        };  
  }
  ///FIN Action Botones
  
  ///Action MenuBar
  
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion CargarMateria
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionCargarXML ()  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Componentes.ImportarXMLDialog cargarXML=new Componentes.ImportarXMLDialog();
                cargarXML.Cargar();
                
            }
        };  
  }  
     
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion GuardarMateria
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionGuardarXML ()  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Componentes.ExportarXMLDialog guardarXML=new Componentes.ExportarXMLDialog();
                guardarXML.Guardar();
                
            }
        };  
  }  
  
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion Agregar Materia
 * @param cg contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionAgregarMateria (final ContratoGeneral cg)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AgregarMateria nuevaMat=new AgregarMateria(cg);
                nuevaMat.setVisible(true);
            }
        };  
  }  
      
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion Agregar Lección
 * @param cg contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionAgregarLeccion (final ContratoGeneral cg)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AgregarLeccion nuevaLec=new AgregarLeccion(cg);
                nuevaLec.setVisible(true);
            }
        };  
  }  
        
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion Agregar Ejercicio
 * @param cg contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionAgregarEjercicio (final ContratoGeneral cg)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e){
                AgregarEjercicio nuevaEjer=new AgregarEjercicio(cg);
                nuevaEjer.setVisible(true);
            }
        };  
  }  
       /**
 * Método que asocia el actionPerfomed al menuBar en la opcion de eliminar Usuario
 * @param contGen contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionEliminarUsuario (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                int resp= JOptionPane.showConfirmDialog(new JFrame(),Util.DIALOG_CONFIRMAR_ELIMINAR_USUARIO, Util.DIALOG_TITULO_MENSAJE, JOptionPane.YES_NO_OPTION);
                if(resp==JOptionPane.YES_OPTION){
                         Controller.ControllerEliminar eliminar=new Controller.ControllerEliminar();
                         eliminar.EliminarUsuario(null);
                         contGen.avisoMensaje(Util.MENSAJE_PERSONA_BORRADA);
                         contGen.Reaload();
                }
            }
        };  
  }  
         /**
 * Método que asocia el actionPerfomed al menuBar en la opcion de eliminar materia
 * @param contGen contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionEliminarMateria (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               EliminarMateria elimMat=new  EliminarMateria(contGen);
               elimMat.setVisible(true);
            }
        };  
  }  
         /**
 * Método que asocia el actionPerfomed al menuBar en la opcion de eliminar lección
 * @param contGen contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionEliminarLeccion (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                EliminarLeccion elimLecc=new EliminarLeccion(contGen);
                elimLecc.setVisible(true);
            }
        };  
  }  
         /**
 * Método que asocia el actionPerfomed al menuBar en la opcion de eliminar ejercicio
 * @param contGen contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionEliminarEjercicio (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                EliminarEjercicio elimEjer=new EliminarEjercicio(contGen);
                elimEjer.setVisible(true);
            }
        };  
  }  
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion Avance
 * donde se muestra el avance del alumno
 * @param pers contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
    public static ActionListener ActionCargarAvance (final ContratoGeneral pers)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Persona usr=pers.GetPersona();
               if(usr.getActividades().size()>0){
                View.Avance avance=new View.Avance(usr);
                avance.setVisible(true);}
               else
                   pers.avisoMensaje(Util.MENSAJE_NOHAYREGISTRO);
               //agregar alerta de que no hay actividades
            }
        };  
  }  
/**
 * Método recarga o actualiza el contenido luego de haber sido modificado
 * (agregar/modificar/eliminar alguna leccion materia o ejercicio)
 * @param cg contrato general del frame que se este ejecutando 
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionActualizarPagina (final ContratoGeneral cg)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cg.Reaload();
            }
        };  
  }  
    
    
/**
 * Método que asocia el actionPerfomed al menuBar en la opcion Ayuda
 * @return ActionListener con el ActionPerfomed asociado
 */
   public static ActionListener ActionAyuda ()  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        };  
  }  

  
  ///FIN MenuBar
   
   //TextBox
   
   /**
    * Método que asocia el keyTyped al TextBoxRecrea
    * con el cual se registra cada vez que se escribe un caracter en el 
    * componente
    * @param tb componente TextBoxRecrea 
    * @return KeyAdapter
    */
public static KeyAdapter ActionTextBox (final TextBoxRecrea tb)  {
     return new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
             try{
             Pattern pt=Pattern.compile(Util.EXPR_SOLOTEXTO);
             Matcher mt=pt.matcher(""+e.getKeyChar());
             if(!mt.find() || !valid.longituMaxTextField(tb)){
                 e.consume();
             }
             
            }
            catch(Exception ex){
            
            System.out.println("Error encontrado en ActionTextBox: "+ex);}
            }
        };  
  } 
   //Fin TextBox
   
   //NumberBox
   /**
    * Método que asocia el keyTyped al NumberBoxRecrea
    * con el cual se registra cada vez que se escribe un caracter en el 
    * componente
    * @param nb componente NumberBoxRecrea 
    * @return KeyAdapter
    */
   public static KeyAdapter ActionNumberBox(final NumberBoxRecrea nb)  {
     return new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
             try{
             Pattern pt=Pattern.compile(Util.EXPR_SOLOENTEROS);
             Matcher mt=pt.matcher(""+e.getKeyChar());
             if(!valid.longituMaxTextField(nb) || !mt.find()){
                 e.consume();
             }
             
            }
            catch(Exception ex){
            System.out.println("Error encontrado en ActionNumberbox: "+ex);
            }
            }
        };  
  } 
   //FinNumberBox


}
