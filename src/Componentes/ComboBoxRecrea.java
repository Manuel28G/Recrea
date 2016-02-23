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
 *
 * @author Manuel Goncalves L.
 */
public class ComboBoxRecrea extends JComboBox {
    private List<EntidadGeneral> entidades =new ArrayList<EntidadGeneral>();
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
          if(eg.getNombre()==selecNombre)
              return eg;
      }
      return null;
    }
    
    public void RemoveAllRecrea(){
        
        entidades=new ArrayList<EntidadGeneral>();
        selecNombre="";
        eG=new EntidadGeneral();
        System.out.println(this.getItemCount());
        this.removeAllItems();
    }
}
