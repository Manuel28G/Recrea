/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import Contrato.ContratoGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manuel
 */
public class ActionsListener {
 
   
   /**
    * 
    * @param Ej
    * @return 
    */ 
  public static ActionListener ActionOpciones (final ContratoGeneral cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.actionOpciones(e);
            }
        };  
  }
   /**
    * 
    * @param Ej
    * @return 
    */ 
  public static ActionListener ActionSiguiente (final ContratoGeneral cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.actionSiguiente(e);
            }
        };  
  }
   /**
    * 
    * @param Ej
    * @return 
    */ 
  public static ActionListener ActionSalir (final ContratoGeneral cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.actionSalir(e);
            }
        };  
  }
   /**
    * 
    * @param Ej
    * @return 
    */ 
  public static ActionListener ActionSonido (final ContratoGeneral cntGen)  {
     return new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cntGen.actionSonido(e);
            }
        };  
  }

}
