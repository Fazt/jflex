/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import GraphVisitor.GrapherVisitor;
import analizadorlexico.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import parser.parser;


/**
 *
 * @author Spartan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

        String DirectorioTrabajo = System.getProperty("user.dir");
        String[] dir = new String[6];
        for (int i = 0; i < 6; i++) {
            dir[i] = DirectorioTrabajo + "/src/Programas/Kprogram" + (i + 1) + ".ks";
        }
        Reader reader = new BufferedReader(new FileReader(dir[3]));
        Scanner lexer = new Scanner(reader);
        parser par = new parser(lexer);
        String resultado;
        try{
                par.parse();
                //par.debug_parse();
    		//Se crea la estructura visitor.
    		GrapherVisitor vist = new GrapherVisitor();
    		//Se obtiene el nodo raiz.
    		par.root.recorrerArbol(vist);
    		String cadenaGraph = vist.retornaCadenaGraph(); //Cadena que contiene el grapher.
    		resultado = cadenaGraph;
                System.out.println(resultado);
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
    }
    
      
}
