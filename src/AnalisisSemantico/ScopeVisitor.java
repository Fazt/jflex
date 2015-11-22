/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Tablas.Type;
import Visitor.Visitor;
import ast.CallFunction;
import ast.Empty_Stmt;
import ast.ExprAsign;
import ast.ExprBynary;
import ast.ExprConst;
import ast.ExprVar;
import ast.ForStmt;
import ast.Node;
import ast.Param;
import ast.Program;
import ast.WhileStmt;
import ast.compound_stmt;
import ast.fun_declaration;
import ast.return_stmt;
import ast.selection_stmt;
import ast.var_declaration;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Spartan
 * Clase que recorre el arbol realizando el analisis de alcance
 */
public class ScopeVisitor implements Visitor{
    
    public static ArrayList<Integer> VisitedNode = new ArrayList<>();   
    SymTab st;

    @Override
    public void visit(Program visitor) {
      //  System.out.println("Semantica de Program");
        //Se inicializa la tabla y se crea el alcance predefinido
        st = new SymTab();
    }

    @Override
    public void visit(var_declaration visitor) {
//        System.out.println("Semantica de var_declaration");
        Declaration dec = new Declaration();
        dec.id=visitor.getIdent();
        dec.type = visitor.getTipo();
        dec.fila = visitor.fila;
        if (dec.type=="void"){
            System.out.println("Error Semantico, una variable no puede ser de tipo VOID");
           
        }else{st.set(dec);}
    }

    @Override
    public void visit(fun_declaration visitor) {
//        System.out.println("Semantica de fun_declaration");
        FunctionDeclaration fd = new FunctionDeclaration();
        fd.id=visitor.getIdent();
        fd.params=visitor.getChilds();
        while(st.scopes.size()>SymTab.FUNCTION_SCOPE){
            st.closeScope();
        }
        Declaration dec = new Declaration();
        dec.id=visitor.getIdent();
        dec.type = visitor.getTipo();
        dec.fila = visitor.fila;
        dec.setKind(visitor.getKind());
        dec.params=fd.params;
        st.newScope();//Se aumenta al alcance referente a las funciones
        st.set(dec);
        st.FunctionList.add(fd);
    }

    @Override
    public void visit(Param visitor) {
//        System.out.println("Semantica de Param");
        Declaration dec = new Declaration();
        dec.id=visitor.getIdent();
        dec.type = visitor.getTipo();
        dec.fila = visitor.fila;
        st.set(dec);
    }

    @Override
    public void visit(compound_stmt visitor) {
     //   System.out.println("Semantica de compound_stmt");
        st.newScope();
        
    }

    @Override
    public void visit(Empty_Stmt visitor) {
      //  System.out.println("Semantica de Empty_Stmt");
        st.closeScope();
    }

    @Override
    public void visit(selection_stmt visitor) {
     //   System.out.println("Semantica de selection_stmt");
      st.newScope();// Alcance referido a variables locales
    }

    @Override
    public void visit(WhileStmt visitor) {
     //   System.out.println("Semantica de WhileStmt");
      st.newScope();// Alcance referido a variables locales
    }

    @Override
    public void visit(ForStmt visitor) {
     //  System.out.println("Semantica de ForStmt");
      st.newScope();// Alcance referido a variables locales
    }

    @Override
    public void visit(return_stmt visitor) {
        st.closeScope();
     //   System.out.println("Semantica de return_stmt");
    }

    @Override
    public void visit(ExprAsign visitor) {
      //  System.out.println("Semantica de ExprAsign");
    }

    @Override
    public void visit(ExprVar visitor) {
     //   System.out.println("Semantica de ExprVar");
        Declaration decl = new  Declaration();
        decl.id=visitor.getIdent();
        decl.fila= visitor.fila;
        int scope= st.searchDeclaration(decl.id);
        if (scope== SymTab.INVALID_SCOPE){
            System.out.println("Error Semantico en fila "+decl.fila+", la variable "+ decl.id+" no ha sido declarada");
        }
    }

    @Override
    public void visit(ExprBynary visitor) {
     //   System.out.println("Semantica de ExprBynary");
    }

    @Override
    public void visit(ExprConst visitor) {
      //  System.out.println("Semantica de ExprConst");
    }

    @Override
    public void visit(CallFunction visitor) {
      //  System.out.println("Semantica de CallFunction");
    }
    
}
