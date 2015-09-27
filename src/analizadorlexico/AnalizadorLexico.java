/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import static analizadorlexico.Token.ERROR;
import static analizadorlexico.Token.ID;
import static analizadorlexico.Token.NUM;
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
     */
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String DirectorioTrabajo = System.getProperty("user.dir");
        String path = DirectorioTrabajo+"/src/analizadorlexico/Lexer.flex";
        generarLexer(path);
        String []dir = new String[5];
        for(int i=0;i<5;i++){
			dir[i]=DirectorioTrabajo+"/src/analizadorlexico/Kprogram"+(i+1)+".ks";
		}
        for(int i=0;i<5;i++){
			String res="Result"+(i+1)+".txt";
			File file = new File(res);
			PrintWriter writer;
			try{
				Reader reader = new BufferedReader(new FileReader(dir[i]));
				Lexer lexer = new Lexer (reader);
				String result="";
				while(true){
					Token token= lexer.yylex();
					if(token ==null){
						result=result+"\r\n FIN";
						writer = new PrintWriter(file);
						writer.print(result);
						writer.close();
						break;
					}else{
                                            if (token == ERROR){
                                                result=result+"Error, no existe token \r\n";
                                            }else if (token == ID || token == NUM){
                                            result=result+"(Simbolo: "+token+" "+lexer.lexeme+")\r\n";
                                            }else{
                                                result=result+"(Simbolo: "+token+")\r\n";
                                                }
                                            }
                                        }                             
			} catch (FileNotFoundException ex){
				Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

    }
    public static void generarLexer (String path){
        File file = new File (path);
        jflex.Main.generate(file);
    }
    
    
}
