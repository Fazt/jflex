/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Tablas.*;
import ast.Node;
import AnalisisSemantico.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Spartan Clase que se encarga de almacenar los simbolos encontrados en
 * los distintos alcances (scopes) del arbol construido en la etapa de sintaxis.
 */
public class SymTab {

    public static final int PREDEFINED_SCOPE = 0, CLASS_SCOPE = 1, MEMBER_SCOPE = 2, PARAMETER_SCOPE = 3,
            LOCAL_SCOPE = 4, INVALID_SCOPE = -1;

    /**
     * Lista que almacena los distintos alcances encontrados al reviasarl el
     * codigo. Guarda un objeto de tipo Declaration(declaracion) y un String
     * referido al Nombre del nodo.
     */
    public SymTab st;
    List<HashMap<String, Declaration>> scopes = new ArrayList<HashMap<String, Declaration>>();
    int scopeNumber = 0;

    public SymTab() {
        st = this;
        newScope();//se crea un alcance equivalente al alcance predefinido.
    }

    public void newScope() {

        scopes.add(new HashMap<String, Declaration>());//se añade un nuevo alcance a la lista
    }

    public int getScope(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                return i;
            }
        }
        return 0;
    }

    public void closeScope() {
        if (scopes.size() <= 1) {
            throw new RuntimeException("SymTab.closeScope() sobrepaso el limite de llamados!");
        }
        scopes.remove(scopes.size() - 1);
    }

    /**
     * Establece la declaracion donde fue realizada un identificador
     *
     * @param declaration
     */
    public void set(Declaration declaration) {
        String name = declaration.id;
        //Un identificador no puede ser redeclarado en alcances mas profundos
        for (int i = PARAMETER_SCOPE; i < scopes.size(); i++) {
            Declaration decl = scopes.get(i).get(name);
            if (decl != null) {
                System.out.println("Error Semantico en fila "+declaration.fila+ ", "+name + " ya fue delclarada en fila " + decl.fila);
              return;
            }
        }
        // Redeclarar en el mismo alcance tampoco esta permitido
        HashMap<String, Declaration> scope = scopes.get(scopes.size() - 1);
        Declaration decl = scope.get(name);
        if (decl != null) {
            System.out.println("Error Semantico en fila "+declaration.fila+ ", "+name + " ya fue delclarada en fila " + decl.fila);
            return;
        }
        // De otra forma, se añade a la lista
        scope.put(name, declaration);
    }

    public int linkDeclaration(String id) {
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

    public void display() {
        Iterator<HashMap<String, Declaration>> it = scopes.iterator();
        String padding = "";

        while (it.hasNext()) {
            HashMap<String, Declaration> scope = it.next();

            Iterator<String> its = scope.keySet().iterator();
            while (its.hasNext()) {
                String id = its.next();
                System.out.println(padding + "\"" + id + "\"" + ": " + scope.get(id));
            }

            padding = padding + "  ";
        }
    }

}
