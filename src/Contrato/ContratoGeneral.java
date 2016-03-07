/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contrato;
import Model.Objetos.Persona;
import java.awt.event.ActionEvent;

/**
 *
 * @author Manuel
 */
public interface ContratoGeneral {
    public void SetEnable(boolean bol);
    public void Reaload();
    public Persona GetPersona();
    public void avisoMensaje(String mensaje);
}
