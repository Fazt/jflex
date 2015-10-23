/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import analizadorlexico.*;
import Parser.parser.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Spartan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        String DirectorioTrabajo = System.getProperty("user.dir");
        String[] dir = new String[5];
        for (int i = 0; i < 5; i++) {
            dir[i] = DirectorioTrabajo + "/src/analizadorlexico/Kprogram" + (i + 1) + ".ks";//Cada programa tiene un nombre predefinido por default.
        }
        Reader reader = new BufferedReader(new FileReader(dir[0]));
        System.out.println(reader.hashCode());
        Scanner lexer = new Scanner(reader);
        System.out.println(lexer.yytext());
        Parser.parser Parser = new Parser.parser(lexer);
        System.out.println(Parser.producciones);

    }
}
