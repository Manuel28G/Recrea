/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Util;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class CrearXMLPU {
    private final String archivo="Archivoprueba2016";
    private final String archivoRuta=Util.ARCHIVOS_XML_PATH+archivo+Util.ARCHIVO_XML;
    private final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    private final DocumentBuilder db = dbf.newDocumentBuilder();
    private final String nombre="nombre 2016";
    private final String apellido="apellido 2016";
    private final String id="123456";
    private final String archivoUsuario=Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML;
    
    
    public CrearXMLPU() throws ParserConfigurationException {
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
       Model.EliminarXML.BorrarArchivo(archivoRuta);
    }

    @Test
    public void xmlBasic() throws ParserConfigurationException, SAXException, IOException, TransformerException{
       
        assertFalse(ConsultarXML.archivoCreado(archivoRuta));
        CrearXML.XMLBasic(archivo);
        assertTrue(ConsultarXML.archivoCreado(archivoRuta));
    }
    
    @Test
    public void crearXML() throws SAXException, IOException, ParserConfigurationException, TransformerException {
        
        File archivoFile=new File(Util.ARCHIVOS_XML_PATH+Util.PERSONA_XML+Util.ARCHIVO_XML);
        Document document = db.parse(archivoFile);  
        assertFalse(ConsultarXML.archivoCreado(archivoRuta));
        CrearXML.CrearXML(document,archivo+Util.ARCHIVO_XML);
        assertTrue(ConsultarXML.archivoCreado(archivoRuta));
        
    }
    
    @Test
    public void xmlPersona() throws ParserConfigurationException, SAXException, IOException, TransformerException{
        CrearXML.XMLPersona(nombre, apellido, id);
        assertTrue(ConsultarXML.archivoCreado(archivoUsuario));
    }
    
}
