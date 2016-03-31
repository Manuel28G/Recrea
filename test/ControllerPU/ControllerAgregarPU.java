/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;

import Componentes.BotonRecrea;
import Controller.ControllerAgregar;
import Controller.ControllerEliminar;
import Controller.Util;
import Model.Objetos.Actividad;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.util.ArrayList;
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
public class ControllerAgregarPU {
    private final ControllerAgregar contAgre;
    private final ControllerEliminar contElim;
    private final String nivel="0";
    private final String img="default.png";
    private final String puntos="0";
    private final String pregunta="Pregunta 01";
    private final String respuesta="Respuesta 9239248";
    private final String puntosTotal="100";
    
    private Materia mt;
    private final String mtNombre="Materia";
    private final String mtLong="Materia 12345679 final final";//nombre mayor a 14 caracteres
    private Leccion lc;
    private final String lcNombre="Leccion";
    private Ejercicio ejc;
    private final String ejcNombre="Ejercicio";
    private Actividad act;
    private final String actividad="Actividad 2016";
    
    public ControllerAgregarPU() {
        contAgre=new ControllerAgregar();
        contElim=new ControllerEliminar();
        mt=new Materia();
        lc=new Leccion();
        ejc=new Ejercicio();
        act=new Actividad();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        mt=contAgre.AgregarMateria(img, nivel,mtNombre);
        lc=contAgre.AgregarLeccion(nivel, img, lcNombre, mt);
        ejc=contAgre.AgregarEjercicio(Util.EJERCICIO_TIPO_ESCRIBIR, puntos, pregunta, respuesta, mt, lc);
    }
    
    @After
    public void tearDown() {
        
        contElim.EliminarMateria(mt);
    }

    @Test
    public void agregarMateria(){
        String xml=mtNombre+".xml";
        assertNotNull(mt);
        assertEquals(img,mt.getImagenURL());
        assertEquals(Integer.parseInt(nivel),mt.getNivel());
        assertEquals(mtNombre,mt.getNombre());
        assertEquals(xml,mt.getHijoURL());
    }   
    
    @Test 
    public void agregarMateria_long(){
        String xml= mtLong.replace(" ", "");
        xml= xml.substring(0, 15)+".xml";
        contElim.EliminarMateria(mt);
        mt=contAgre.AgregarMateria(img, nivel,mtLong);
        assertNotNull(mt);
        assertEquals(img,mt.getImagenURL());
        assertEquals(Integer.parseInt(nivel),mt.getNivel());
        assertEquals(mtLong,mt.getNombre());
        assertEquals(xml,mt.getHijoURL());
        
    }
    
    @Test
    public void agregarLeccion(){
        
        
        assertNotNull(lc);
        assertEquals(Integer.parseInt(nivel),lc.getNivel());
        assertEquals(img,lc.getImagenURL());
        assertEquals(lcNombre,lc.getNombre());
        assertEquals(new ArrayList<>(),lc.getEjercicios());
  
    }

    @Test
    public void agregarEjercicio(){
        
        assertNotNull(ejc);
        assertEquals(Util.EJERCICIO_TIPO_ESCRIBIR,ejc.getTipo());
        assertEquals(Integer.parseInt(puntos),ejc.getPuntos());
        assertEquals(pregunta,ejc.getEjercicio());
        assertEquals(respuesta,ejc.getRespuesta());
        assertEquals(Util.EJERCICIO_TIPO_ESCRIBIR,ejc.getTipo());
        assertNotSame("",ejc.getNombre());
    }

    @Test
    public void agregarActividad(){
        
        act=new Actividad();
        act.SetNombre(actividad);
        act.SetPtosObtenidos(puntos);
        act.SetPuntosTotales(puntosTotal);
        if(Controller.ControllerConsultar.consultarUsuario())
            assertTrue(contAgre.AgregarActividadPersona(act));
        else
            assertFalse(contAgre.AgregarActividadPersona(act));
        
    }

   @Test 
   public void agregarImagenBoton(){
       BotonRecrea bt=new BotonRecrea();
       contAgre.agregarImagenBoton(img, bt);
       String imgRuta=Util.RUTA_SRC+Util.IMAGE_PATH+img;
       
       assertNotNull(bt.getIcon());
       assertEquals(imgRuta,bt.getIcon().toString());
       assertNotNull(bt.getRolloverIcon());//debe existir la imagen Resaltardefault.png
   }
}
