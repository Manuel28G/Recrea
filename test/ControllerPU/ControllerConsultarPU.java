package ControllerPU;

import Componentes.ComboBoxRecrea;
import Componentes.NumberBoxRecrea;
import Componentes.TextBoxRecrea;
import Componentes.VFRecrea;
import Controller.ControllerAgregar;
import Controller.ControllerConsultar;
import Controller.ControllerCrear;
import Controller.ControllerEliminar;
import Controller.Util;
import Model.Objetos.Actividad;
import Model.Objetos.Ejercicio;
import Model.Objetos.EntidadGeneral;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import Model.Objetos.Persona;
import Model.Objetos.Respuesta;
import java.io.File;
import java.util.ArrayList;
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
    
    private final String materiaNombre="Materia01";
    private final String leccionNombre="Leccion02";
    private final String preguntaEjc="Pregunta 01";
    private final String respuestaEjc="Respuesta 02";
    private final String usuarioN="Nombre";
    private final String usuarioA="Apellido";
    private final String nivel="1";
    private final String puntos="0";
    private final String imagen="default.png";
    private final ControllerAgregar contAgre=new ControllerAgregar();
    private final ControllerEliminar contElim=new ControllerEliminar();
    private Materia mt;
    private Leccion lc;
    private Ejercicio ejc;
    private Persona usr;
    private Actividad act,act2;
    private ControllerConsultar contCons;
    
    public ControllerConsultarPU() {
       mt=new Materia();
       lc=new Leccion();
       ejc=new Ejercicio();
    }
    
    @BeforeClass
    public static void setUpClass() {
     
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
        contElim.EliminarMateria(mt);
        contElim.EliminarLeccion(lc, mt);
        contElim.EliminarEjercicio(ejc, lc, mt);
    }
    
    @Test
    public void imagenDefault(){
        File imagenFile=new File(Util.RUTA_SRC+Util.IMAGE_PATH+ imagen);
        assertTrue(imagenFile.exists());
    }
    //Obtener respuesta
    @Test
    public void obtenerRespuesta_NB(){
       NumberBoxRecrea nbRecrea=new NumberBoxRecrea();
       String texto="12345";
       nbRecrea.setText(texto);
       assertEquals(texto,contCons.ObtenerRespuesta(nbRecrea));
    }
    
    @Test
    public void obtenerRespuesta_TB(){
       TextBoxRecrea tbRecrea=new TextBoxRecrea();
       String texto="Prueba UNO";
       tbRecrea.setText(texto);
       assertEquals(texto,contCons.ObtenerRespuesta(tbRecrea));
    }
    
    @Test
    public void obtenerRespuesta_VF_Vacio(){
       VFRecrea vfRecrea=new VFRecrea();
       String vacio="";
       assertEquals(vacio,contCons.ObtenerRespuesta(vfRecrea));
        
    }
    
    @Test
    public void obtenerRespuesta_VF_Vacio_Falso(){
       VFRecrea vfRecrea=new VFRecrea();
       String falso="Falso";
       vfRecrea.rbFalso.setSelected(true);
       vfRecrea.rbVerdad.setSelected(false);
       assertEquals(falso,contCons.ObtenerRespuesta(vfRecrea));
        
    }   
    
    @Test
    public void obtenerRespuesta_VF_Verdad(){
       VFRecrea vfRecrea=new VFRecrea();
       String verdad="Verdadero";
       vfRecrea.rbFalso.setSelected(false);
       vfRecrea.rbVerdad.setSelected(true);
       assertEquals(verdad,contCons.ObtenerRespuesta(vfRecrea));
        
    }
    //FIN de Obtener respuesta
    
    //Obtener tipo de respuesta
    @Test
    public void obtenerTipoRespuesta_NB(){
       NumberBoxRecrea nbRecrea=new NumberBoxRecrea();
       String texto=Util.RESPUESTA_TIPO_NUMERO;
       assertEquals(texto,contCons.ObtenerTipoRespuesta(nbRecrea));
    }
    
    @Test
    public void obtenerTipoRespuesta_TB(){
       TextBoxRecrea nbRecrea=new TextBoxRecrea();
       String texto=Util.RESPUESTA_TIPO_STRING;
       assertEquals(texto,contCons.ObtenerTipoRespuesta(nbRecrea));
    }
    
    @Test
    public void obtenerTipoRespuesta_VF(){
       VFRecrea vfRecrea=new VFRecrea();
       String texto=Util.RESPUESTA_TIPO_STRING;
       assertEquals(texto,contCons.ObtenerTipoRespuesta(vfRecrea));
       
    }
    //FIN de Obtener tipo de respuesta
    
    //Cargar Materia
    @Test
    public void cargarMateria_Materias(){
        List<Materia> materias;
        Materia materia;
        
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
        
        materias= contCons.cargarMateria();
        materia=materias.get(materias.size()-1);
        assertNotNull(materia);
        
        assertEquals(mt.getHijoURL(),materia.getHijoURL());
        assertEquals(mt.getImagenURL(),materia.getImagenURL());
        assertEquals(mt.getNivel(),materia.getNivel());
        assertEquals(mt.getNombre(),materia.getNombre());
        assertEquals(mt.getRepaso(),materia.getRepaso());
        assertEquals(mt.getAsignaturas(),materia.getAsignaturas());
        
    }
    
    @Test
    public void cargarMateria_Leccion(){
        List<Materia> materias;
        List<Leccion> lecciones;
        Leccion leccion;
        
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
        lc=contAgre.AgregarLeccion(nivel, imagen, leccionNombre, mt);
        
        materias= contCons.cargarMateria();
        mt=materias.get(materias.size()-1);
        
        lecciones=mt.getAsignaturas();
        leccion=lecciones.get(lecciones.size()-1);
        assertNotNull(leccion);
        
        assertEquals(lc.getImagenURL(),leccion.getImagenURL());
        assertEquals(lc.getNivel(),leccion.getNivel());
        assertEquals(lc.getNombre(),leccion.getNombre());
        assertEquals(lc.getEjercicios(),leccion.getEjercicios());
    } 
    
    @Test
    public void cargarMateria_Ejercicio(){
        List<Ejercicio> ejercicios;
        List<Materia> materias;
        List<Leccion> lecciones;
        Ejercicio ejcNuevo;
        
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
        lc=contAgre.AgregarLeccion(nivel, imagen,leccionNombre, mt);
        ejc=contAgre.AgregarEjercicio(Util.EJERCICIO_TIPO_BOTON, puntos, preguntaEjc, respuestaEjc, mt, lc);
      
        materias= contCons.cargarMateria();
        mt=materias.get(materias.size()-1);
        
        lecciones=mt.getAsignaturas();
        lc=lecciones.get(lecciones.size()-1);
        
        ejercicios=lc.getEjercicios();
        ejcNuevo=ejercicios.get(ejercicios.size()-1);
        
        assertEquals(ejc.getEjercicio(),ejcNuevo.getEjercicio());
        assertEquals(ejc.getImagenURL(),ejcNuevo.getImagenURL());
        assertEquals(ejc.getNivel(),ejcNuevo.getNivel());
        assertEquals(ejc.getNombre(),ejcNuevo.getNombre());
        assertEquals(ejc.getPuntos(),ejcNuevo.getPuntos());
        assertEquals(ejc.getRespuesta(),ejcNuevo.getRespuesta());
        assertEquals(ejc.getTipo(),ejcNuevo.getTipo());
        
        
    }
    //FIN de Cargar Materia
    
    //Cargar ComboBox
    @Test
    public void cargarComboBoxMateria(){
        ComboBoxRecrea cbRecrea=new ComboBoxRecrea();
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
        contCons.CargarComboBoxMateria(cbRecrea);
        int cbLimite=cbRecrea.getItemCount();
        for(int i=0;i<cbLimite;i++){
            assertNotSame("",cbRecrea.getItemAt(i));//El nombre que se muestra es distinto de vacio
            assertNotNull(cbRecrea.getItemAt(i));
        }
       String mat= (String)cbRecrea.getItemAt(cbRecrea.getItemCount()-1);
       assertEquals(mat,mt.getNombre());
       
       cbRecrea.setSelectedIndex(cbRecrea.getItemCount()-1);
       Materia materia=(Materia)cbRecrea.GetItemRecrea();
       
       assertEquals(mt.getHijoURL(),materia.getHijoURL());
       assertEquals(mt.getImagenURL(),materia.getImagenURL());
       assertEquals(mt.getNivel(),materia.getNivel());
       assertEquals(mt.getNombre(),materia.getNombre());
       assertEquals(mt.getRepaso(),materia.getRepaso());
       assertEquals(mt.getAsignaturas(),materia.getAsignaturas());
    }
    
    @Test
    public void cargarComboBoxLeccion(){
        ComboBoxRecrea cbRecrea=new ComboBoxRecrea();
        Leccion lc2,lc3,leccion;
        List<Leccion> lecciones=new ArrayList<>();
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre);   
        lc=contAgre.AgregarLeccion(nivel, imagen, leccionNombre, mt);
        lc2=contAgre.AgregarLeccion(nivel+"1", imagen, leccionNombre+"1", mt);
        lc3=contAgre.AgregarLeccion(nivel+"2", imagen, leccionNombre+"2", mt);
        
        //agrupamos las lecciones en una lista para evaluar si al meterlo en el 
        //combobox sigue siendo igual
        
        lecciones.add(lc);
        lecciones.add(lc2);
        lecciones.add(lc3);
        mt.setAsignaturas(lecciones);
        
        contCons.CargarComboBoxLeccion(cbRecrea,mt);
        int cbLimite=cbRecrea.getItemCount();
        
        //Evaluamos el "-Seleccionar-"
        assertNotSame("",cbRecrea.getItemAt(0));
        assertNotNull(cbRecrea.getItemAt(0));
        
        for(int i=1;i<cbLimite;i++){
            lc=lecciones.get(i-1);
            assertNotSame("",cbRecrea.getItemAt(i));//El nombre que se muestra es distinto de vacio
            assertNotNull(cbRecrea.getItemAt(i));
            cbRecrea.setSelectedIndex(i);
            leccion=(Leccion)cbRecrea.GetItemRecrea();
            assertEquals(lc.getNombre(),leccion.getNombre());
            assertEquals(lc.getImagenURL(),leccion.getImagenURL());
            assertEquals(lc.getNivel(),leccion.getNivel());
            assertEquals(lc.getEjercicios(),leccion.getEjercicios());
        }
        
    }

    @Test
    public void cargarComboBoxEjercicio(){
        ComboBoxRecrea cbRecrea=new ComboBoxRecrea();
        Ejercicio ejercicio;
        List<Ejercicio> ejercicios=new ArrayList<>();
        
        mt=contAgre.AgregarMateria(imagen, puntos, materiaNombre); 
        lc=contAgre.AgregarLeccion(nivel, imagen, leccionNombre, mt);
        ejercicio=contAgre.AgregarEjercicio(Util.EJERCICIO_TIPO_ESCRIBIR, puntos, preguntaEjc, respuestaEjc, mt, lc);
        
        //agrupamos las lecciones en una lista para evaluar si al meterlo en el 
        //combobox sigue siendo igual
        
        ejercicios.add(ejercicio);
        lc.setEjercicios(ejercicios);
        
        contCons.CargarComboBoxEjercicio(cbRecrea, lc);
        int cbLimite=cbRecrea.getItemCount();
        
        //Evaluamos el "-Seleccionar-"
        assertNotSame("",cbRecrea.getItemAt(0));
        assertNotNull(cbRecrea.getItemAt(0));
        
        for(int i=1;i<cbLimite;i++){
            ejc=ejercicios.get(i-1);
            assertNotSame("",cbRecrea.getItemAt(i));//El nombre que se muestra es distinto de vacio
            assertNotNull(cbRecrea.getItemAt(i));
            cbRecrea.setSelectedIndex(i);
            ejercicio=(Ejercicio)cbRecrea.GetItemRecrea();
            assertEquals(ejc.getEjercicio(),ejercicio.getEjercicio());
            assertEquals(ejc.getImagenURL(),ejercicio.getImagenURL());
            assertEquals(ejc.getNivel(),ejercicio.getNivel());
            assertEquals(ejc.getNombre(),ejercicio.getNombre());
            assertEquals(ejc.getPuntos(),ejercicio.getPuntos());
            assertEquals(ejc.getRespuesta(),ejercicio.getRespuesta());
            assertEquals(ejc.getTipo(),ejercicio.getTipo());
        }
        
    }

    @Test
    public void cargarComboBoxTipo(){
      EntidadGeneral entidad;
      ComboBoxRecrea cbRecrea=new ComboBoxRecrea();
      contCons.CargarComboBoxTipoEjercicio(cbRecrea);
      int cbLimite=cbRecrea.getItemCount();
      //si hay un error aqui es porque no existe el archivo de configuracion.xml
      assertTrue(cbLimite>0);
      
      for(int i=0;i<cbLimite;i++){
          cbRecrea.setSelectedIndex(i);
          entidad=cbRecrea.GetItemRecrea();
          assertNotSame("",cbRecrea.getItemAt(i));//El nombre que se muestra es distinto de vacio
          assertNotNull(cbRecrea.getItemAt(i));
       }
    }
    //FIN Cargar comboBox
    
    @Test
    public void cargarPersona(){
       ControllerCrear.CrearUsuario(usuarioN, usuarioA);
       usr=contCons.CargarPersona();
       List<Actividad> actividades=new ArrayList<>();
       
       assertNotNull(usr);
       assertEquals(usuarioN, usr.getNombre());
       assertEquals(usuarioA, usr.getApellido());
       assertEquals(new ArrayList<>(),usr.getActividades());
       
       act=new Actividad(new ArrayList<Respuesta>(),this.leccionNombre,this.puntos,this.puntos,"Lunes","28/03/2016","3:24");
       contAgre.AgregarActividadPersona(act);
       act2=new Actividad(new ArrayList<Respuesta>(),this.leccionNombre+"1",this.puntos+"1",this.puntos+"1","Lunes"+"1","28/03/2016"+"1","3:24"+"1");
       contAgre.AgregarActividadPersona(act2);
       
       actividades.add(act);
       actividades.add(act2);
       
       usr=contCons.CargarPersona();
       
       assertNotNull(usr);
       assertEquals(usuarioN, usr.getNombre());
       assertEquals(usuarioA, usr.getApellido());
       int cont=0;
       for(Actividad actividad:usr.getActividades()){
         act=actividades.get(cont);
         assertEquals(act.GetHora(),actividad.GetHora());
         assertEquals(act.GetFecha(),actividad.GetFecha());
         assertEquals(act.GetDia(),actividad.GetDia());
         assertEquals(act.GetNombre(),actividad.GetNombre());
         assertEquals(act.GetPtosObtenidos(),actividad.GetPtosObtenidos());
         assertEquals(act.GetPuntosTotales(),actividad.GetPuntosTotales());
         assertEquals(act.GetRespuesta(),actividad.GetRespuesta());
         cont++;
       }
    }

    @Test
    public void consultarUsuario(){
       assertTrue(ControllerConsultar.consultarUsuario());
       contElim.EliminarUsuario(usr);
       assertFalse(ControllerConsultar.consultarUsuario());
    }
 
}
