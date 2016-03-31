/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.ControllerAgregar;
import Controller.Util;
import Model.Objetos.Actividad;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.jdom2.JDOMException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ConsultarXMLPU {
    
   private final String nombre="nombre";
   private final String apellido="apellido";
   private final String id="ML28";
   private final String rutaUsuario=Util.RUTA_PERSONA_XML;
   private final String rutaFalla=Util.ARCHIVOS_XML_PATH+"Recrea2016LYM28"+Util.ARCHIVO_XML;
   private final ControllerAgregar cAgre=new ControllerAgregar();
    
    public ConsultarXMLPU() throws ParserConfigurationException, SAXException, IOException, TransformerException{
        CrearXML.XMLPersona(nombre, apellido, id);
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
    public void archivoCreado() {
       assertFalse(ConsultarXML.archivoCreado(rutaFalla));
       assertTrue(ConsultarXML.archivoCreado(rutaUsuario));
       
    }
    
    @Test
    public void contarEtiqueta() throws IOException, Exception {
        
       assertEquals(4, ConsultarXML.ContarEtiquetas(rutaUsuario, ""));
       assertEquals(0, ConsultarXML.ContarEtiquetas(rutaUsuario, Util.PERSONA_ACTIVIDADES_TAG));
    }
    
    @Test
    public void contarEtiqueta_SubNodo() throws IOException, Exception{
        
       Actividad act=new Actividad();
       cAgre.AgregarActividadPersona(act);
       assertEquals(1,ConsultarXML.ContarEtiquetas(rutaUsuario,Util.PERSONA_ACTIVIDADES_TAG));
       cAgre.AgregarActividadPersona(act);
       assertEquals(2,ConsultarXML.ContarEtiquetas(rutaUsuario,Util.PERSONA_ACTIVIDADES_TAG));
    }
    
    @Test
    public void informacionEtiqueta() throws JDOMException, Exception{
      assertEquals( nombre,ConsultarXML.InformacionEtiqueta(rutaUsuario,"",0,""));
      assertEquals( apellido,ConsultarXML.InformacionEtiqueta(rutaUsuario,"",1,""));
      assertEquals( id,ConsultarXML.InformacionEtiqueta(rutaUsuario,"",2,""));
    }
    
    @Test
    public void informacionEtiqueta_Sub() throws IOException, Exception{
        Actividad act=new Actividad();
        String actividad="Actividad"+nombre;
        String puntos="10";
        String total="200";
        act.SetNombre(actividad);
        act.SetPtosObtenidos(puntos);
        act.SetPuntosTotales(total);
        cAgre.AgregarActividadPersona(act);
        
        int contAct=ConsultarXML.ContarEtiquetas(rutaUsuario, Util.PERSONA_ACTIVIDADES_TAG);
        assertEquals( actividad,ConsultarXML.InformacionEtiqueta(rutaUsuario,"",contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertEquals( puntos,ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.NOTA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertEquals( total,ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.NOTA_TOTAL_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertNotSame( "",ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.FECHA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertNotSame( "",ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.HORA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertNotSame("",ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.DIA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        
        assertNotNull(ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.FECHA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertNotNull(ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.HORA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
        assertNotNull(ConsultarXML.InformacionEtiqueta(rutaUsuario,Util.DIA_ATRIBUTE,contAct-1,Util.PERSONA_ACTIVIDADES_TAG));
    }
}
