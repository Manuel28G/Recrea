/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Componentes.ComboBoxRecrea;
import Componentes.Configuracion;
import Componentes.NumberBoxRecrea;
import Componentes.TAreaRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Model.Objetos.Respuesta;
import java.awt.Component;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Goncalves L.
 */
public class Validaciones {
    //Longitud maxima para los TextBox Recrea
    public static int maxCaracteresTb;
    //Longitud máxima para los númberBox Recrea porque int solo reconoce 2^31
    public static int maxCaracteresNb; 
    private Pattern pt;
    private Matcher mt;
    private Configuracion config;
    private int totalPuntos; //para llevar el control de los puntos totales de un ejercicio
    private int totalPuntosObtenidos; //total que se obtuvo en un ejercicio
    
    public Validaciones(){
        totalPuntos=-1;
        totalPuntosObtenidos=-1;
        maxCaracteresNb=8;
        maxCaracteresTb=25;
    }
    
    public boolean longituMaxTextField(TextBoxRecrea tf){
        if(tf.getText().length()>maxCaracteresTb)
            return false;
        return true;
    }
    
    public boolean longituMaxTextField(NumberBoxRecrea tf){
        if(tf.getText().length()>maxCaracteresNb)
            return false;
        return true;
    }
 
    private Boolean ValidarComboBox(ComboBoxRecrea cb){
        if(cb.GetItemRecrea().getNombre().equals(Util.COMBOBOX_SELECCIONAR))
            return false;
        return true;
    }
    
    public boolean ValidarRespuestaVacia(Component cpnt){
     try{
       switch(cpnt.getClass().getSimpleName()){
           case "TextBoxRecrea": return this.ValidarTextField((TextBoxRecrea)cpnt);
           case "NumberBoxRecrea":return this.ValidarTextField((NumberBoxRecrea)cpnt);
           case "VFRecrea":return this.ValidarVFRecrea((VFRecrea)cpnt);
           case "TAreaRecrea":return this.ValidarTextArea((TAreaRecrea)cpnt);
           case "ComboBoxRecrea":return this.ValidarComboBox((ComboBoxRecrea)cpnt);
       }
     }catch(Exception ex){
     System.out.println(ex);
     System.out.println(ex.getStackTrace());
     System.out.println(cpnt);
     }
       return false;
    }
    
    private Boolean ValidarTextField(JTextField tb){
        
        pt=Pattern.compile(Util.EXPR_ENTEROyTEXTO);
        mt=pt.matcher(tb.getText());
        if(tb.getText().length()==0 || !mt.find())
            return false;
        return true;
    }
    
    private Boolean ValidarTextArea(TAreaRecrea ta){
        pt=Pattern.compile(Util.EXPR_ENTEROyTEXTO);
        mt=pt.matcher(ta.getText());
        if(ta.getText().length()==0 || !mt.find())
            return false;
        return true;
    }
    
    private Boolean ValidarVFRecrea(VFRecrea vfR){
        if(vfR.rbFalso.isSelected()|| vfR.rbVerdad.isSelected())
            return true;
        return false;
    }

    public int totalPuntos(List<Respuesta> result){
    if(this.totalPuntos<0){
        totalPuntosObtenidos=0;
        totalPuntos=0;
        for(Respuesta re:result){
            totalPuntosObtenidos+=re.GetPuntosObtenido();
            totalPuntos+=re.GetPuntoTotal();
        }
    }
    return totalPuntos;
    }
    
    public int totalPuntosObtenidos(List<Respuesta> result){
     if(this.totalPuntosObtenidos<0){
        totalPuntosObtenidos=0;
        totalPuntos=0;
        for(Respuesta re:result){
            totalPuntosObtenidos+=re.GetPuntosObtenido();
            this.totalPuntos+=re.GetPuntoTotal();
        }
       }
    return totalPuntosObtenidos;
    }
    
    public boolean EsCorrecta(String respReal,String respObt){
        int errores=0;
        respReal=respReal.trim();
        respObt=respObt.trim();
        if(respReal.toUpperCase().equals(respObt.toUpperCase()))
            return true;
        config=new Configuracion();
        if(respObt.length()>5){
            int i=0;
          for(i=0; (i<respObt.length()-1)&&(i<respReal.length()-1)&&errores<config.GetMaxErrores();i++)
                if(!respObt.substring(i, i+1).toUpperCase().equals(respReal.substring(i, i+1).toUpperCase()))
                    errores++;
          
          //si la respuesta correcta es menor en tamaño que la respesta hecha
          //se le agregara tanta cantidad de errores desde el contador hasta
          //la longitud de dicha cadena
          if(!(i<respReal.length()-1))
              errores+=(i-respObt.length()-1);
          
          if(errores<config.GetMaxErrores())
              return true;
          
        }
        return false;
    }


}
