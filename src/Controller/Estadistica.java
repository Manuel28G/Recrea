/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Objetos.Actividad;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Manuel Goncalves L.
 */
public final class Estadistica {
    private String ultimaConexion;
    private String diaMasProductivo;
    private String diaMenosProductivo;
    private int puntosTotal;
    private int puntosObtenidos;
    private int nota;//nota en base a 20
    private int ejercicioRealizados;
    private String primeraConexion;
    private String promPracticaDiaria;
    private final List<String> dias;
    private DateFormat formatoFecha;
    private Date dateInicio;
    private Date dateFin;
    private final String[] diasSemana ;//dias de la semana tomadas del sistema
    private List<String> practicasRealizadas=new ArrayList<>();//dias practicados sin repetición
       
    /**
     * Constructor
     */
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
        this.diasSemana = DateFormatSymbols.getInstance().getWeekdays();
        dias=new ArrayList<>();
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
        this.diasSemana = DateFormatSymbols.getInstance().getWeekdays();
        dias=new ArrayList<>();
        Calcular(actividades);
        
   
    }
    /**
     * Método para calcular los valores pertinentes a mostrar
     * @param actividades lista de actividades realizadas en la aplicación
     */
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
       this.CalcularPromPracticaDiaria(primeraConexion);
      this.nota= calculoDeNota(this.puntosTotal,this.puntosObtenidos);
    }
    /**
     * Método para calcular el día mas productivo del usuario
     * 
     * @param diasPracticados  lista de dias que ha practicado en la aplicación
     */
    private void CalcularDiaMasProductivo(List<String> diasPracticados){
 
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
    
    /**
     * Método que calcula el día menos productivo para el usuario en la aplicación
     * @param diasPracticados lista de dias que ha practicado en la aplicación
     */
    private void CalcularDiaMenosProductivo(List<String> diasPracticados){
        Collections.sort(diasPracticados);
        practicasRealizadas = new ArrayList<>();
        int mayoria=10000;
        int cont=0;
        String dia=diasPracticados.get(0);
        practicasRealizadas.add(dia);
        for(String Dia: diasPracticados){
            if(Dia.equals(dia))
                cont++;
            else{
                practicasRealizadas.add(Dia);
                if(cont==mayoria){
                    this.diaMenosProductivo+=", "+dia;
                }
                if(cont<mayoria){
                    mayoria=cont;
                    this.diaMenosProductivo=dia;
                }
                dia=Dia;
                cont=1;    
            }
        }
        validarDias();
    }
    /**
     * Método para validar si hay algún día en el que no sea ha practicado 
     * en lo absoluto y se añadirá como el o los dias menos productivos
     */
    private void validarDias(){
        System.out.println(diasSemana.length);
        System.out.println(practicasRealizadas.size());
        if(practicasRealizadas.size()!= (diasSemana.length -1)){
            List<String> semana=new ArrayList<>();
            for(String dia: diasSemana){
                semana.add(dia);
            }
            //semana=diasSemana;
            Collections.sort(semana);
            Collections.sort(practicasRealizadas);
            semana.removeAll(practicasRealizadas);
            this.diaMenosProductivo="";
            String coma="";
            for(String dRealizado: semana){
                if(dRealizado!="")
                {
                    this.diaMenosProductivo+=coma+dRealizado;
                    coma=" , ";
                }
            }
        }
    }
    

    
    /**
     * Método para calcular la probabilidad de práctica diaria en la aplicación
     * tomando en cuenta desde el primer dia que se utilizó hasta el día actual
     * @param primeraPractica fecha de la primera practica realizada
     */
    private void CalcularPromPracticaDiaria(String primeraPractica){
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
        {
        System.out.println("Error encontrado en estadistica: "+ex);
        }
    }
    private void CalcularPuntosTotal(Actividad actividad){
           this.puntosTotal+= Integer.parseInt(actividad.GetPuntosTotales());
    }
    private void CalcularPuntosObtenidos(Actividad actividad){
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
    //FIN Get's
    
    /**
     * Método para calcular la nota final con respecto a todas las actividades realizadas
     * @param Total total de puntos acumulados entre ejercicios
     * @param obtenido total de puntos Obtenidos acumulados entre ejercicios
     * @return 
     */
   public static int calculoDeNota(float Total,float obtenido){
        float resp=((obtenido*20)/Total);
        resp=Math.round(resp);
        return (int)resp;
    }
    

}
