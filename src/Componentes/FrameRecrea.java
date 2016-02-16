/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Componentes;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Manuel
 */
public class FrameRecrea extends JFrame {
    
    JScrollPane SP_Materias;
   
    JPanel Marco=new JPanel();
    JPanel Marco2=new JPanel();
    JPanel Marco3=new JPanel();
    JPanel Marco4=new JPanel();
    
    
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
    
    }
}
