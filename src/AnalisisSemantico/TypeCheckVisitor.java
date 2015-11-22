/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Visitor.Visitor;
import ast.CallFunction;
import ast.Empty_Stmt;
import ast.ExprAsign;
import ast.ExprBynary;
import ast.ExprConst;
import ast.ExprVar;
import ast.ForStmt;
import ast.Param;
import ast.Program;
import ast.WhileStmt;
import ast.compound_stmt;
import ast.fun_declaration;
import ast.return_stmt;
import ast.selection_stmt;
import ast.var_declaration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Spartan Clase que recorre el arbol realizando el chequeo de tipos
 */

public class TypeCheckVisitor implements Visitor {

    public static ArrayList<Integer> VisitedNode = new ArrayList<>();
    private List<Declaration> Functions = new ArrayList<>();

    boolean searchFunction(Declaration d) {
        for (int i = 0; i < Functions.size(); i++) {
            if (d.id.equals(Functions.get(i).id)) {
                if (Functions.get(i).params.size() - 1 == d.params.size()) {
                    for (int j = 0; j < (d.params.size() - 1); j++) {
                        if (Functions.get(i).params.get(j).getTipo().equals(d.params.get(j).getTipo())) {
                            return true;//Esta declarada con los parametros correctos
                        }
                    }
                }
            }
        }
        return false; //No esta declarada o tiene otros parametros
    }

    @Override
    public void visit(Program visitor) {

    }

    @Override
    public void visit(var_declaration visitor) {

    }

    @Override
    public void visit(fun_declaration visitor) {

        Declaration d = new Declaration();
        d.id = visitor.getIdent();
        d.params = visitor.getChilds();
        d.fila = visitor.fila;
        if (!searchFunction(d)) {
            Functions.add(d);
        }

    }

    @Override
    public void visit(Param visitor) {

    }

    @Override
    public void visit(compound_stmt visitor) {

    }

    @Override
    public void visit(Empty_Stmt visitor) {

    }

    @Override
    public void visit(selection_stmt visitor) {
    }

    @Override
    public void visit(WhileStmt visitor) {

    }

    @Override
    public void visit(ForStmt visitor) {

    }

    @Override
    public void visit(return_stmt visitor) {

    }

    @Override
    public void visit(ExprAsign visitor) {

    }

    @Override
    public void visit(ExprVar visitor) {

    }

    @Override
    public void visit(ExprBynary visitor) {

    }

    @Override
    public void visit(ExprConst visitor) {

    }

    @Override
    public void visit(CallFunction visitor) {
//TODO: Pasar el numero de fila al callFunction
        Declaration d = new Declaration();
        d.id = visitor.getIdent();
        d.params = visitor.getChilds();
        d.fila = visitor.fila;
        if (visitor.getChilds().size()==0) {
            for (int i = 0; i < Functions.size(); i++) {
                if (Functions.get(i).getIdent() == d.id && Functions.get(i).type != "void") {
                    System.out.println("Error Semantico en fila " + d.fila + ", la funcion " + d.id + " no esta declarada o los parametros son erroneos");
                }
            }
        }else if (!searchFunction(d)) {
            System.out.println("Error Semantico en fila " + d.fila + ", la funcion " + d.id + " no esta declarada o los parametros son erroneos");
        }

    }

}
