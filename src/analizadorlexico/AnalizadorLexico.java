/*
 * Proyecto Analizador Lexico para ramo Compiladores 
 * segundo semestre años 2015.
 * Desarrollado por Fernando Arrigorriaga y Arnoldo Moreno
 */
package analizadorlexico;
//
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Spartan
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * metodo principal que ejecuta el programa y crea el archivo lexer.java
     * que se encarga de analizar el contenido de los Kprogram almacenados
     * en el directorio.
     */
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String DirectorioTrabajo = System.getProperty("user.dir"); //se obtiene el directorio en donde se esta ejecutando el programa
        String path = DirectorioTrabajo+"/src/analizadorlexico/Lexer.flex"; //Se designa el directorio donde se encuentra el archivo Lexer.flex
        generarLexer(path); // Se llama al metodo generar Lexer
    }
    /**
     * Metodo que se encarga de crear el archivo Lexer.lex
     * Recibe por parametro la ruta donde se desea crear el archivo.
     * @param path
     */
    public static void generarLexer (String path){
        File file = new File (path);
        jflex.Main.generate(file);
    }
    
}
    
