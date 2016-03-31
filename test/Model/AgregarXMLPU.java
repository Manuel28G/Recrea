/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.ControllerAgregar;
import Controller.Util;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import javax.xml.parsers.ParserConfigurationException;
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
public class AgregarXMLPU {
    
    private final String imagen="default.png";
    private final String materia="Materia nueva";
    private final String leccion="Leccion nueva";
    private final String ejercicio="Ejercicio nuevo";
    private final String nivelMat="30";
    private final String nivelLec="20";
    private final String puntosEjc="10";
    
    private final String ptObtenidos="50";
    private final String pregunta="Pregunta 2893";
    private final String respuesta="Respuesta 7240";
    private final String fecha="01/01/2009";
    
    private final ControllerAgregar contAgr;
    private Materia mat;
    private Leccion lec;
    private Ejercicio ejc;
    
    public AgregarXMLPU() {
        contAgr=new ControllerAgregar();
        mat=new Materia();
        lec=new Leccion();
        ejc=new Ejercicio();
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown()  throws Exception {
        EliminarXML.BorrarMateria(materia);
    }

   @Test
   public void xmlAgregarMateria()  throws Exception {
       String xml=materia.replace(" ", "");
       int cont=ConsultarXML.ContarEtiquetas(Util.RUTA_MATERIA_XML, "");
       AgregarXML.XMLMateriasAdd(imagen, nivelMat, xml, materia);
       int cont2=ConsultarXML.ContarEtiquetas(Util.RUTA_MATERIA_XML, "");
       assertEquals(cont2, cont +1);
       
       
       
       
   }
   
   @Test
   public void xmlAgregarLeccion() throws Exception{
       mat=contAgr.AgregarMateria(imagen, nivelMat, materia);
       String ruta=Util.ARCHIVOS_XML_PATH+mat.getHijoURL();
       int cont=ConsultarXML.ContarEtiquetas(ruta, "");
       AgregarXML.XMLLeccionAdd(nivelLec, imagen, leccion, mat.getHijoURL());
       int cont2=ConsultarXML.ContarEtiquetas(ruta, "");
       assertEquals(cont2, cont +1);
       
   }
   
   @Test
   public void xmlAgregarEjercicio()throws Exception{
       
       mat=contAgr.AgregarMateria(imagen, nivelMat, materia);
       lec=contAgr.AgregarLeccion(nivelLec, imagen, leccion, mat);
       String ruta=Util.ARCHIVOS_XML_PATH+mat.getHijoURL();
       int cont=ConsultarXML.ContarEtiquetas(ruta,lec.getNombre());
       AgregarXML.XMLEjercicioAdd(Util.EJERCICIO_TIPO_BOTON, puntosEjc, pregunta, respuesta, mat.getHijoURL(), leccion, fecha);
       int cont2=ConsultarXML.ContarEtiquetas(ruta,lec.getNombre());
       assertEquals(cont2, cont +1);
   }
}
