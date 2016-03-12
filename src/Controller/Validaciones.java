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
    private Pattern pt;
    private Matcher mt;
    private Configuracion config;
    private int totalPuntos; //para llevar el control de los puntos totales de un ejercicio
    private int totalPuntosObtenidos; //total que se obtuvo en un ejercicio
    
    public Validaciones(){
        totalPuntos=-1;
        totalPuntosObtenidos=-1;
    }
    /**
     * Método para idetificar la longitud máxima permitida
     * @param tf Componente a examinar
     * @return true:esta dentro de la cantidad permitida; false:exedió los caracteres permitidos
     */
    public boolean longituMaxTextField(TextBoxRecrea tf){
        if(tf.getText().length()>Configuracion.maxCaracteresTb)
            return false;
        return true;
    }
        /**
     * Método para idetificar la longitud máxima permitida
     * @param tf Componente a examinar
     * @return true:esta dentro de la cantidad permitida; false:exedió los caracteres permitidos
     */
    public boolean longituMaxTextField(NumberBoxRecrea tf){
        if(tf.getText().length()>Configuracion.maxCaracteresNb)
            return false;
        return true;
    }
 
    /**
     * Método para validar si el comboBox se ha seleccionado algo
     * @param cb componente a examinar
     * @return true:se seleccionó algo; false: no se ha seleccionado nada
     */
    private Boolean ValidarComboBox(ComboBoxRecrea cb){
        if(cb.GetItemRecrea().getNombre().equals(Util.COMBOBOX_SELECCIONAR))
            return false;
        return true;
    }
    /**
     * Método para validar si ls respuesta esta vacia
     * @param cpnt componente a examinar
     * @return true:se ha respondido algo; False: no se ha respondido aun;
     */
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
     System.out.println("Error encontrado en validaciones.validarRespuestaVacia: ");
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
        if(vfR.rbFalso.isSelected()||vfR.rbVerdad.isSelected())
            return true;
        return false;
    }
/**
 * Método para obtener el total de puntos posibles en el ejercicio
 * @param result lista con los resultados realizados
 * @return cantidad de puntos totales
 */
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
    /**
 * Método para obtener el total de puntos obtenidos en el ejercicio
 * @param result lista con los resultados realizados
 * @return cantidad de puntos obtenidos
 */
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
    /**
     * Método para verificar si la respuesta esta correcta comparando de 
     * menera efectiva la respuesta realizada con la real permitiendo una
     * cantidad máxima de equivocaciónes de tipeo o diferencia entre mayúscula
     * y minúsculas.
     * @param respReal respuesta Verdadera
     * @param respObt respuesta realizada por el usuario
     * @return  true: la respuesta es correcta; false:respuesta es incorrecta.
     */
    public boolean EsCorrecta(String respReal,String respObt){
        int errores=0;
        respReal=respReal.trim();
        respObt=respObt.trim();
        if(respReal.toUpperCase().equals(respObt.toUpperCase()))
            return true;
        config=new Configuracion();
        if(respObt.length()>5){
            int i;
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
