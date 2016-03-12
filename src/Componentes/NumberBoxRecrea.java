/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import javax.swing.JTextField;

/**
 * Clase que define un componente de entrada de puro número
 * @author Manuel Goncalves L.
 */
public class NumberBoxRecrea extends  JTextField{
    
    public NumberBoxRecrea(){
        
        this.addKeyListener(Componentes.ActionsListener.ActionNumberBox(this));
    }
}
