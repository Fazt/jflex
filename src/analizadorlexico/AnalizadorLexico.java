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
        String []dir = new String[5]; // Se crea un arreglo de strings en donde se guardaran las rutas de los programas a analizar
        for(int i=0;i<5;i++){
			dir[i]=DirectorioTrabajo+"/src/analizadorlexico/Kprogram"+(i+1)+".ks";//Cada programa tiene un nombre predefinido por default.
		}
        for(int i=0;i<5;i++){ 
			String res="Result"+(i+1)+".txt"; //Se crea un string con el nombre del archivo donde se guardaran los resultados
			File file = new File(res);
			PrintWriter writer;
			try{
				Reader reader = new BufferedReader(new FileReader(dir[i]));
				Lexer lexer = new Lexer (reader); //Se llama al analizador Lexico entregandole un programa para que lo analice
				String result=""; // String que guardará el resultado del análisis
				while(true){ 
					Token token= lexer.yylex(); //Se Analiza cada Token encontrado
					if(token ==null){  //Si el token es nulo
						result=result+"\r\n FIN"; 
						writer = new PrintWriter(file);
						writer.print(result);
						writer.close();
						break;
					}else{
                                            if (token == ERROR){ //Si el token no es reconocido
                                                result=result+"Error, no existe token \r\n"; 
                                            }else if (token == ID){ // Si el token es reconocido como un identificador
                                            result=result+"(Identificador: "+" "+lexer.lexeme+")\r\n";
                                            }else if (token == NUM){ // Si el token es reconocido como un número
                                            result=result+"(Numero: "+" "+lexer.lexeme+")\r\n";    
                                            }else if (token==ELSE ||token==IF ||token==INT ||token==VOID ||token==RETURN ||token==WHILE ||token==FOR){  //Si el token es alguna palabra reservada
                                                result=result+"(Palabra reservada: "+token+")\r\n";
                                            }else{ //Si es cualquier otro token definido
                                                result=result+"(Simbolo: "+token+")\r\n";
                                                }
                                            }
                                        }                             
			} catch (FileNotFoundException ex){ // Si no se encuentra el archivo se captura el error
				Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

    }
    /**
     * Metodo que se encarga de crear el archivo Lexer.lex
     * Recibe por parametro la ruta donde se desea crear el archivo.
     */
    public static void generarLexer (String path){
        File file = new File (path);
        jflex.Main.generate(file);
    }
    
}
    
