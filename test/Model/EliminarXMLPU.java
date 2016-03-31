/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.ControllerAgregar;
import Controller.ControllerCrear;
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
public class EliminarXMLPU {
    
    private final String nombreP="Persona Nombre";
    private final String apellidoP="Persona Apellido";
    private final String idP="LYM28";
    private final ControllerAgregar contAgre;
    private final String imagen="default.png";
    private Materia mat;
    private final String nombreMat="Materia 20";
    private final String nivelMat="12";
    private Leccion lec;
    private final String nombreLec="Leccion 010";
    private final String nivelLec="10";
    private Ejercicio ejc;
    private final String pregunta="Ejercicio 540";
    private final String respuesta="20";
    private final String puntosEjc="150";
    private String ruta;
    
    public EliminarXMLPU() {
        contAgre=new ControllerAgregar();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mat=new Materia();
        lec=new Leccion();
        ejc=new Ejercicio();
        
        mat=contAgre.AgregarMateria(imagen, nivelMat, nombreMat);
        lec=contAgre.AgregarLeccion(nivelLec, imagen, nombreLec, mat);
        ejc=contAgre.AgregarEjercicio(Util.EJERCICIO_TIPO_ESCRIBIR, puntosEjc, pregunta, respuesta, mat, lec);
         ruta=Util.ARCHIVOS_XML_PATH+mat.getHijoURL();
    }
    
    @After
    public void tearDown() throws Exception {
        EliminarXML.BorrarMateria(mat.getNombre());
    }

    @Test
    public void borrarPersona(){
        ControllerCrear.CrearUsuario(nombreP, apellidoP);
        assertTrue(ConsultarXML.archivoCreado(Util.RUTA_PERSONA_XML));
        EliminarXML.BorrarPersona();
        assertFalse(ConsultarXML.archivoCreado(Util.RUTA_PERSONA_XML));
        ControllerCrear.CrearUsuario(nombreP, apellidoP);
    }
    
    @Test
    public void borrarArchivo(){
        
        ControllerCrear.CrearUsuario(nombreP, apellidoP);
        assertTrue(ConsultarXML.archivoCreado(Util.RUTA_PERSONA_XML));
        EliminarXML.BorrarArchivo(Util.RUTA_PERSONA_XML);
        assertFalse(ConsultarXML.archivoCreado(Util.RUTA_PERSONA_XML));
        ControllerCrear.CrearUsuario(nombreP, apellidoP);
    }
    
    @Test
    public void borrarMateria() throws Exception{
      
        assertTrue(ConsultarXML.archivoCreado(ruta));
        String archivo=Util.ARCHIVOS_XML_PATH+mat.getHijoURL();
        EliminarXML.BorrarMateria(mat.getNombre());
        assertFalse(ConsultarXML.archivoCreado(ruta));
    }
    
    @Test
    public void borrarLeccion() throws  Exception{
        int cont=ConsultarXML.ContarEtiquetas(ruta, "");
        assertEquals(lec.getNombre(),ConsultarXML.InformacionEtiqueta(ruta, "",cont-1, ""));
        EliminarXML.BorrarLeccion(lec.getNombre(), mat.getHijoURL());
        int cont2=ConsultarXML.ContarEtiquetas(ruta, "");
        assertEquals(cont2,cont - 1);
    }
    
    @Test
    public void borrarEjercicio() throws Exception{
        int cont=ConsultarXML.ContarEtiquetas(ruta,lec.getNombre() );
        assertEquals(ejc.getRespuesta(),ConsultarXML.InformacionEtiqueta(ruta, "",cont-1,lec.getNombre().trim()));
        
        EliminarXML.BorrarEjercicio(lec.getNombre(), ejc.getNombre(), mat.getHijoURL());
        int cont2=ConsultarXML.ContarEtiquetas(ruta,lec.getNombre() );
        assertEquals(cont2,cont-1);
    }
}
