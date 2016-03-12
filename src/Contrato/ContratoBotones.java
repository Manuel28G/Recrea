/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contrato;

import java.awt.event.ActionEvent;

/**
 * Esta interface cumple la finalidad de otorgar el manejo de ciertas funciones
 * con respecto a los botones.
 * En general se trata de las acciones que se pueden realizar en estos componentes
 * @author Manuel Goncalves L.
 */
public interface ContratoBotones {
        
    public void ActionSiguiente(ActionEvent e); 
    public void ActionSalir(ActionEvent e);
    public void ActionOpciones(ActionEvent e);
    public void ActionSonido(ActionEvent e);
}
