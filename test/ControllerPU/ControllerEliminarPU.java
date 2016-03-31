/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;

import Controller.ControllerAgregar;
import Controller.ControllerConsultar;
import Controller.ControllerCrear;
import Controller.ControllerEliminar;
import Controller.Util;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
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
public class ControllerEliminarPU {
    private final ControllerEliminar contElim;
    private final ControllerCrear  contCrear;
    private final ControllerAgregar  contAgre;
    private final String nombre="Nombre";
    private final String apellido="Apellido";
    private Materia mt;
    private final String mtNombre="Materia 2016";
    private Leccion lc;
    private final String lcNombre="Leccion 2016";
    private Ejercicio ejc;
    private final String nivel="0";
    private final String img="default.png";
    private final String puntos="0";
    private final String pregunta="Pregunta 01";
    private final String respuesta="Respuesta 9239248";
    
    public ControllerEliminarPU() {
        contElim=new ControllerEliminar();
        contCrear=new ControllerCrear();
        contAgre=new ControllerAgregar();
        ejc=new Ejercicio();
        lc=new Leccion();
        mt=new Materia();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        contElim.EliminarMateria(mt);
    }

    @Test
    public void eliminarPersona(){
        if(!ControllerConsultar.consultarUsuario())
            ControllerCrear.CrearUsuario(nombre, apellido);
        boolean resp=contElim.EliminarUsuario(null);//por ahora es indiferente pasarle un parametro
        assertTrue(resp);
        assertFalse(ControllerConsultar.consultarUsuario());
        ControllerCrear.CrearUsuario(nombre, apellido);
    }
    
    @Test
    public void eliminarMateria(){
        
       mt=contAgre.AgregarMateria(img, nivel,mtNombre);
       assertTrue(contElim.EliminarMateria(mt));
    }
    
    @Test
    public void eliminarLeccion(){
        
        mt=contAgre.AgregarMateria(img, nivel,mtNombre);
        lc=contAgre.AgregarLeccion(nivel, img, lcNombre, mt);
        contElim.EliminarLeccion(lc, mt);
    }
    
    @Test
    public void eliminarEjercicio(){
     
        mt=contAgre.AgregarMateria(img, nivel,mtNombre);
        lc=contAgre.AgregarLeccion(nivel, img, lcNombre, mt);
        ejc=contAgre.AgregarEjercicio(Util.EJERCICIO_TIPO_ESCRIBIR, puntos, pregunta, respuesta, mt, lc);   
        contElim.EliminarEjercicio(ejc, lc, mt);
    }
}
