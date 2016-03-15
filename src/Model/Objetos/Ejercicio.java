/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;


/**
 *
 * @author Manuel
 * @version 1.0
 */
public class Ejercicio extends EntidadGeneral {
    private String tipo;
    private String ejercicio;
    private String respuesta;
    private int puntos;
    
//Constructores    
    public void Ejercicio(){
     setTipo("");
     setEjercicio("");  
     setRespuesta("");
     setPuntos(0);
    }
    public void Ejercicio(String tp,String ejc,String rsp,int pts){
     setTipo(tp);
     setEjercicio(ejc);  
     setRespuesta(rsp);
     setPuntos(pts);    
    }

//Get's    
    public String getTipo() {
        return tipo;
    }
    public String getEjercicio() {
        return ejercicio;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public int getPuntos() {
        return puntos;
    }
  //Set's
    public void setTipo(String tipo) {
        this.tipo = tipo;
    } 
    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
