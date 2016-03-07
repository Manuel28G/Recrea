/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import Contrato.ContratoGeneral;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.jdom2.JDOMException;
/**
 *
 * @author Manuel Goncalves L.
 */
public class MenuBarRecrea extends JMenuBar{

    private JMenu menu;
    private JMenuItem menuItem;
    private JMenu subMenu;
    private String[][] opcSub;
    private ContratoGeneral contGen;
    
    public MenuBarRecrea() throws JDOMException{
      super.removeAll();
      menuRecrea();
    }
    public MenuBarRecrea(ContratoGeneral cont){
      super.removeAll();
      contGen=cont;
      menuRecrea();
    }
    public void setContrato(ContratoGeneral cont){
        contGen=cont;
    }
    
    
    private void menuRecrea(){
        opcSub=new String[][]{{"Cargar Materias"},
                           {"Guardar Materias"}};
        CrearMenu("Archivo",opcSub);
        opcSub=new String[][]{{"Agregar","Materia","Leccion","Ejercicio"},
               {"Modificar","Materia","Leccion","Ejercicio"},
               {"Eliminar","Materia","Leccion","Ejercicio"}};
        CrearMenu("Edición",opcSub);
        opcSub=new String[][]{{"Avance"}};
        CrearMenu("Vista",opcSub);
        opcSub=new String[][]{};
        CrearMenu("Ayuda",opcSub);
    }
    
    private void CrearMenu(String nombre, String[][] subOpciones){
      menu=new JMenu(nombre); 
     // menu.setMnemonic(KeyEvent.VK_A);//atajo de teclado alt + A
      for(String[] sOpciones:subOpciones){
          if(sOpciones.length>1)
            SubMenuOpciones(menu,sOpciones[0],sOpciones);
          else
            SubMenu(menu,sOpciones[0]);
      }
     this.add(menu);
    }
    /**
     * 
     * @param menu
     * @param nombre 
     */
    private void SubMenu(JMenu menu,String nombre){
        menu.addSeparator();
        menuItem=new JMenuItem(nombre);
        menuItem.addActionListener(ActionsLis(nombre));
        menu.add(menuItem);
    }
    /**
     * 
     * @param menu
     * @param nombre
     * @param opciones 
     */
    private void SubMenuOpciones(JMenu menu,String nombre,String[] opciones){
            menu.addSeparator();
            subMenu = new JMenu(nombre);
            subMenu.setMnemonic(KeyEvent.VK_S);
            Boolean primero=true; //Boolean para no tomar el nombre del menu en los subMenu 
            for(String subOpcion: opciones ){
                if(!primero)
                {
                subMenu.addSeparator();
                menuItem = new JMenuItem(subOpcion);
                menuItem.addActionListener(ActionsLis(nombre+subOpcion));
//                menuItem.addActionListener();
               /* menuItem.setAccelerator(KeyStroke.getKeyStroke(  //Atajo de teclado
                        KeyEvent.VK_2, ActionEvent.ALT_MASK));*/// idear buenas convinaciones
                subMenu.add(menuItem);
                }
                else
                 primero=!primero;
            }
        
        menu.add(subMenu);
    }
        
  private ActionListener ActionsLis(String nombreMenu){
      switch(nombreMenu)
      {
          case "Cargar Materias":return Componentes.ActionsListener.ActionCargarXML(); 
          case "Guardar Materias":return Componentes.ActionsListener.ActionGuardarXML();
          case "Agregar"+"Materia":return Componentes.ActionsListener.ActionAgregarMateria();
          case "Agregar"+"Leccion":return Componentes.ActionsListener.ActionAgregarLeccion();
          case "Agregar"+"Ejercicio":return Componentes.ActionsListener.ActionAgregarEjercicio();
              
              
          case "Avance": return Componentes.ActionsListener.ActionCargarAvance(contGen);
       
      }
         return null;
  }





    
}

