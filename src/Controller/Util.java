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
    
    public static final String RESPUESTA_TIPO_NUMERO="Número";
    public static final String RESPUESTA_TIPO_STRING="Caracter";
    
    public static final String COMPONENTE_TEXTBOX_RECREA="TextBoxRecrea";
    public static final String COMPONENTE_NUMBERBOX_RECREA="NumberBoxRecrea";
    public static final String COMPONENTE_BOTON_RECREA="BotonRecrea";
    public static final String COMPONENTE_BOTONSALIR_RECREA="BotonSalirRecrea";
    public static final String COMPONENTE_BOTONSEGUIR_RECREA="BotonSeguirRecrea";
    public static final String COMPONENTE_VF_RECREA="VFRecrea";
    public static final String COMPONENTE_TEXTAREA_RECREA="TAreaRecrea";
    public static final String COMPONENTE_COMBOBOX_RECREA="ComboBoxRecrea";
    
    public static final String TITULO_PREG_BOTONES="Selecciona la respuesta correcta";
    public static final String TITULO_PREG_TEXTBOX_NUMEROS="Escribe tu respuesta en números";
    public static final String TITULO_PREG_TEXTBOX_LETRAS="Escribe tu respuesta en letras";
    public static final String TITULO_PREG_VERDADERO_FALSO="¿Verdadero o falso?";
    public static final String TITULO_PREG_PREGUNTA="Pregúnta";
    public static final String TITULO_PREG_CONTENIDO="Contenido";
    public static final String TITULO_RESPUESTA="Respuesta";
    
    public static final String RUTA_SONIDO_CLICK="/Model/Sonido/Click1.wav";
    public static final String RUTA_SONIDO_SOBREBOTON="/Model/Sonido/Boton1.wav";
    public static final String RUTA_SONIDO_CORRECTO="/Model/Sonido/Win.wav";
    public static final String RUTA_SONIDO_EQUIVOCADO="/Model/Sonido/Fail.wav";
    
    
    public static final String LETRA_TIPO_TAHOMA="Tahoma";
    
    public static final String FORMATO_FECHA="dd/MM/yyyy";
    public static final String FORMATO_DIA_SEMANA="EEEE";
    public static final String FORMATO_HORA="HH:mm:ss";

    public static final String SEPARADOR_DE=" de ";
    //Configuracion
    public static final String CONFIG_TAMAÑO_LETRA_MED="MEDIANO";
    public static final String CONFIG_TAMAÑO_LETRA_INTERMED="INTERMEDIO";
    public static final String CONFIG_TAMAÑO_LETRA_PEQUE="PEQUEÑO";
    public static final String CONFIG_TAMAÑO_LETRA_GRANDE="GRANDE";
    public static final int MAX_COLUMNAS_TEXTAREA=284;//esto es el tamaño del text area equivale a 17 columnas
    
    public static final String CONFIG_COLOR_LETRA_NEGRO="NEGRO";
    public static final String CONFIG_COLOR_LETRA_BLANCO="BLANCO";
    public static final String CONFIG_COLOR_LETRA_ROJO="ROJO";
    public static final String CONFIG_COLOR_LETRA_AZUL="AZUL";
    
    //tipo de ejercicio
    public static final String EJERCICIO_TIPO_BOTON="Botones";
    public static final String EJERCICIO_TIPO_ESCRIBIR="Escribir";
    public static final String EJERCICIO_TIPO_VF="Verdadero-Falso";
    public static final String EJERCICIO_TIPO_RESP_NUMERO="Número";
    public static final String EJERCICIO_TIPO_RESP_LETRA="Letras";
    
    public static final String RESPUESTA_VF_VERDADERO="Verdadero";
    public static final String RESPUESTA_VF_FALSO="Falso";
    
    public static final String SALTO_DE_LINEA="\n";
    //Configuracion de botones 
    public static int BTPositionX=15;
    public static int BTPositionY=15;
    public static int BTSizeW=150;
    public static int BTSizeH=150;
    public static int BTCount=0;
    //Expreciones regulares
    public static final String EXPR_SOLOTEXTO=".*[A-Z]|[a-z]|[ \\t\\n\\x0b\\r\\f].*";
    public static final String EXPR_SOLOENTEROS=".*[0-9].*";
    public static final String EXPR_ENTEROyTEXTO=".*[A-Z]|[a-z]|[0-9].*";
    
    
    //Archivo de configuración
    public static final String CONFIGURACION_XML="Configuracion.xml";
    public static final String CONFIGURACION_TAG="Configuracion";
    public static final String CONFIGURACION_TIPO_EJERCICIO="EjercicioTipo";
    
    public static final String COMBOBOX_SELECCIONAR="-Seleccionar-";
    public static final String COMBOBOX_SELECCIONAR_MATERIA="-Seleccionar Materia-";
    public static final String COMBOBOX_SELECCIONAR_LECCION="-Seleccionar Leccion-";
    public static final String COMBOBOX_SELECCIONAR_TIPO="-Tipo de ejercicio-";
    public static final String COMBOBOX_SINRESPUESTA="Sin respuesta";
    public static final String BOTON_TIPO_OPCION="Opciones";
    public static final String BOTON_TIPO_SALIR="Regresar";
    public static final String BOTON_TIPO_SEGUIR="Seguiente";
    public static final String BOTON_TIPO_SONIDO="Sonido";
    public static final String BOTON_TIPO_CARITA="Carita";//para los botones del resultado de carita feliz o triste
    
    public static final String ETIQUETA_NOMBRE="NombreEtiqueta";
    
    public static final String NULL_TAG="null";
    public static final String RUTA_SRC="src";
    //Directorio de imagenes
    public static final String IMAGE_PATH="/Model/Image/";
    public static final String IMAGEN_RESALTADO="Resaltar";
    public static final String IMAGEN_SONIDO="Sonido.png";
    public static final String IMAGEN_CARITA_FELIZ="CaritaFeliz.png";
    public static final String IMAGEN_CARITA_TRISTE="CaritaTriste.png";
    public static final String IMAGEN_SEGUIR="Seguir.png";
    public static final String IMAGEN_SALIR="Salir.png";
    public static final String IMAGEN_REGRESAR="Regresar.png";
    public static final String IMAGEN_DEFAULT="Default.png";
    public static final String IMAGEN_ICONO="RecreaIcono.png";
    public static final String IMAGEN_AVATAR="AvatarM1.png";
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
    public static final String RUTA_PERSONA_XML="src/Model/Archivos/Persona.xml";
    public static final String MATERIAS_TAG= "Materias";
    public static final String MATERIA_CHILD= "Materia";
    public static final String PERSONA_XML="Persona";
    public static final String MATERIA_XML="Materias";//poner Materias.xml
    
    //Atributos que van dentro de las etiquetas XML
    public static final String FECHA_ATRIBUTE="Fecha";
    public static final String HORA_ATRIBUTE="Hora";
    public static final String NOTA_ATRIBUTE="Nota";
    public static final String NOTA_TOTAL_ATRIBUTE="NotaTotal";
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
    public static final String ERROR_OPERACION_FALLIDA="ERROR- La operacion ha fallado,vuelva a intentarlo";
    //Dialogos
    public static final String DIALOG_CONFIRMAR_SALIDA="¿Seguro que desea salir? si confirma se perderá el avance realizado.";
    public static final String DIALOG_CONFIRMAR_ELIMINAR_USUARIO="¿Seguro desea eliminar el usuario? \n -si confirma se perderá el avance realizado y los datos asociados a la cuenta.";
    public static final String DIALOG_TITULO_SALIDA="Salir";
    public static final String DIALOG_TITULO_MENSAJE="Mensaje";
    public static final String DIALOG_CONFIRMAR_CONTINUAR="No ha respondido el ejercicio,se contara la respuesta como incorrecta directamente \n¿seguro que desea continuar?";

    
    //Mensajes
    public static final String MENSAJE_PERSONA_BORRADA="¡El usuario fue borrado con exito! \n Gracias por usar recrea, vuelva pronto. ";
    public static final String MENSAJE_APROBADA="¡Correcto,Felicitaciones!";
    public static final String MENSAJE_FALLIDO="Lo siento, no es correcto";
    public static final String MENSAJE_NOAPLICA="No aplica";
    public static final String MENSAJE_COLOCAR_DATOS="Debes colocar tus datos para comenzar";
    public static final String MENSAJE_NOHAYREGISTRO="Aún no se han realizado actividades en Recrea. \n ¡vuelva pronto!";
    public static final String MENSAJE_NOHAYLECCION="Disculpe esta Materia aún no tiene lecciones asignadas.";
    public static final String MENSAJE_NOHAYEJERCICIOS="Disculpe esta lección aún no tiene ejercicios asignados.";
    public static final String MENSAJE_MATERIA_BORRADA="La materia ha sido borrada con exito.";
    public static final String MENSAJE_LECCION_BORRADA="La lección ha sido borrada con exito.";
    public static final String MENSAJE_EJERCICIO_BORRADO="El ejercicio ha sido borrado con exito.";
    public static final String MENSAJE_MATERIA_AGREGADA="La materia ha sido agregada con exito."; 
    public static final String MENSAJE_LECCION_AGREGADA="La lección ha sido agregada con exito.";
    public static final String MENSAJE_EJERCICIO_AGREGADO="El ejercicio ha sido agregado con exito.";
    
}
