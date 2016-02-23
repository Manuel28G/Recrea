/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Contrato.ContratoGeneral;
import Controller.Util;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

/**
 *
 * @author Manuel Goncalves L.
 */
public class AgregarMateria extends Componentes.FrameRecrea implements Contrato.ContratoBotones {
    private Componentes.PanelRecrea pnRecrea;
    private Componentes.ImportarImagenDialog imgDialog;
    private ContratoGeneral ctoGeneral;
    /**
     * Creates new form AgregarMateria
     */
     public AgregarMateria() {
        pnRecrea=new Componentes.PanelRecrea();
        initComponents();
        this.add(pnRecrea);
        this.configuracion(pnRecrea);
        this.add(new AgregarLeccion().getLayeredPane());
    }
     
    public AgregarMateria(ContratoGeneral ctoGen) {
        ctoGeneral=ctoGen;
        pnRecrea=new Componentes.PanelRecrea();
        initComponents();
        this.add(pnRecrea);
        this.configuracion(pnRecrea);
        //ctoGeneral.SetEnable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LB_Titulo1 = new Componentes.LabelRecrea();
        LB_Titulo2 = new Componentes.LabelRecrea();
        TB_Nombre = new Componentes.TextBoxRecrea();
        TB_Nivel = new Componentes.NumberBoxRecrea();
        TB_CargarImagen = new Componentes.TextBoxRecrea();
        BT_Crear = new Componentes.BotonRecrea(Util.BOTON_TIPO_SEGUIR,this);
        BT_Cancelar = new Componentes.BotonRecrea(Util.BOTON_TIPO_SALIR,this);
        LB_Nombre = new Componentes.LabelRecrea();
        LB_Nivel = new Componentes.LabelRecrea();
        BT_CargarImagen = new Componentes.BotonRecrea(Util.BOTON_TIPO_OPCION,this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LB_Titulo1.setText("A continuación se presentaran los campos");

        LB_Titulo2.setText("para la creación de una nueva materia");

        TB_CargarImagen.setEnabled(false);

        BT_Crear.setText("Crear");

        BT_Cancelar.setText("Cancelar");

        LB_Nombre.setText("Nombre de la materia");

        LB_Nivel.setText("Nivel de dificultad");

        BT_CargarImagen.setText("Cargar Imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_Titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BT_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LB_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BT_CargarImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LB_Nivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TB_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TB_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TB_CargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LB_Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_Titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LB_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TB_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TB_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TB_CargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_CargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.BotonRecrea BT_Cancelar;
    private Componentes.BotonRecrea BT_CargarImagen;
    private Componentes.BotonRecrea BT_Crear;
    private Componentes.LabelRecrea LB_Nivel;
    private Componentes.LabelRecrea LB_Nombre;
    private Componentes.LabelRecrea LB_Titulo1;
    private Componentes.LabelRecrea LB_Titulo2;
    private Componentes.TextBoxRecrea TB_CargarImagen;
    private Componentes.NumberBoxRecrea TB_Nivel;
    private Componentes.TextBoxRecrea TB_Nombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ActionSiguiente(ActionEvent e) {
     Controller.ControllerAgregar ctAgregar= new Controller.ControllerAgregar();
     ctAgregar.AgregarMateria(imgDialog.getSelectedFile().getName(),
                              TB_Nivel.getText(),TB_Nombre.getText());
     imgDialog.Cargar();
     ctoGeneral.Reaload();
     this.dispose();
     
    }

    @Override
    public void ActionSalir(ActionEvent e) {
    this.dispose();
    }

    @Override
    public void ActionOpciones(ActionEvent e) {
      imgDialog=new Componentes.ImportarImagenDialog();
      if(imgDialog.getStatus()==JFileChooser.APPROVE_OPTION)
      {
        TB_CargarImagen.setText(imgDialog.getSelectedFile().toString());
        //para mostrar la ruta entera al dejar el cursor sobre el componente
        this.TB_CargarImagen.setToolTipText(imgDialog.getSelectedFile().toString());
      }
      
    }

    @Override
    public void ActionSonido(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
