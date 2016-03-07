/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Objetos.Actividad;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Manuel Goncalves L.
 */
public class Estadistica {
    private String ultimaConexion;
    private String diaMasProductivo;
    private String diaMenosProductivo;
    private int puntosTotal;
    private int puntosObtenidos;
    private int nota;//nota en base a 20
    private int ejercicioRealizados;
    private String primeraConexion;
    private String promPracticaDiaria;
    private List<String> dias;
    boolean lunes=false,martes=false,miercoles=false,
            jueves=false,viernes=false,sabado=false,domingo=false;
    private DateFormat formatoFecha;
    private Date dateInicio;
    private Date dateFin;
    
    public Estadistica(){
        this.ultimaConexion="";
        this.diaMasProductivo="";
        this.diaMenosProductivo="";
        this.promPracticaDiaria="";
        this.puntosObtenidos=0;
        this.puntosTotal=0;
        this.nota=0;
        this.ejercicioRealizados=0;
        this.primeraConexion="";
        dias=new ArrayList<String>();
    }
    
    /***
     * Constructor que calcula directamente las variables
     * @param actividades lista de actividades realizadas
     */
    public Estadistica(List<Actividad> actividades){
        this.ultimaConexion="";
        this.diaMasProductivo="";
        this.diaMenosProductivo="";
        this.promPracticaDiaria="";
        this.puntosObtenidos=0;
        this.puntosTotal=0;
        this.nota=0;
        this.ejercicioRealizados=0;
        this.primeraConexion="";
        dias=new ArrayList<String>();
        Calcular(actividades);
        
   
    }
    public void Calcular(List<Actividad> actividades){
       this.primeraConexion=actividades.get(0).GetFecha();
       this.ultimaConexion=actividades.get(-1+actividades.size()).GetFecha();
       for(Actividad actividad:actividades){
            dias.add(actividad.GetDia());
            this.ejercicioRealizados++;
            this.CalcularPuntosObtenidos(actividad);
            this.CalcularPuntosTotal(actividad);
        }
       this.CalcularDiaMasProductivo(dias);
       this.CalcularDiaMenosProductivo(dias);
       this.CalcularPromPracticaDiaria(primeraConexion, ultimaConexion);
      this.nota= this.calculoDeNota(this.puntosTotal,this.puntosObtenidos);
    }
    
    public void CalcularDiaMasProductivo(List<String> diasPracticados){
        Collections.sort(diasPracticados);
        int mayoria=0;
        int cont=0;
        String dia=diasPracticados.get(0);
        for(String Dia: diasPracticados){
            if(Dia.equals(dia))
                cont++;
            else{
                if(cont==mayoria)
                    this.diaMasProductivo+=", "+dia;
                if(cont>mayoria){
                    mayoria=cont;
                    this.diaMasProductivo=dia;
                }
                dia=Dia;
                cont=1;    
            }
        }
    }
    public void CalcularDiaMenosProductivo(List<String> diasPracticados){
        Collections.sort(diasPracticados);
        int mayoria=10000;
        int cont=0;
        String dia=diasPracticados.get(0);
        for(String Dia: diasPracticados){
            if(Dia.equals(dia))
                cont++;
            else{
                if(cont==mayoria)
                    this.diaMenosProductivo+=", "+dia;
                if(cont<mayoria){
                    mayoria=cont;
                    this.diaMenosProductivo=dia;
                }
                dia=Dia;
                cont=1;    
            }
        }
    }
    public void CalcularPromPracticaDiaria(String primeraPractica,String ultimaPractica){
        try{
        long milSeg=24 * 60 * 60 * 1000;// milisegundos por dia 
        formatoFecha= new SimpleDateFormat(Util.FORMATO_FECHA);
        dateFin=new Date();
        dateInicio=formatoFecha.parse(primeraPractica.trim());
        long diferencia = ( dateFin.getTime() - dateInicio.getTime() )/milSeg; //la resta da en milisegundos por eso se divide para obtener dias
        float diasPracticando=(int)diferencia;
        float ejerciciosPorDia=this.ejercicioRealizados/diasPracticando;
        ejerciciosPorDia=Math.round(ejerciciosPorDia*100);
        this.promPracticaDiaria=Integer.toString((int)ejerciciosPorDia)+"%";
        }
        catch(Exception ex)
        {}
    }
    public void CalcularPuntosTotal(Actividad actividad){
           this.puntosTotal+= Integer.parseInt(actividad.GetPuntosTotales());
    }
    public void CalcularPuntosObtenidos(Actividad actividad){
        this.puntosObtenidos+=Integer.parseInt(actividad.GetPtosObtenidos());
    }
  
    //Get's
    public int GetEjerciciosRealizados(){
        return this.ejercicioRealizados;
    }
    public String GetDiaMasProductivo(){
        return this.diaMasProductivo;
    }
    public String GetDiaMenosProductivo(){
        return this.diaMenosProductivo;
    }  
    public int GetPuntosObtenidos(){
        return this.puntosObtenidos;
    }   
    public int GetPuntosTotales(){
        return this.puntosTotal;
    }   
    public int GetNota(){
        return this.nota;
    }   
    public String GetPromPracticaDiaria(){
        return this.promPracticaDiaria;
    }   
    public String GetUltimaConexion(){
        return this.ultimaConexion;
    }
    
   public static int calculoDeNota(float Total,float obtenido){
        float resp=((obtenido*20)/Total);
        resp=Math.round(resp);
        return (int)resp;
    }
    

}
