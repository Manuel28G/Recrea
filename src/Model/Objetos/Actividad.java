/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel Goncalves L.
 */
public class Actividad {
    private String nombre;
    private String puntosTotales;
    private String puntosObtenidos;
    private String dia;
    private String fecha;
    private String hora;
    private List<Respuesta> respuestas;
    
    public Actividad(){
        respuestas=new ArrayList<Respuesta>();
        nombre="";
        puntosTotales="";
        puntosObtenidos="";
        dia="";
        fecha="";
        hora="";
    }
    
    
    public void SetNombre(String nbre){
        nombre=nbre;
    }
    public void SetPuntosTotales(String ptsTotales){
        puntosTotales=ptsTotales;
    }
    public void SetPtosObtenidos(String ptsObtenidos){
        puntosObtenidos=ptsObtenidos;
    }
    public void SetDia(String Dia){
        dia=Dia;
    }
    public void SetFecha(String Fecha){
        fecha=Fecha;
    }
    public void SetHora(String Hora){
        hora=Hora;
    }
    
    public List<Respuesta> GetRespuesta(){
        return respuestas;
    }
    
    public String GetNombre(){
        return nombre;
    }
    public String GetPuntosTotales(){
        return puntosTotales;
    }
    public String GetPtosObtenidos(){
        return puntosObtenidos;
    }
    public String GetDia(){
        return dia;
    }
    public String GetFecha(){
       return fecha;
    }
    public String GetHora(){
        return hora;
    }
    
    public void AddRespuesta(Respuesta resp){
        this.respuestas.add(resp);
    }
    
    public void ResetRespuesta(){
        this.respuestas=new ArrayList<Respuesta>();
    }
}
