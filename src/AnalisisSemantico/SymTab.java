/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Tablas.*;
import ast.Node;
import AnalisisSemantico.FunctionDeclaration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Spartan Clase que se encarga de almacenar los simbolos encontrados en
 * los distintos alcances (scopes) del arbol construido en la etapa de sintaxis.
 */
public final class SymTab {

    public static final int PREDEFINED_SCOPE = 0, FUNCTION_SCOPE = 1, PARAMETER_SCOPE = 2,
            LOCAL_SCOPE = 3, INVALID_SCOPE = -1;

    /**
     * Lista que almacena los distintos alcances encontrados al reviasarl el
     * codigo. Guarda un objeto de tipo Declaration(declaracion) y un String
     * referido al Nombre del nodo.
     */
    public LinkedList<Hashtable<String, Declaration>> scopes = new  LinkedList<Hashtable<String, Declaration>>();
    public List<FunctionDeclaration> FunctionList = new ArrayList<>();

    public SymTab() {
        newScope();//se crea un alcance al procesar el programa.
    }

    public void newScope() {

        scopes.add(new Hashtable<String, Declaration>());//se añade un nuevo alcance a la lista
    }

//    public int getScope(String name) {
//        for (int i = scopes.size() - 1; i >= 0; i--) {
//            if (scopes.get(i).containsKey(name)) {
//                return i;
//            }
//        }
//        return 0;
//    }
    public void closeScope() {
        if (scopes.size() <= 1) {
            //Esto no deberia ocurrir nunca
            throw new RuntimeException("SymTab.closeScope() sobrepaso el limite de llamados!");
        }
        scopes.remove(scopes.size() - 1);
    }

    public boolean searchFunction(Declaration d) {

        for (int i = 0; i < FunctionList.size(); i++) {
            if (d.id.equals(FunctionList.get(i).id)) {
                if (FunctionList.get(i).params.size() == d.params.size()) {
                    for (int j = 0; j < (d.params.size() - 1); j++) {
                        //TODO:Verificar tipos
                        if (FunctionList.get(i).params.get(j).getIdent().equals(d.params.get(j).getIdent())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Establece la declaracion donde fue realizada un identificador
     *
     * @param declaration
     */
    public void set(Declaration declaration) {
        String name = declaration.id;
        FunctionDeclaration fd;
        boolean verify = false;
        //Se comprueba que no hayan procedimientos duplicados
        if (declaration.getKind() == Kind.fun_declaration) {
            verify = searchFunction(declaration);
//                fd = FunctionList.get(i);
//                System.out.println(declaration.id+": "+declaration.params.toString());
//                System.out.println(fd.id+": "+fd.params.toString());
            if (!verify) {
                System.out.println("Error Semantico en fila " + declaration.fila + ", funcion " + name + " ya fue delclarada con los mismos parametros");
            }
        }
        //Un identificador no puede ser redeclarado en alcances mas profundos
        for (int i = PARAMETER_SCOPE; i < scopes.size(); i++) {
            Declaration decl = scopes.get(i).get(name);
            if (decl != null) {
                System.out.println("Error Semantico en fila " + declaration.fila + ", " + name + " ya fue delclarada en fila " + decl.fila);
                return;
            }
        }
        // Redeclarar en el mismo alcance tampoco esta permitido
        Hashtable<String, Declaration> scope = scopes.get(scopes.size() - 1);
        Declaration decl = scope.get(name);
        if (decl != null) {
            System.out.println("Error Semantico en fila " + declaration.fila + ", " + name + " ya fue delclarada en fila " + decl.fila);
            return;
        }
        // De otra forma, se añade a la lista
        scope.put(name, declaration);
    }

    public int searchDeclaration(String id) {
        Declaration decl;
        for (int i = scopes.size() - 1; i >= 0; i--) {
            decl = scopes.get(i).get(id);
            if (decl != null) {
                id = decl.id;
                if (i >= LOCAL_SCOPE) {
                    return LOCAL_SCOPE;
                }
                return i;
            }
        }
        return INVALID_SCOPE;
    }

//    public void display() {
//        Iterator<Hashtable<String, Declaration>> it = scopes.iterator();
//        String padding = "";
//
//        while (it.hasNext()) {
//            Hashtable<String, Declaration> scope = it.next();
//
//            Iterator<String> its = scope.keySet().iterator();
//            while (its.hasNext()) {
//                String id = its.next();
//                System.out.println(padding + "\"" + id + "\"" + ": " + scope.get(id));
//            }
//
//            padding = padding + "  ";
//        }
//    }
}
