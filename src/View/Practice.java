package View;

import Controller.MateriasPath;
import Controller.Util;
import Controller.WindosCreate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




/**
 *
 * @author Manuel
 */
public class Practice extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Practice
     */
    JPanel PN_Botones;
    JPanel Marco=new JPanel(),Marco2=new JPanel(),Marco3=new JPanel(),Marco4=new JPanel();
    final JScrollPane SP_Materias;
    
    String ruta=Controller.MateriasPath.MATERIAS_XML_PATH;
    public Practice() {
        initComponents(); 
        this.setLayout(new BorderLayout(0,0));
        WindosCreate wc=new WindosCreate(ruta);
        wc.WindowsHijo(this);
        PN_Botones=wc.mostrarBot(ruta, PN_Botones);
        //PN_Botones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10,20));//(arriba,izquierda,abajo,derecha) Margenes del JPanel
        //this.add(PN_Botones, BorderLayout.CENTER);
        SP_Materias = new JScrollPane(PN_Botones);
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
            .addGap(0, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practice().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.isVisible())
        {
        System.out.println(ae.getActionCommand());
        Modulos Child= new Modulos();

        switch(ae.getActionCommand()){
            case Util.CERO_TAG:
            Child.Modulo(MateriasPath.CERO_XML_PATH);break;
            case Util.NUMEROS_TAG:
            Child.Modulo(MateriasPath.NUMEROS_XML_PATH);break;   
        }
        Child.setVisible(true);
        this.setVisible(false);
        }
    }
}

