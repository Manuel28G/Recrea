/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import Model.Objetos.EntidadGeneral;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
/**
 * Clase que define el componente Combo Box en la aplicación
 * @author Manuel Goncalves L.
 */
public final class ComboBoxRecrea extends JComboBox {
    private List<EntidadGeneral> entidades =new ArrayList<>();
    private String selecNombre ="";  
    private EntidadGeneral eG=new EntidadGeneral();
    public ComboBoxRecrea(){
        
    }
    
    public ComboBoxRecrea(String texto){
        eG.setNombre(texto);
        this.AddItemRecrea(eG);
    }
    /**
     * Metodo para agregar una EntidadGeneral en el ComboBoxRecrea
     * @param entidad Entidad a agregar 
     */
    public void AddItemRecrea(EntidadGeneral entidad){
        try{
        entidades.add(entidad);
        this.addItem(entidad.getNombre());}
        catch(Exception e){
            System.out.println("Error en ComboBoxRecrea additem: "+e);
        }
    }
    /**
     * Metodo para obtener el objeto seleccionado en el ComboBoxRecrea
     * @return null: si no se consiguio el objeto, de lo contrario retorna EntidadGeneral
     */
    public EntidadGeneral GetItemRecrea(){
      selecNombre= this.getSelectedItem().toString();
      for(EntidadGeneral eg:entidades){
          if(eg.getNombre().equals(selecNombre))
              return eg;
      }
      return null;
    }
    /**
     * Metodo para remover todo el contenido en el comboBoxRecrea
     */
    public void RemoveAllRecrea(){
        
        entidades=new ArrayList<>();
        selecNombre="";
        eG=new EntidadGeneral();
        System.out.println(this.getItemCount());
        this.removeAllItems();
    }
}
