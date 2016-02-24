/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
/**
 *
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
