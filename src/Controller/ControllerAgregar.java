
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
    
    public void AgregarMateria(String img,String nivl,String materia){
        String xml= materia.replace(" ", "");
        int maxLong=xml.length();
        if(maxLong>14)
            maxLong=15;
        xml=xml.substring(0,maxLong);
        Model.AgregarXML.XMLMateriasAdd(img,nivl, xml, materia);
    }
    
    public void AgregarLeccion(String nivel,String imagen,String leccion,String xmlFile){
        ControllerConsultar cc= new ControllerConsultar();
        Model.AgregarXML.XMLLeccionAdd(nivel,imagen,leccion,xmlFile);
    }
    
    
    public void AgregarEjercicio(String tipo,String puntos,String pregunta,String Respuesta,String xmlFile,String Leccion){
       Model.AgregarXML.XMLEjercicioAdd(tipo,puntos,pregunta,Respuesta,xmlFile,Leccion);
    }
    
    public void AgregarActividadPersona(Actividad actividad){
       actividad.SetDia(diaActual.format(date));
       actividad.SetFecha(fechaActual.format(date));
       actividad.SetHora(horaActual.format(date));
       Model.AgregarXML.XMLPersonaActAdd(actividad.GetFecha() ,actividad.GetHora(),
                                         actividad.GetDia(), actividad.GetPtosObtenidos(),
                                         actividad.GetNombre(),actividad.GetPuntosTotales());
        
    }
}
