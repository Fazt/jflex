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
import AnalisisSemantico.*;

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
        for (int i = 0; i < 10; i++) {
            dir[i] = DirectorioTrabajo + "/src/Programas/Kprogram" + (i + 1) + ".ks";
        }
//        String programatest1 = new String();
//        String programatest2 = new String();
//        programatest1= DirectorioTrabajo + "/src/Programas/P1_AllSyntax.ks";
//        programatest2= DirectorioTrabajo + "/src/Programas/P2_Prec-Asoc-Stmt.ks";
        System.out.println("Solo hay 7 programas disponibles");
        System.out.println("Si ingresa letras el programa se cerrará");
        System.out.println("Ingrese un numero del 1 al 7");
        Scanner entradaEscaner = new Scanner(System.in);
        int seleccion = entradaEscaner.nextInt();
        while (seleccion > 9 || seleccion < 1) {
            System.out.println("Error, ingrese un numero del 1 al 7");
            seleccion = entradaEscaner.nextInt();
        }
        Reader reader = new BufferedReader(new FileReader(dir[(seleccion-1)]));
//        Reader reader = new BufferedReader(new FileReader(programatest1));
//        int seleccion=9;
        Lectura(reader, seleccion);
    }

    public static void Lectura(Reader reader, int seleccion) {
        Lexer lexer = new Lexer(reader);
        parser par = new parser(lexer);
        String resultado;
        try {
            par.parse();
            //se uso el debuger para encontrar los errores de la gramatica
            //par.debug_parse(); 
            //Se crea la estructura visitor.
            GrapherVisitor visit = new GrapherVisitor();
            ScopeVisitor sVisit = new ScopeVisitor();
            TypeCheckVisitor tcVisit = new TypeCheckVisitor();
            //Se recorre el arbol para el analisis sintactico
            par.root.GrapherTree(visit);
            //primera pasada analisis semantico (analisis de alcance)
            par.root.ScopeTree(sVisit);
            //segunda pasada analisis semantico (typeCheck)
            //par.root.GrapherTree(tcVisit);
////            String cadenaGraph = visit.returnString(); //Cadena que contiene el grapher.
////            resultado = cadenaGraph;
////            crearDot(cadenaGraph, seleccion);
////            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            public static void crearDot(String RutaDot,Integer num){
        try {
                File rutaResult = new File(System.getProperty("user.dir")+ "/" + "Archivo"+ num +".dot");
                BufferedWriter wr = new BufferedWriter(new FileWriter(rutaResult));
                wr.write(RutaDot);
                wr.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
