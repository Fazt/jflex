/*
 * Proyecto Analizador Lexico para ramo Compiladores 
 * segundo semestre años 2015.
 * Desarrollado por Fernando Arrigorriaga y Arnoldo Moreno
 */
package analizadorlexico;
//
import static analizadorlexico.Token.ELSE;
import static analizadorlexico.Token.ERROR;
import static analizadorlexico.Token.FOR;
import static analizadorlexico.Token.ID;
import static analizadorlexico.Token.IF;
import static analizadorlexico.Token.INT;
import static analizadorlexico.Token.NUM;
import static analizadorlexico.Token.RETURN;
import static analizadorlexico.Token.VOID;
import static analizadorlexico.Token.WHILE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
