/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import javax.swing.JTextField;
/**
 * componente que limita la entrada de caracteres a puras letras
 * @author Manuel Goncalves L.
 */
public class TextBoxRecrea extends JTextField {
    
    
    public TextBoxRecrea(String str){
        super();
        super.setText(str);
        this.addKeyListener(Componentes.ActionsListener.ActionTextBox(this));
    }
    public TextBoxRecrea(){
        super();
        this.addKeyListener(Componentes.ActionsListener.ActionTextBox(this));
    }
    
    
   
 
}
