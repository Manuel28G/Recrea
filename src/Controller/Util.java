/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author Manuel
 * @version 1.0
 */
public class Util {
    //Configuracion de botones 
    public static int BTPositionX=15;
    public static int BTPositionY=15;
    public static int BTSizeW=150;
    public static int BTSizeH=150;
    public static int BTCount=0;
    
    //Archivo de configuración
    public static final String CONFIGURACION_XML="Configuracion.xml";
    public static final String CONFIGURACION_TAG="Configuracion";
    public static final String CONFIGURACION_TIPO_EJERCICIO="EjercicioTipo";
    
    public static final String COMBOBOX_SELECCIONAR="-Seleccionar-";
    public static final String COMBOBOX_SELECCIONAR_MATERIA="-Seleccionar Materia-";
    public static final String COMBOBOX_SELECCIONAR_LECCION="-Seleccionar Leccion-";
    public static final String COMBOBOX_SELECCIONAR_TIPO="-Tipo de ejercicio-";
    public static final String BOTON_TIPO_OPCION="Opciones";
    public static final String BOTON_TIPO_SALIR="Regresar";
    public static final String BOTON_TIPO_SEGUIR="Seguiente";
    public static final String BOTON_TIPO_SONIDO="Sonido";
    
    public static final String NULL_TAG="null";
    //Directorio de imagenes
    public static final String IMAGE_PATH="src/Model/Image/";
    //Directorio de Archivos XML
    public static final String ARCHIVOS_XML_PATH = "src/Model/Archivos/";
    //Directorio donde se guardaran los archivos de recrea
    public static final String DIRECTORIO_RECREA="/Recrea Matemática";
    
    //Separador de directorio
    public static final String SEPARADOR_DIRECTORIO="/";
    //Terminales de archivos
    public static final String ARCHIVO_XML=".xml";
    public static final String ARCHIVO_PNG=".png";
    public static final String ARCHIVO_JPG=".jpg";
    
    
    //Los tags asociados a los archivos XML
    public static final String RUTA_MATERIA_XML="src/Model/Archivos/Materias.xml" ;
    public static final String MATERIAS_TAG= "Materias";
    public static final String MATERIA_CHILD= "Materia";
    public static final String PERSONA_XML="Persona";
    public static final String MATERIA_XML="Materias";//poner Materias.xml
    
    //Atributos que van dentro de las etiquetas XML
    public static final String FECHA_ATRIBUTE="Fecha";
    public static final String HORA_ATRIBUTE="Hora";
    public static final String NOTA_ATRIBUTE="Nota";
    public static final String NIVEL_ATRIBUTE="Nivel";
    public static final String XML_ATRIBUTE="XML";
    public static final String IMAGEN_ATRIBUTE="Imagen";
    public static final String TIPO_ATRIBUTE="Tipo";
    public static final String PREGUNTA_ATRIBUTE="Pregunta";
    public static final String DIA_ATRIBUTE="Dia";
    public static final String PUNTOS_ATRIBUTE="Puntos";
    //XML: PERSONA
   public static final String PERSONA_ACTIVIDADES_TAG="Actividades";
   public static final String PERSONA_ACTIVIDAD_CHILD="Actividad";
   public static final String PERSONA_NOMBRE_TAG="Nombre";
   public static final String PERSONA_APELLIDO_TAG="Apellido";
   public static final String PERSONA_ID_TAG="Identificador";
   
      //XML: GENERALES
    public static final String CONOCIENDOLOS_TAG= "Conociendolos";
    public static final String EJERCICIOS_TAG= "Ejercicios";
    public static final String EJERCICIO_TAG= "Ejercicio";
    public static final String CONOCIENDO_CHILD= "Conociendo";
    public static final String EJERCICIO_CHILD= "Ejercicio";
    public static final String LECCION_TAG="Leccion";
    
    
    
    public static final String CERO_TAG= "Conociendo el cero";
    public static final String NUMEROS_TAG= "Números";
    public static final String RECONUM_TAG= "Reconociendo los números";
    public static final String CANTIDADES_TAG= "Cantidades";
    public static final String POSICIONES_TAG= "Valor de posiciones";
    public static final String SUMANDO_TAG= "Sumando";
    public static final String RESTANDO_TAG= "Restando";
    public static final String MULTIPLICANDO_TAG= "Multiplicando";
    public static final String DIVIDIENDO_TAG= "Dividiendo";
    public static final String SUCESIONES_TAG= "Sucesiones";
    public static final String PROPIEDADES_TAG= "Propiedades";
    public static final String PARIMPAR_TAG= "¿Par o Impar?";
    public static final String MULTIPLOS_TAG= "Mis multiplos";
    
    //Rutas a sub etiquetas
    public static final String RUTE_NUMERO_CONOCIENDO="Numero/Conociendolos";
    public static final String RUTE_NUMERO_EJERCICIO="Numero/Ejercicios";
    public static final String RUTE_CERO_CONOCIENDO="";
    public static final String RUTE_CERO_EJERCICIO="";
    
 


    //Errores
    public static final String ERROR_XML_EMPTY_FILE = "Error loading XML file - The file is empty";
    public static final String ERROR_XML_PROCESSING_FILE = "Error loading XML file - It's not possible processing the file";
    public static final String ERROR_XML_PROFESSOR_ID_NOT_EXIST = "Error loading XML file - The professor don't exist";  
    public static final String ERROR_PIECE_ID_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    public static final String ERROR_PIECE_SUPVAL_TAG = "Error loading Piece from XML - Error in the attribute of the XML tag";
    public static final String ERROR_PIECE_LOWVAL_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    public static final String ERROR_PIECE_IMAGEA_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    public static final String ERROR_PIECE_IMAGEB_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    public static final String ERROR_PIECE_IMAGEI_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    public static final String ERROR_PIECE_IMAGED_TAG = "Error loading Piece from XML - Error in the attribute  of the XML tag";
    

    
}
