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
    public static String IMAGE_CENTENA_PATH="src/Model/Image/Centena.png";
    public static String IMAGE_CERO_PATH="src/Model/Image/Cero.png";
    public static String IMAGE_DECENA_PATH="src/Model/Image/Decena.png";
    public static String IMAGE_DIVISION_PATH="src/Model/Image/Division.png";
    public static String IMAGE_FRACCION_PATH="src/Model/Image/Fraccion.png";
    public static String IMAGE_MULTIPLICACION_PATH="src/Model/Image/Multiplicacion.png";
    public static String IMAGE_NUMEROS_PATH="src/Model/Image/Numeros.png";
    public static String IMAGE_RESTA_PATH="src/Model/Image/Resta.png";
    public static String IMAGE_SUMA_PATH="src/Model/Image/Suma.jpg";
    public static String IMAGE_UNIDAD_PATH="src/Model/Image/Unidad.png";
    public static String IMAGE_PIZARRA_PATH="src/Model/Image/Pizarra.jpg";
    public static String IMAGE_TIZA_PATH="src/Model/Image/Tiza.png";
    
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
    
    //TAG generales para el area de práctica
    public static final String CONOCIENDO_TAG= "Conociendo";
    public static final String EJERCICIO_TAG= "Ejercicio";
    public static final String CONOCIENDOLOS_TAG= "Conociendolos";
    public static final String EJERCICIOS_TAG= "Ejercicios";

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
