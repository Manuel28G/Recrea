/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.CargarInformacion;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Controller.WindosCreate;
import Model.Objetos.General;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import org.jdom2.JDOMException;

/**
 *
 * @author Manuel
 */
public class Modulos extends javax.swing.JFrame {

       JPanel PN_Botones;//=new JPanel(new GridLayout(3, 3, 10, 10));
       JScrollPane SP_Materias;
       String rutaModulo;
       JPanel Marco=new JPanel(),Marco2=new JPanel(),Marco3=new JPanel(),Marco4=new JPanel();
       List<Leccion> ejercicios=new ArrayList<Leccion>();
       
       public Modulos() {
        initComponents();
        this.setLayout(new BorderLayout(0,0));
        }
       public void Modulo(String ruta,Materia g){
           
           ejercicios=g.getAsignaturas();
           rutaModulo=ruta;//se guarda en memoria la ruta del archivo en que estoy
           WindosCreate wc=new WindosCreate(g.getAsignaturas().size());
           wc.WindowsHijo(this);
           PN_Botones=wc.mostrarBotEj(g.getAsignaturas(), PN_Botones);
          // PN_Botones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10,20));//(arriba,izquierda,abajo,derecha) Margenes del JPanel
           SP_Materias = new JScrollPane(PN_Botones);
           this.add(SP_Materias, BorderLayout.CENTER);
           
           // this.add(PN_Botones, BorderLayout.CENTER);
       }
       
       
        public void configuracion(){
        
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
       
       public void actionPerformed(ActionEvent ae) throws JDOMException 
       {
        if(ae.getActionCommand()=="Regresar"){

        //poner gif de cargando
            Inicio init=new Inicio();
            init.setVisible(true);
            this.setVisible(false);
            this.dispose();

        }
        for (int i=0;i<ejercicios.size();i++){
          System.out.println("1: "+ae.getActionCommand());
          System.out.println("2: "+ejercicios.get(i).getNombre());
          if( ae.getActionCommand()==ejercicios.get(i).getNombre()){
            System.out.println("Entro: "+ejercicios.get(i).getNombre());
            Ejercicio Child=new Ejercicio();
            Child.setVisible(true);
            this.setVisible(false);
            this.dispose();
          }
        }
      
        }
 

 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulos().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
