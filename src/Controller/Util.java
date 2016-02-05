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
    
    //Directorio de imagenes
    public static final String IMAGE_PATH="src/Model/Image/";
    //Directorio de Archivos XML
    public static final String ARCHIVOS_XML_PATH = "src/Model/Archivos/";
    
    //Los tags asociados a los archivos XML
    public static final String MATERIA_TAG= "Materias";
    
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
    
    //TAG generales para el area de práctica
    public static final String CONOCIENDO_TAG= "Conociendo";
    public static final String EJERCICIO_TAG= "Ejercicio";
    public static final String CONOCIENDOLOS_TAG= "Conociendolos";
    public static final String EJERCICIOS_TAG= "Ejercicios";
    public static final String HIJO_XML_TAG="xml";
    public static final String IMAGEN_TAG="imagen";
    public static final String NIVEL_TAG="nivel";
    public static final String TIPO_TAG="tipo";
    public static final String PREGUNTA_TAG="pregunta";

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
