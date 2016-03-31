
package Controller;

import Model.AgregarXML;
import Model.Objetos.Actividad;
import Model.Objetos.Ejercicio;
import Model.Objetos.Leccion;
import Model.Objetos.Materia;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuel Goncalves L.
 */
public class ControllerAgregar {
    
    private final DateFormat fechaActual = new SimpleDateFormat(Util.FORMATO_FECHA);//formato que queremos para guardar en el xml
    private final DateFormat horaActual = new SimpleDateFormat(Util.FORMATO_HORA);//formato que queremos para guardar en el xml
    private final DateFormat diaActual = new SimpleDateFormat(Util.FORMATO_DIA_SEMANA);
    private final Date date=new Date(); //fecha actual
    private final ControllerConsultar cc=new ControllerConsultar();

    /**
     * Metodo para asignar el nombre a los archivos de manera que no sean tan
     * largos y no contengan espacios 
     * @param cadena nombre de la lección o materia que se basará para crear el archivo
     * @return nombre del archivo
     */
    private String longitudNombre(String cadena){
        String xml= cadena.replace(" ", "");
        int maxLong=xml.length();
        if(maxLong>14)
            maxLong=15;
        xml=xml.substring(0,maxLong);
        return xml;
    }
    
    /**
     * Método para agregar una matéria al sistema
     * @param img imagen que se desea asociar a la matéria
     * @param nivl nivel de dificultad de la matéria
     * @param materia nombre de la matéria que se desea crear
     * @return Materia agregada , NULL: si ocurrio un error
     */
    public Materia AgregarMateria(String img,String nivl,String materia){
        try{
        Materia respuesta=new Materia();
        String xml=this.longitudNombre(materia);
        AgregarXML.XMLMateriasAdd(img,nivl, xml, materia);
        respuesta.setImagenURL(img);
        respuesta.setHijoURL(xml+Util.ARCHIVO_XML);
        respuesta.setNivel(Integer.parseInt(nivl));
        respuesta.setNombre(materia);
        respuesta.setAsignaturas(new ArrayList<Leccion>());
        return respuesta;
        }
        catch(IOException | NumberFormatException | ParserConfigurationException | TransformerException | SAXException ex){
            return null;
        }
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
    try{
        Leccion leccionObj=new Leccion();
        String xmlFile=materiaObj.getHijoURL();
        AgregarXML.XMLLeccionAdd(nivel,imagen,leccion,xmlFile);
        leccionObj.setImagenURL(imagen);
        leccionObj.setNivel(Integer.parseInt(nivel));
        leccionObj.setNombre(leccion);
        leccionObj.setEjercicios(new ArrayList<Ejercicio>());
        return leccionObj;
    }
    catch(IOException | NumberFormatException | ParserConfigurationException | TransformerException | SAXException ex){
        return null;
    }
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
      try{
       Ejercicio ejercicioObj=new Ejercicio();
       String xmlFile=materiaObj.getHijoURL();
       String Leccion=leccionObj.getNombre();
       String fechaAct=cc.fechaActual();
       AgregarXML.XMLEjercicioAdd(tipo,puntos,pregunta,Respuesta,xmlFile,Leccion,fechaAct);
       ejercicioObj.setEjercicio(pregunta);
       ejercicioObj.setPuntos(Integer.parseInt(puntos));
       ejercicioObj.setRespuesta(Respuesta);
       ejercicioObj.setTipo(tipo);
       ejercicioObj.setNombre(fechaAct);
       return ejercicioObj;
      }
      catch(IOException | NumberFormatException | ParserConfigurationException | TransformerException | SAXException ex){
          return null;
      }
    }
    
    /**
     * Método para agregar una actividad nueva al usuario
     * @param actividad actividad a asignar al usuario
     * @return True: si agrego la actividad, False: si ocurrio un error
     */
    public boolean AgregarActividadPersona(Actividad actividad){
      try{
       actividad.SetDia(diaActual.format(date));
       actividad.SetFecha(fechaActual.format(date));
       actividad.SetHora(horaActual.format(date));
       AgregarXML.XMLPersonaActAdd(actividad.GetFecha() ,actividad.GetHora(),
                                         actividad.GetDia(), actividad.GetPtosObtenidos(),
                                         actividad.GetNombre(),actividad.GetPuntosTotales());
        return true;
      }
      catch(IOException | ParserConfigurationException | TransformerException | SAXException ex){
         System.out.println (ex);
         return false;
      }
    }
    
    /**
     * Método par aasignar una imagen a un boton
     * @param img imagen que se desea asignar
     * @param boton boton al que se le asignara la imagen
     * @return True: si se completo la asignación, false: si ocurrio un error
     */
    public  boolean agregarImagenBoton(String img,JButton boton){
        boolean resp=false;
        try{
        String rutaImagen=Util.RUTA_SRC+Util.IMAGE_PATH+img;
        String rutaImagenR=Util.RUTA_SRC+Util.IMAGE_PATH+Util.IMAGEN_RESALTADO+img;
        ImageIcon imagenIcon=new ImageIcon(rutaImagen);
        File resaltadoF=new File(rutaImagenR);//se le coloca la carpeta src/ ya que para el file la ruta se especifica desde la raiz
        boton.setIcon(imagenIcon);
        if(resaltadoF.exists()){
            ImageIcon resaltado=new ImageIcon(resaltadoF.getPath());
            boton.setRolloverIcon(resaltado);  //cambia la imagen al poner el mouse sobre el boton
        }
        resp=true;}
        catch(Exception ex)
        {
            return resp;
        }
        return resp;
    }
}
