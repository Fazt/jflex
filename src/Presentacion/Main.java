/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Scanner;
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
    public static void main(String[] args) throws IOException, Exception {

        Interfaz();
    }

    public static void Interfaz() throws FileNotFoundException {
        String DirectorioTrabajo = System.getProperty("user.dir");
        String[] dir = new String[1000];
        for (int i = 0; i < 8; i++) {
            dir[i] = DirectorioTrabajo + "/src/Programas/Kprogram" + (i + 1) + ".ks";
        }
        System.out.println("Solo hay 7 programas disponibles");
        System.out.println("Si ingresa letras o numeros fuera del rango el programa se cerrará");
        System.out.println("Ingrese un numero del 1 al 8");
        
        Scanner entradaEscaner = new Scanner(System.in);
        int seleccion = entradaEscaner.nextInt();
        if (seleccion > 8 || seleccion < 1) {
            System.out.println("Error, ingrese un numero del 1 al 8");
            seleccion = entradaEscaner.nextInt();
        }
        seleccion-=1;
        Reader reader = new BufferedReader(new FileReader(dir[(seleccion)]));
        Lectura(reader);
    }

    public static void Lectura(Reader reader) {

        Lexer lexer = new Lexer(reader);
        parser par = new parser(lexer);
        String resultado;
        try {
            par.parse();
            //se uso el debuger para encontrar los errores de la gramatica
            //par.debug_parse(); 
            //Se crea la estructura visitor.
            GrapherVisitor vist = new GrapherVisitor();
            //Se obtiene el nodo raiz.
            par.root.Tree(vist);
            String cadenaGraph = vist.returnString(); //Cadena que contiene el grapher.
            resultado = cadenaGraph;
            System.out.println(resultado);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
