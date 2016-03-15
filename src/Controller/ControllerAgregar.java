
package Controller;

import Model.Objetos.Actividad;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerAgregar {
    
    private final DateFormat fechaActual = new SimpleDateFormat(Util.FORMATO_FECHA);//formato que queremos para guardar en el xml
    private final DateFormat horaActual = new SimpleDateFormat(Util.FORMATO_HORA);//formato que queremos para guardar en el xml
    private final DateFormat diaActual = new SimpleDateFormat(Util.FORMATO_DIA_SEMANA);
    private final Date date=new Date(); //fecha actual

    /**
     * Método para agregar una matéria al sistema
     * @param img imagen que se desea asociar a la matéria
     * @param nivl nivel de dificultad de la matéria
     * @param materia nombre de la matéria que se desea crear
     * @return Materia agregada
     */
    public Materia AgregarMateria(String img,String nivl,String materia){
        Materia respuesta=new Materia();
        String xml= materia.replace(" ", "");
        int maxLong=xml.length();
        if(maxLong>14)
            maxLong=15;
        xml=xml.substring(0,maxLong);
        Model.AgregarXML.XMLMateriasAdd(img,nivl, xml, materia);
        
        respuesta.setImagenURL(img);
        respuesta.setHijoURL(xml+Util.ARCHIVO_XML);
        respuesta.setNivel(Integer.parseInt(nivl));
        respuesta.setNombre(materia);
        return respuesta;
    }
    /**
     * Método para agregar una lección al sistema
     * @param nivel nivel de dificultad de la lección
     * @param imagen imagen a desplegar en pantalla para la lección
     * @param leccion nombre de la lección
     * @param materiaObj Materia que contiene la ruta del documento previemente creado donde se alojarán las lecciones
     * @return Leccion creada
     */
    public Leccion AgregarLeccion(String nivel,String imagen,String leccion,Materia materiaObj){
  
        Leccion leccionObj=new Leccion();
        String xmlFile=materiaObj.getHijoURL();
        Model.AgregarXML.XMLLeccionAdd(nivel,imagen,leccion,xmlFile);
        leccionObj.setImagenURL(imagen);
        leccionObj.setNivel(Integer.parseInt(nivel));
        leccionObj.setNombre(imagen);
        return leccionObj;
        
    }
    
    /**
     * 
     * @param tipo tipo de ejercicio Boton:Numero, Verdadero o falso etc..
     * @param puntos puntos del ejercicio
     * @param pregunta pregunta que se realizará o contenido que se desplegará
     * @param Respuesta respuesta correcta para el ejercicio
     * @param materiaObj matéria previemente creado donde se alojarán los ejercicios
     * @param leccionObj lección donde se añadirá los ejercicios
     * @return Ejercicio creado
     */
    public Ejercicio AgregarEjercicio(String tipo,String puntos,String pregunta,String Respuesta,Materia materiaObj,Leccion leccionObj){
       Ejercicio ejercicioObj=new Ejercicio();
       String xmlFile=materiaObj.getHijoURL();
       String Leccion=leccionObj.getNombre();
       Model.AgregarXML.XMLEjercicioAdd(tipo,puntos,pregunta,Respuesta,xmlFile,Leccion);
       ejercicioObj.setEjercicio(pregunta);
       ejercicioObj.setPuntos(Integer.parseInt(puntos));
       ejercicioObj.setRespuesta(Respuesta);
       ejercicioObj.setTipo(tipo);
       return ejercicioObj;
    }
    
    /**
     * Método para agregar una actividad nueva al usuario
     * @param actividad actividad a asignar al usuario
     */
    public void AgregarActividadPersona(Actividad actividad){
       actividad.SetDia(diaActual.format(date));
       actividad.SetFecha(fechaActual.format(date));
       actividad.SetHora(horaActual.format(date));
       Model.AgregarXML.XMLPersonaActAdd(actividad.GetFecha() ,actividad.GetHora(),
                                         actividad.GetDia(), actividad.GetPtosObtenidos(),
                                         actividad.GetNombre(),actividad.GetPuntosTotales());
        
    }
}
