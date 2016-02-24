/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.ComboBoxRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TAreaRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Goncalves L.
 */
public class Validaciones {
    
    public static int maxCaracteres=17;
    private Pattern pt;
    private Matcher mt;
    
    public Validaciones(){
        
    }
    public boolean longituMaxTextField(JTextField tf){
        if(tf.getText().length()>maxCaracteres)
            return false;
        return true;
    }
    
    //Validaciones View Agregar Ejercicio
    public Boolean ValidarComboBox(ComboBoxRecrea cb){
        if(cb.GetItemRecrea().getNombre().equals(Util.COMBOBOX_SELECCIONAR))
            return false;
        return true;
    }
    public boolean ValidarRespuesta(Component cpnt){
       switch(cpnt.getClass().getSimpleName()){
           case "TextBoxRecrea": return this.ValidarTextField((TextBoxRecrea)cpnt);
           case "NumberBoxRecrea":return this.ValidarTextField((NumberBoxRecrea)cpnt);
           case "VFRecrea":return this.ValidarVFRecrea((VFRecrea)cpnt);
       }
       return false;
    }
    public Boolean ValidarTextField(JTextField tb){
        
        pt=Pattern.compile(Util.EXPR_ENTEROyTEXTO);
        mt=pt.matcher(tb.getText());
        if(tb.getText().length()==0 || !mt.find())
            return false;
        return true;
    }
    public Boolean ValidarTextArea(TAreaRecrea ta){
        pt=Pattern.compile(Util.EXPR_ENTEROyTEXTO);
        mt=pt.matcher(ta.getText());
        if(ta.getText().length()==0 || !mt.find())
            return false;
        return true;
    }
    
    public Boolean ValidarVFRecrea(VFRecrea vfR){
        if(vfR.rbFalso.isSelected()|| vfR.rbVerdad.isSelected())
            return true;
        return false;
    }
    //Validaciones View Agregar Leccion
    public void ValidarAgregarLeccion(){
        
    }
    //Validaciones View Agregar Materia
    public void ValidarAgregarMateria(){
        
    }
    
    //Validaciones view Inicio
    
    //Validaciones view Modulos
    
    //Validaciones view Practica
}
