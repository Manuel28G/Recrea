/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Goncalves L.
 */
public class NumberBoxRecrea extends  JTextField{
    
    public NumberBoxRecrea(){
        
        this.addKeyListener(Componentes.ActionsListener.ActionNumberBox(this));
    }
}
