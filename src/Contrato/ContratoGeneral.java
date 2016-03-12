/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contrato;
import Model.Objetos.Persona;

/**
 * Este contrato sirve para la mayória de las ventanas y cumple la finalidad 
 * de otorgar el manejo de ciertas funciones en la capa Model
 * @author Manuel
 */
public interface ContratoGeneral {
    
    public void SetEnable(boolean bol); //Recarga los componentes si sucede algun cambio
    public void Reaload();
    public Persona GetPersona();
    public void avisoMensaje(String mensaje); //método para enviar un mensaje al usuario, bien sea de alerta, error o información
}
