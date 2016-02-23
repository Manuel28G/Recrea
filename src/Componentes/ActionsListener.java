/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoBotones;
import Contrato.ContratoGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manuel
 */
public class ActionsListener {
 
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

}
