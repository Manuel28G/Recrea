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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Manuel
 */
public class ActionsListener {
 
  
    private static final Validaciones valid= new Validaciones();
    
 ///Action Botones
   /**
    * 
    * @param Ej
    * @return 
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
    * 
    * @param Ej
    * @return 
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
    * 
    * @param Ej
    * @return 
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
    * 
    * @param Ej
    * @return 
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

   public static ActionListener ActionAgregarMateria (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                View.AgregarMateria nuevaMat=new View.AgregarMateria(contGen);
                nuevaMat.setVisible(true);
            }
        };  
  }  
    
   public static ActionListener ActionAgregarLeccion (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                View.AgregarLeccion nuevaLec=new View.AgregarLeccion();
                nuevaLec.setVisible(true);
            }
        };  
  }  
      
   public static ActionListener ActionAgregarEjercicio (final ContratoGeneral contGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                View.AgregarEjercicio nuevaEjer=new View.AgregarEjercicio();
                nuevaEjer.setVisible(true);
            }
        };  
  }  
        
   public static ActionListener ActionAvance ()  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        };  
  }  
  
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
            catch(Exception ex){}
            }
        };  
  } 
   //Fin TextBox
   
   //NumberBox
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
            catch(Exception ex){}
            }
        };  
  } 
   //FinNumberBox

}
