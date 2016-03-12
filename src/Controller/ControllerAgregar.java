
package Controller;

import Model.Objetos.Actividad;
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
     */
    public void AgregarMateria(String img,String nivl,String materia){
        String xml= materia.replace(" ", "");
        int maxLong=xml.length();
        if(maxLong>14)
            maxLong=15;
        xml=xml.substring(0,maxLong);
        Model.AgregarXML.XMLMateriasAdd(img,nivl, xml, materia);
    }
    /**
     * Método para agregar una lección al sistema
     * @param nivel nivel de dificultad de la lección
     * @param imagen imagen a desplegar en pantalla para la lección
     * @param leccion nombre de la lección
     * @param xmlFile ruta del documento de la matéria previemente creado donde se alojarán las lecciones
     */
    public void AgregarLeccion(String nivel,String imagen,String leccion,String xmlFile){
        ControllerConsultar cc= new ControllerConsultar();
        Model.AgregarXML.XMLLeccionAdd(nivel,imagen,leccion,xmlFile);
    }
    
    /**
     * 
     * @param tipo tipo de ejercicio Boton:Numero, Verdadero o falso etc..
     * @param puntos puntos del ejercicio
     * @param pregunta pregunta que se realizará o contenido que se desplegará
     * @param Respuesta respuesta correcta para el ejercicio
     * @param xmlFile ruta del documento de la matéria previemente creado donde se alojarán los ejercicios
     * @param Leccion nombre de la lección donde se añadirá los ejercicios
     */
    public void AgregarEjercicio(String tipo,String puntos,String pregunta,String Respuesta,String xmlFile,String Leccion){
       Model.AgregarXML.XMLEjercicioAdd(tipo,puntos,pregunta,Respuesta,xmlFile,Leccion);
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
