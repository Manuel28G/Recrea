package ControllerPU;

import Componentes.ComboBoxRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Controller.ControllerConsultar;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerConsultarPU {
    ControllerConsultar contCons;
    private static final String materiaNombre="Materia01";
    private final String leccionNombre="Leccion02";
    private final String ejercicio="Ejercicio03";
    private static final String puntos="0";
    private static final String imagen="default.png";
    private static Materia mt;
    
    public ControllerConsultarPU() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
     
      Controller.ControllerAgregar contAgre=new Controller.ControllerAgregar();
      ControllerConsultarPU.mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        contCons=new ControllerConsultar();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void obtenerRespuesta_NB(){
       NumberBoxRecrea nbRecrea=new NumberBoxRecrea();
       String texto="12345";
       nbRecrea.setText(texto);
       assertEquals(texto,contCons.ObtenerRespuesta(nbRecrea));
    }

     @Test
    public void obtenerRespuesta_TB(){
       TextBoxRecrea nbRecrea=new TextBoxRecrea();
       String texto="Prueba UNO";
       nbRecrea.setText(texto);
       assertEquals(texto,contCons.ObtenerRespuesta(nbRecrea));
    }
     @Test
    public void obtenerRespuesta_VF(){
       VFRecrea nbRecrea=new VFRecrea();
       String verdad="Verdadero";
       String falso="Falso";
       String vacio="";
       
       
       assertEquals(vacio,contCons.ObtenerRespuesta(nbRecrea));
       
       nbRecrea.rbFalso.setSelected(true);
       nbRecrea.rbVerdad.setSelected(false);
       assertEquals(falso,contCons.ObtenerRespuesta(nbRecrea));
       
       nbRecrea.rbFalso.setSelected(false);
       nbRecrea.rbVerdad.setSelected(true);
       assertEquals(verdad,contCons.ObtenerRespuesta(nbRecrea));
       
       
    }
    
    @Test
    public void cargarMateria(){
        List<Materia> materias;
        Materia materia;
        List<Ejercicio> ejercicios;
        Ejercicio ejercicio;
        List<Leccion> lecciones;
        Leccion leccion;
        
        
        materias= contCons.cargarMateria();
        materia=materias.get(0);
        assertNotNull(materia);
        
        lecciones=materia.getAsignaturas();
        leccion=lecciones.get(0);
        assertNotNull(leccion);
        
        ejercicios=leccion.getEjercicios();
        ejercicio=ejercicios.get(0);
        assertNotNull(ejercicio);
        
        materia= materias.get(materias.size()-1);
        assertEquals(materia.getHijoURL(),mt.getHijoURL());
        assertEquals(materia.getImagenURL(),mt.getImagenURL());
        assertEquals(materia.getNivel(),mt.getNivel());
        assertEquals(materia.getNombre(),mt.getNombre());
        assertEquals(materia.getRepaso(),mt.getRepaso());
    }
    
    @Test
    public void cargarComboBoxMateria(){
        ComboBoxRecrea cbRecrea=new ComboBoxRecrea();
        contCons.CargarComboBoxMateria(cbRecrea);
        int cbLimite=cbRecrea.getItemCount();
        for(int i=0;i<cbLimite;i++){
            assertNotSame("",cbRecrea.getItemAt(i));
            assertNotNull(cbRecrea.getItemAt(i));
        }
       String mat= (String)cbRecrea.getItemAt(cbRecrea.getItemCount()+-1);
       assertEquals(mat,mt.getNombre());
        
    }
    
}
