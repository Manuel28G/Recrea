/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Clase que define el componente FrameRecrea
 * @author Manuel Goncalves L.
 */
public class FrameRecrea extends JFrame {
    
    private JScrollPane SP_Materias;
   
    private final JPanel Marco=new JPanel();
    private final JPanel Marco2=new JPanel();
    private final JPanel Marco3=new JPanel();
    private final JPanel Marco4=new JPanel();
    
    /**
     * Método que realiza la configuracion General del Frame
     * @param pR Panel que contendrá todos los componentes que se añadirán
     */
     public void configuracion(PanelRecrea pR){
        SP_Materias = new JScrollPane(pR);
        this.setLayout(new BorderLayout(0,0));
        SP_Materias.setOpaque(false);
        this.add(SP_Materias, BorderLayout.CENTER);
        //codigo agregado para simular el marco e la pizarra
        Marco.setBackground(new Color(102, 50, 0));
        Marco2.setBackground(new Color(102, 50, 0));
        Marco3.setBackground(new Color(102, 50, 0));
        Marco4.setBackground(new Color(102, 50, 0));
        this.add(Marco, BorderLayout.SOUTH);
        this.add(Marco2, BorderLayout.WEST);
        this.add(Marco3, BorderLayout.EAST);
        this.add(Marco4, BorderLayout.NORTH);    

        this.setResizable(false);
    
    }
     /**
      * Método que ajusta el frame a su tamaño maximo (Ventana completa)
      */
     public void fullScreen(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        this.setSize(xSize,ySize);
         
     }
}
