/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.Eliminar;

import Componentes.FrameRecrea;
import Componentes.PanelRecrea;
import Contrato.ContratoBotones;
import Contrato.ContratoGeneral;
import Controller.ControllerConsultar;
import Controller.ControllerEliminar;
import Controller.Util;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Goncalves L.
 */
public class EliminarEjercicio extends FrameRecrea implements ContratoBotones  {
    private final PanelRecrea pnRecrea;
    private final ContratoGeneral contGen;
    private final ControllerConsultar cc;
    private final ControllerEliminar ce;
    private Materia materia;
    private Leccion leccion;
    private Ejercicio ejercicio;
    /**
     * Creates new form EliminarEjercicio
     * @param cg contatoGeneral de la interfaz padre
     */
    public EliminarEjercicio(ContratoGeneral cg) {
        pnRecrea=new Componentes.PanelRecrea();
        cc=new ControllerConsultar();
        ce=new ControllerEliminar();
        initComponents();
        contGen=cg;
        contGen.SetEnable(false);
        this.add(pnRecrea);
        this.configuracion(pnRecrea);
        this.TA_Ejercicio.setEditable(false);
        cc.CargarComboBoxMateria(CB_Materia);
       
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
        CB_Materia = new Componentes.ComboBoxRecrea();
        CB_Leccion = new Componentes.ComboBoxRecrea(Util.COMBOBOX_SELECCIONAR);
        CB_FechaEjercicio = new Componentes.ComboBoxRecrea(Util.COMBOBOX_SELECCIONAR);
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Ejercicio = new Componentes.TAreaRecrea();
        BT_Borrar = new Componentes.BotonRecrea(Util.BOTON_TIPO_SEGUIR,this);
        BT_Cancelar = new Componentes.BotonRecrea(Util.BOTON_TIPO_SALIR,this);
        LB_Materia = new Componentes.LabelRecrea();
        LB_Leccion = new Componentes.LabelRecrea();
        LB_FechaEjercicio = new Componentes.LabelRecrea();
        LB_Ejecicio = new Componentes.LabelRecrea();
        TB_TipoEjercicio = new Componentes.TextBoxRecrea();
        LB_Tipo = new Componentes.LabelRecrea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        LB_Titulo1.setText("Seleccione el ejercicio");

        LB_Titulo2.setText("que desea borrar");

        CB_Materia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_MateriaItemStateChanged(evt);
            }
        });

        CB_Leccion.setEnabled(false);
        CB_Leccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_LeccionItemStateChanged(evt);
            }
        });

        CB_FechaEjercicio.setEnabled(false);
        CB_FechaEjercicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_FechaEjercicioItemStateChanged(evt);
            }
        });

        jScrollPane1.setViewportView(TA_Ejercicio);

        BT_Borrar.setText("Borrar");

        BT_Cancelar.setText("Cancelar");

        LB_Materia.setText("Materia");

        LB_Leccion.setText("Lección");

        LB_FechaEjercicio.setText("Fecha del ejercicio");

        LB_Ejecicio.setText("Ejercicio");

        TB_TipoEjercicio.setEnabled(false);

        LB_Tipo.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BT_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(LB_Titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(LB_Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LB_Ejecicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LB_Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LB_Leccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LB_FechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TB_TipoEjercicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_Materia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_Leccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_FechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(LB_Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LB_Titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LB_Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LB_Leccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LB_FechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CB_Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(CB_Leccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CB_FechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TB_TipoEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LB_Ejecicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB_LeccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_LeccionItemStateChanged
      
      leccion=(Leccion)this.CB_Leccion.GetItemRecrea();
      if(CB_Leccion.getSelectedIndex()>0){
          CB_FechaEjercicio.setEnabled(true);
          cc.CargarComboBoxEjercicio(CB_FechaEjercicio, leccion);
      }
      else{
          CB_FechaEjercicio.setEnabled(false);
          CB_FechaEjercicio.setSelectedIndex(0);
      }
          
    }//GEN-LAST:event_CB_LeccionItemStateChanged

    private void CB_MateriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_MateriaItemStateChanged
       materia=(Materia)this.CB_Materia.GetItemRecrea();
       if(CB_Materia.getSelectedIndex()>0)
      {
        cc.CargarComboBoxLeccion(CB_Leccion,materia);
        CB_Leccion.setEnabled(true);
      }
      else 
      {
          CB_Leccion.setEnabled(false);
          CB_Leccion.setSelectedIndex(0);
      }
    }//GEN-LAST:event_CB_MateriaItemStateChanged

    private void CB_FechaEjercicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_FechaEjercicioItemStateChanged
     ejercicio=(Ejercicio)CB_FechaEjercicio.GetItemRecrea();
     this.TA_Ejercicio.setText(ejercicio.getEjercicio());
     this.TB_TipoEjercicio.setText(ejercicio.getTipo());
    }//GEN-LAST:event_CB_FechaEjercicioItemStateChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.BotonRecrea BT_Borrar;
    private Componentes.BotonRecrea BT_Cancelar;
    private Componentes.ComboBoxRecrea CB_FechaEjercicio;
    private Componentes.ComboBoxRecrea CB_Leccion;
    private Componentes.ComboBoxRecrea CB_Materia;
    private Componentes.LabelRecrea LB_Ejecicio;
    private Componentes.LabelRecrea LB_FechaEjercicio;
    private Componentes.LabelRecrea LB_Leccion;
    private Componentes.LabelRecrea LB_Materia;
    private Componentes.LabelRecrea LB_Tipo;
    private Componentes.LabelRecrea LB_Titulo1;
    private Componentes.LabelRecrea LB_Titulo2;
    private Componentes.TAreaRecrea TA_Ejercicio;
    private Componentes.TextBoxRecrea TB_TipoEjercicio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ActionSiguiente(ActionEvent e) {
        if(ce.EliminarEjercicio(ejercicio, leccion, materia))
             JOptionPane.showMessageDialog(this,Util.MENSAJE_EJERCICIO_BORRADO, Util.DIALOG_TITULO_MENSAJE, JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,Util.ERROR_OPERACION_FALLIDA, Util.DIALOG_TITULO_MENSAJE, JOptionPane.INFORMATION_MESSAGE);
       
        ActionSalir(e);
    }

    @Override
    public void ActionSalir(ActionEvent e) {
    
        this.setVisible(false);
        contGen.SetEnable(true);
        this.dispose();
    }

    @Override
    public void ActionOpciones(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActionSonido(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
