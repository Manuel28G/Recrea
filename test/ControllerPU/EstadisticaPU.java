/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;


import Controller.Estadistica;
import Model.Objetos.Actividad;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manuel Goncalves L.
 */
public class EstadisticaPU {
    
    private final Estadistica estadistica;
    private final List<Actividad> actividades;
    
    private final int ptosTotal=2128;
    private final int ptosObt1=1064;
    
    private int ptosTotalAct;
    private int ptosObtAct;
    
    private final int ptosObt2=2128;
    private final int ptosObt3=0;
    
    private final float ptosTotal4=2140.10f;
    private final float ptosObt4=1070.05f;
  
    private final int nota10=10;
    private final int nota0=0;
    private final int nota20=20;
    
    private final String vacio="";
    private final int cero=0;
    
    private final String[] dias=DateFormatSymbols.getInstance().getWeekdays();
    private final String[] fecha={"28/03/2016","29/03/2016","30/03/2016","31/03/2016","01/04/2016","02/04/2016","03/04/2016","04/04/2016"};
    private final String diaMasP4="domingo, jueves, lunes, martes, miércoles, sábado, viernes";
    
    private final String diaMenosP1="jueves, miércoles, sábado, viernes";
    private final String diaMenosP2="domingo, jueves, sábado, viernes";
    private final String diaMenosP3="jueves, miércoles, sábado, viernes"; 
    private final String diaMenosP4="domingo, jueves, lunes, martes, miércoles, sábado, viernes";
    private final String diaMenosP7="jueves, lunes, martes, miércoles, sábado, viernes";
    private final String diaMenosP8="domingo, jueves, lunes, martes, sábado, viernes";
    private final String diaMenosP9="domingo, jueves, lunes, martes, miércoles, viernes";
   private int masProduct=2;
   private int inicio=0;
   private int acarreo=1;
   private int fin=4;
   
   private final float notaTotalDec=2048;
   private final float notaObtDec1=1075.2f;
   private final int nota11=11;
   private final float notaObtDec2=1064.96f;
   private final float notaObtDec3=1105.92f;
    
    public EstadisticaPU() {
        estadistica=new Estadistica();
        actividades=new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
      masProduct=2;
      inicio=0;
      acarreo=1;
      fin=4;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void calculoDeNota(){
      assertEquals(nota10,Estadistica.calculoDeNota(ptosTotal, ptosObt1));
      assertEquals(nota20,Estadistica.calculoDeNota(ptosTotal, ptosObt2));
      assertEquals(nota0,Estadistica.calculoDeNota(ptosTotal, ptosObt3));
      assertEquals(nota10,Estadistica.calculoDeNota(ptosTotal4, ptosObt4));
      }
    @Test
    public void calculoDeNota_PuntoCinco(){
        assertEquals(nota11,Estadistica.calculoDeNota(notaTotalDec,notaObtDec1));//el resultado da 10.5 pero se redondea
    }
    
     @Test
    public void calculoDeNota_RendondeoBajo(){
        assertEquals(nota10,Estadistica.calculoDeNota(notaTotalDec,notaObtDec2));//el resultado da 10.5 pero se redondea
    }
    
     @Test
    public void calculoDeNota_RedondeoAlto(){
        assertEquals(nota11,Estadistica.calculoDeNota(notaTotalDec,notaObtDec3));//el resultado da 10.5 pero se redondea
    }
    
    @Test(expected=NullPointerException.class)
    public void calcular_null(){
       estadistica.Calcular(null);
    }
    
    @Test
    public void calcular_vacio(){
        estadistica.Calcular(new ArrayList<Actividad>());
        
        assertEquals(vacio,estadistica.GetDiaMasProductivo());
        assertEquals(vacio,estadistica.GetDiaMenosProductivo());
        assertEquals(vacio,estadistica.GetPromPracticaDiaria());
        assertEquals(vacio,estadistica.GetUltimaConexion());
        assertEquals(cero,estadistica.GetEjerciciosRealizados());
        assertEquals(cero,estadistica.GetNota());
        assertEquals(cero,estadistica.GetPuntosObtenidos());
        assertEquals(cero,estadistica.GetPuntosTotales());
    }
    
    @Test
    public void calcular1(){
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP1,estadistica.GetDiaMenosProductivo());
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    
    @Test //repetido en el intermedio
    public void calcular2(){
        inicio=1;
        masProduct=3;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP2,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //repetido al final
    public void calcular3(){
        inicio=0;
        masProduct=3;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP3,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //repetido al comienzo
    public void calcular4(){
        inicio=0;
        masProduct=1;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP3,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //dos repetidos
    public void calcular5(){
        inicio=0;
        masProduct=1;
        actividades();
        
        Actividad act= new Actividad();
        acarreo=0;
        agreActividad(act,2);
        
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP3,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //todos los dias
    public void calcular6(){
        inicio=0;
        masProduct=10;
        fin=7;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(diaMasP4,estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP4,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    
   @Test //todos los dias: inicio repetido
    public void calcular7(){
        inicio=0;
        masProduct=1;
        fin=8;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP7,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //todos los dias: intermedio repetido
    public void calcular8(){
        inicio=0;
        masProduct=4;
        fin=8;
        actividades();
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP8,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    @Test //todos los dias: final repetido
    public void calcular9(){
        inicio=0;
        masProduct=10;
        fin=7;
        actividades();
        Actividad act=new Actividad();
        acarreo=0;
        masProduct=7;//ahora el mas repetido sera el dia 7 que cae "sábado"
        fin++;//como se añadio una actividad mas se alarga el fin
        ptosObtAct=0;//el ultimo no tendra puntos 
        ptosTotalAct=0;//para no alterar el calcul
        actividades.add(agreActividad(act, masProduct));
        estadistica.Calcular(actividades);
        assertEquals(dias[masProduct],estadistica.GetDiaMasProductivo());
        assertEquals(diaMenosP9,estadistica.GetDiaMenosProductivo());
        //assertEquals(4,estadistica.GetPromPracticaDiaria()); esto varia con la fecha actual
        assertEquals(fecha[inicio+fin-1],estadistica.GetUltimaConexion());
        assertEquals(fin,estadistica.GetEjerciciosRealizados());
        assertEquals(nota10,estadistica.GetNota());
        assertEquals(ptosObt1,estadistica.GetPuntosObtenidos());
        assertEquals(ptosTotal,estadistica.GetPuntosTotales());
    }
    private void actividades(){
     acarreo=1;
     
     ptosTotalAct=ptosTotal/fin;
     ptosObtAct=ptosObt1/fin;
     
     for(int i=inicio;i<(inicio+fin);i++){
     Actividad act=new Actividad();
     actividades.add(agreActividad(act,i));
     }
    }
 
    private Actividad agreActividad(Actividad act, int dia){
     int i=dia;
     act.SetPtosObtenidos(Integer.toString(ptosObtAct));
     act.SetPuntosTotales(Integer.toString(ptosTotalAct));
     act.SetDia(dias[i+acarreo]);
     if(i==masProduct){
         act.SetDia(dias[i]);
         acarreo=0;
     }
     
     act.SetFecha(fecha[i]);
     act.SetNombre("Actividad 2016-"+i);
     
     return act;
    }
}
