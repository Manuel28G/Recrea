/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerPU;

import Componentes.ComboBoxRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TAreaRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Controller.Util;
import Controller.Validaciones;
import Model.Objetos.EntidadGeneral;
import Model.Objetos.Respuesta;
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
public class ValidacionesPU {
    private final Validaciones validacion;
    private TextBoxRecrea tbRecrea;
    private NumberBoxRecrea nbRecrea;
    private final TAreaRecrea taRecrea;
    private VFRecrea vfRecrea;
    private final ComboBoxRecrea cbRecrea;
    private final EntidadGeneral entGen,entGen2,entGen3;
    private Respuesta respuesta;
    private List<Respuesta> respuestas;
    private int total= 46410;
    private int cantidad=7;
    
    public ValidacionesPU() {
        entGen=new EntidadGeneral();
        entGen2=new EntidadGeneral();
        entGen3=new EntidadGeneral();
        validacion=new Validaciones();
        taRecrea=new TAreaRecrea();
        cbRecrea=new ComboBoxRecrea();
        respuestas=new ArrayList<>();
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tbRecrea=new TextBoxRecrea();
        nbRecrea=new NumberBoxRecrea();
        vfRecrea=new VFRecrea();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void longituMaxTextField_TB(){
        tbRecrea.setText("123456789");//menos de 25 caracteres
        assertTrue(validacion.longituMaxTextField(tbRecrea));
        
        tbRecrea.setText("1234567891234567890123456");//25 caracteres
        assertTrue(validacion.longituMaxTextField(tbRecrea));
        
        tbRecrea.setText("12345678912345678901234562");//26 caracteres
        assertFalse(validacion.longituMaxTextField(tbRecrea));
    }
    
    @Test
    public void longituMaxTextField_NB(){
        nbRecrea.setText("1234567");//menos de 8 caracteres
        assertTrue(validacion.longituMaxTextField(nbRecrea));
        nbRecrea.setText("12345678");//8 caracteres
        assertTrue(validacion.longituMaxTextField(nbRecrea));
        nbRecrea.setText("123456789");//mas de 8 caracteres
        assertFalse(validacion.longituMaxTextField(nbRecrea));
    }
    
    @Test
    public void ValidarRespuestaVacia_TB(){
        tbRecrea.setText("");//vacio
        assertFalse(validacion.ValidarRespuestaVacia(tbRecrea));
        tbRecrea.setText(".");//caracter que no es letra ni numero
        assertFalse(validacion.ValidarRespuestaVacia(tbRecrea));
        tbRecrea.setText("M");//caracter alfabetico
        assertTrue(validacion.ValidarRespuestaVacia(tbRecrea));
        tbRecrea.setText("4");//caracter numérico
        assertTrue(validacion.ValidarRespuestaVacia(tbRecrea));
        tbRecrea.setText("LM28");//caracter alfanumérico
        assertTrue(validacion.ValidarRespuestaVacia(tbRecrea));
    }
    
     @Test
    public void ValidarRespuestaVacia_NB(){
        nbRecrea.setText("");//vacio
        assertFalse(validacion.ValidarRespuestaVacia(nbRecrea));
        nbRecrea.setText(".");//caracter que no es letra ni numero
        assertFalse(validacion.ValidarRespuestaVacia(nbRecrea));
        nbRecrea.setText("M");//caracter alfabetico
        assertTrue(validacion.ValidarRespuestaVacia(nbRecrea));
        nbRecrea.setText("4");//caracter numérico
        assertTrue(validacion.ValidarRespuestaVacia(nbRecrea));
        nbRecrea.setText("LM28");//caracter alfanumérico
        assertTrue(validacion.ValidarRespuestaVacia(nbRecrea));
    }
    
     @Test
    public void ValidarRespuestaVacia_VF_Vacio(){
        assertFalse(validacion.ValidarRespuestaVacia(vfRecrea));
    }
    
    @Test
    public void ValidarRespuestaVacia_VF_Verdadero(){
        vfRecrea.rbVerdad.setSelected(true);
        assertTrue(validacion.ValidarRespuestaVacia(vfRecrea));
        
    }
    
    @Test
    public void ValidarRespuestaVacia_VF_Falso(){
        vfRecrea.rbFalso.setSelected(true);
        assertTrue(validacion.ValidarRespuestaVacia(vfRecrea));
    }
     @Test
    public void ValidarRespuestaVacia_TA(){
        assertFalse(validacion.ValidarRespuestaVacia(taRecrea));
        taRecrea.setText("texto");
        assertTrue(validacion.ValidarRespuestaVacia(taRecrea));
        taRecrea.setText(" $%&..");//si no contiene un valor alfanumerico no es valido
        assertFalse(validacion.ValidarRespuestaVacia(taRecrea));
        taRecrea.setText(" $%&.. 123");//si no contiene un valor alfanumerico no es valido
        assertTrue(validacion.ValidarRespuestaVacia(taRecrea));
        taRecrea.setText("1234");//si no contiene un valor alfanumerico no es valido
        assertTrue(validacion.ValidarRespuestaVacia(taRecrea));
        taRecrea.setText("LM28");//si no contiene un valor alfanumerico no es valido
        assertTrue(validacion.ValidarRespuestaVacia(taRecrea));
    }
    
     @Test
    public void ValidarRespuestaVacia_CB(){
       entGen.setNombre(Util.COMBOBOX_SELECCIONAR);
       cbRecrea.AddItemRecrea(entGen);
       entGen2.setNombre("UNO");
       cbRecrea.AddItemRecrea(entGen2);
       entGen3.setNombre("DOS");
       cbRecrea.AddItemRecrea(entGen3);
       assertFalse(validacion.ValidarRespuestaVacia(cbRecrea));
       cbRecrea.setSelectedIndex(0);
       assertFalse(validacion.ValidarRespuestaVacia(cbRecrea));
       cbRecrea.setSelectedIndex(1);
       assertTrue(validacion.ValidarRespuestaVacia(cbRecrea));
       cbRecrea.setSelectedIndex(2);
       assertTrue(validacion.ValidarRespuestaVacia(cbRecrea));
    }
    
    @Test
    public void totalPuntos(){
        cantidad=13;
        assertEquals(0,validacion.totalPuntos(new ArrayList<Respuesta>()));
        int puntos=total/cantidad;
        for(int i=1;i<=cantidad;i++){
            respuesta=new Respuesta();
            respuesta.SetPuntoTotal(puntos);
            respuestas.add(respuesta);
        }
        assertEquals(total,validacion.totalPuntos(respuestas));
    }
    @Test
    public void totalPuntosObtenidos(){
        cantidad=13;
        assertEquals(0,validacion.totalPuntosObtenidos(new ArrayList<Respuesta>()));
        int puntos=total/cantidad;
        for(int i=1;i<=cantidad;i++){
            respuesta=new Respuesta();
            respuesta.SetPuntosObtenido(puntos);
            respuestas.add(respuesta);
        }
        assertEquals(total,validacion.totalPuntosObtenidos(respuestas));
    }
    
    @Test
    public void esCorrecta_Numero(){
        String correcta="12345";
        String respUser="0000012345";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_NUMERO));
        correcta="00000000000000000000000012345";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_NUMERO));
        correcta="000000000000000000000000123456";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_NUMERO));
        correcta="1235";
        respUser="2135";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_NUMERO));
    }
    
    @Test
    public void esCorrecta_Letras(){
        String correcta="respuesta 123";
        String respUser="respuesta 123";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="Respuesta 123j";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="Respuesta123";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="Respuesta1234";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="Respuesta 12345656";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="Rispoesta 123";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        //si la respuesta tiene una longitud menor o igual que 5 no se permite errores
        correcta="resp1";
        respUser="resp";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="resp2";
        assertFalse(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="resp1";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
        respUser="resp12";
        assertTrue(validacion.EsCorrecta(correcta, respUser,Util.RESPUESTA_TIPO_STRING));
    }
}
