/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;

import Controller.ControllerCrear;
import Model.Objetos.Persona;
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
public class ControllerCrearPU {
    private final String usuarioN="Nombre";
    private final String usuarioA="Apellido";
    private Persona usuario;
    
    public ControllerCrearPU() {
        
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
    }

    @Test
    public void crearUsuario(){
        usuario=ControllerCrear.CrearUsuario(usuarioN, usuarioA);
        assertNotNull(usuario);
        assertEquals(usuario.getNombre(),usuarioN);
        assertEquals(usuario.getApellido(),usuarioA);
    }
    //retorna siempre true a menos que hay una excepcion
    @Test
    public void crearArchivoMateria(){
        
      assertTrue(ControllerCrear.archivoMateria());
      
    }
}
