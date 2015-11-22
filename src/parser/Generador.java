package parser;
import java.io.File;
import java.io.IOException;
import java_cup.*;
public class Generador {

    public static void main(String[] args) throws internal_error, IOException, Exception {
    	String[] argv = new String[7];
    	//Directorio destino: "src/parser"
    	argv[0] = "-destdir";
    	argv[1] = "src"+File.separator+"parser";
    	//Nombre del paquete: "Parser"
    	argv[2] = "-package";
    	argv[3] = "Parser";
    	//Nombre de la clase: "Parser"
    	argv[4] = "-parser";
    	argv[5] = "parser";
    	//Archivo fuente.
    	argv[6] = "src"+File.separator+"parser"+ File.separator + "Parser.cup";
    	//Generar
    	java_cup.Main.main(argv);
    }
    
}