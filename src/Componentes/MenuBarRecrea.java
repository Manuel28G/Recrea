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
    private final String materiaStr="Materia";
    private final String materiasStr="Materias";
    private final String leccionStr="Leccion";
    private final String ejercicioStr="Ejercicio";
    private final String vistaStr="Vista";
    private final String ayudaStr="Ayuda";
    private final String avanceStr="Avance";
    private final String espacioStr=" ";
    
    private final String cargarStr="Cargar";
    private final String guardarStr="Guardar";
    private final String archivoStr="Archivo";
    private final String agregarStr="Agregar";
    private final String modificarStr="Modificar";
    private final String eliminarStr="Eliminar";
    private final String edicionStr="Edicion";
    
    
    public MenuBarRecrea() throws JDOMException{
      this.removeAll();
      menuRecrea();
    }
    public MenuBarRecrea(ContratoGeneral cont){
      this.removeAll();
      contGen=cont;
      menuRecrea();
    }
    public void setContrato(ContratoGeneral cont){
        contGen=cont;
    }
    
    
    private void menuRecrea(){
        opcSub=new String[][]{{cargarStr+espacioStr+materiasStr},
                           {guardarStr+espacioStr+materiasStr}};
        CrearMenu(archivoStr,opcSub);
        opcSub=new String[][]{{agregarStr,materiaStr,leccionStr,ejercicioStr},
               {modificarStr,materiaStr,leccionStr,ejercicioStr},
               {eliminarStr,materiaStr,leccionStr,ejercicioStr}};
        CrearMenu(edicionStr,opcSub);
        opcSub=new String[][]{{avanceStr}};
        CrearMenu(vistaStr,opcSub);
        opcSub=new String[][]{};
        CrearMenu(ayudaStr,opcSub);
    }
    /**
     * Metodo para crear el menuBarRecrea
     * @param nombre nombre que saldrá en la opción
     * @param subOpciones lista con las subopciones que se desplegarán
     */
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
     * método para crear el menú de una opción 
     * @param menu opcion que se añadirá
     * @param nombre nombre de la opcion
     */
    private void SubMenu(JMenu menu,String nombre){
        menu.addSeparator();
        menuItem=new JMenuItem(nombre);
        menuItem.addActionListener(ActionsLis(nombre));
        menu.add(menuItem);
    }
    /**
     * si la opcion contiene subOpciones se creará con todas estas
     * @param menu opcion que se añadirá
     * @param nombre nombre de la opcion
     * @param opciones subOpciones que contendrá el menu
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
        /**
         * Método que añade los actions a cada opcion u subOpcion del menuBar
         * @param nombreMenu nombre de la opcion o subOpcion
         * @return actionListener
         */
  private ActionListener ActionsLis(String nombreMenu){
      switch(nombreMenu)
      {
          case cargarStr+espacioStr+materiasStr:return Componentes.ActionsListener.ActionCargarXML(); 
          case guardarStr+espacioStr+materiasStr:return Componentes.ActionsListener.ActionGuardarXML();
          case agregarStr+materiaStr:return Componentes.ActionsListener.ActionAgregarMateria();
          case agregarStr+leccionStr:return Componentes.ActionsListener.ActionAgregarLeccion();
          case agregarStr+ejercicioStr:return Componentes.ActionsListener.ActionAgregarEjercicio();
          case avanceStr: return Componentes.ActionsListener.ActionCargarAvance(contGen);
       
      }
         return null;
  }





    
}

