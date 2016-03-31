/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;

import Controller.Validaciones;

/**
 * Metodo utilizado para llevar la secuencia de las preguntas y respuestas
 * realizadas en una lección asi como tambien la respuesta correcta
 * @author Manuel Goncalves L.
 */
public class Respuesta {
    
    private String pregunta; //Pregunta 
    private String respuestaCorrecta;//respuesta correcta del sistema
    private String respuestaRealizada;//respuesta realizada por el usuario
    private String respuestaAnterior;//respuesta escrita anterior a la última
    private String tiempoRespuesta;//momento en que se envio el resultado
    private String tiempoComienzo;// momento en que comenzo el ejercicio
    private Boolean respuesta;//true si respondio correcto; false si no
    private int puntos;//los puntos que se obtienen al responder el ejercicio de manera correcta
    private int puntosObtenidos;
    private Validaciones valid;
    private String tipoRespuesta;//"Número" o "Caracteres" que corresponde a letras y numeros
    
    
    public Respuesta(){
        pregunta="";
        respuestaCorrecta="";
        respuestaRealizada="";
        respuestaAnterior="";
        tiempoRespuesta="";
        tiempoComienzo="";
        respuesta=false;
        puntos=0;
        puntosObtenidos=0;
        valid=new Validaciones();
        tipoRespuesta="";
    }
    
    //Get's
    public String GetPregunta(){
        return pregunta;
    }
    public String GetRespuestaCorrecta(){
        return respuestaCorrecta;
    }
    public String GetRespuestaRealizada(){
        return respuestaRealizada;
    }
    public String GetRespuestaAnterior(){
        return respuestaAnterior;
    }
    public String GetTiempoRespuesta(){
        return tiempoRespuesta;
    }
    public String GetTiempoInicio(){
        return tiempoComienzo;
    }
    public boolean EsCorrecta(){
        
        validarRespuesta();
        return respuesta;
    }
    public int GetPuntoTotal(){
        return puntos;
    }
    public int GetPuntosObtenido(){
        return puntosObtenidos;
    }
    public String GetTipoRespuesta(){
        return tipoRespuesta;
    }
        
    
    //Set's
    public void SetTipoRespuesta(String rsta){
        tipoRespuesta=rsta;
    }    
    
    public void SetPregunta(String pta){
        pregunta=pta;
    }
    public void SetRespuestaCorrecta(String rtaCta){
        respuestaCorrecta=rtaCta;
        validarRespuesta();
    }
    public void SetRespuestaRealizada(String rtaRzda){
        respuestaRealizada=rtaRzda;
    }
    public void SetRespuestaAnterior(String rtaAnt){
        respuestaAnterior=rtaAnt;
    }
    public void SetTiempoRespuesta(String tmpRsp){
        tiempoRespuesta=tmpRsp;
    }
    public void SetTiempoInicio(String tmpIni){
        tiempoComienzo=tmpIni;
    }
    
    public void SetPuntoTotal(int ptos){
       puntos=ptos;
    }
    public void SetPuntosObtenido(int pt){
       puntosObtenidos=pt;
    }
    private void validarRespuesta(){
        if(this.respuestaRealizada!="" && this.respuestaCorrecta!="")
            this.respuesta=valid.EsCorrecta(this.respuestaCorrecta,this.respuestaRealizada,this.tipoRespuesta);
    }
}
