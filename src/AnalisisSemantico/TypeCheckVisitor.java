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
import AnalisisSemantico.ScopeVisitor;
import ast.Node;
import Tablas.*;
import java.util.LinkedList;
import AnalisisSemantico.Util;

/**
 *
 * @author Spartan Clase que recorre el arbol realizando el chequeo de tipos
 */
public class TypeCheckVisitor implements Visitor {

    public static ArrayList<Integer> VisitedNode = new ArrayList<>();
    private List<Declaration> Functions = new ArrayList<>();
    public List<Node> asignaciones = new LinkedList<>();

    public TypeCheckVisitor() {
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
        Functions.add(d);

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

        asignaciones.add(visitor);
        Node local = visitor.getPadre();
        Node izq = visitor.getChilds().get(0);
        Node der = visitor.getChilds().get(1);
        Declaration vardecl;
        String tipoIzq = "";
        String tipoDer = "";
        //Comprobar tipo lado izquierdo
        //En el lado derecho solo pueden haber ExprVar
        for (int j = local.alcance.size() - 1; j >= 0; j--) {
            vardecl = local.alcance.get(j).get(izq.getIdent());
            if (vardecl != null) {
                tipoIzq = vardecl.type;
                if (tipoIzq == "intArray") {
                    tipoIzq = "int";
                }
                break;
            }
        }
        //Comprobar tipo lado Derecho   
        //En el lado derecho puede haber un ExprConst, un ExprVar, un callFunction o un ExprBynary
        switch (der.getKind()) {

            case ExprVar:
                for (int j = local.alcance.size() - 1; j >= 0; j--) {
                    vardecl = local.alcance.get(j).get(der.getIdent());
                    if (vardecl != null) {
                        tipoDer = vardecl.type;
                    }
                }
                break;
            case ExprBynary:
                tipoDer = Util.testBynaryExp(der, local);
                break;
            case ExprConst:
                tipoDer = der.getTipo();
                break;
            case CallFunction:
                break;
            default:
                throw new AssertionError(der.getKind().name());
        }

        if (tipoIzq.equals(tipoDer)) {

        } else {
            System.out.println("Error de Tipo en fila: " + visitor.fila + " La asignacion tiene parametros incompatibles");
        }
        Declaration d1 = new Declaration();
        Declaration d2 = new Declaration();
        d1.id = izq.getIdent();
        d1.params = izq.getChilds();
        d1.fila = izq.fila;
        d2.id = der.getIdent();
        d2.params = der.getChilds();
        d2.fila = der.fila;
        if (d1.getKind() == Kind.ExprVar) {
            boolean asign = Util.testIni(d1, asignaciones);
            if (asign == false) {
                System.out.println("Error de Tipo en fila: " + visitor.fila + ", la variable "+ d1.getIdent()+" no ha sido inicializada");
            }
        }
        if (d2.getKind() == Kind.ExprVar) {
            boolean asign = Util.testIni(d2, asignaciones);
            if (asign == false) {
                System.out.println("Error de Tipo en fila: " + visitor.fila + ", la variable "+ d2.getIdent()+" no ha sido inicializada");
            }
        }
    }

    @Override
    public void visit(ExprVar visitor
    ) {

    }

    @Override
    public void visit(ExprBynary visitor
    ) {

    }

    @Override
    public void visit(ExprConst visitor
    ) {

    }

    @Override
    public void visit(CallFunction visitor) {
        List<Declaration> overload = new LinkedList<>();
        Declaration d = new Declaration();
        d.id = visitor.getIdent();
        d.params = visitor.getChilds();
        d.fila = visitor.fila;
        for (int k = 0; k < Functions.size(); k++) {
            Declaration dec = Functions.get(k);
            if (dec.id.equals(d.id)) {
                overload.add(dec);
            }
        }
        if (overload.size() == 0) {
            System.out.println("Error de Tipo en fila: " + visitor.fila + " La funcion" + d.id + " no esta declarada");
        }
        Node local = visitor.getPadre();
        boolean test = true;
        test = Util.testFun(local, overload, d);
        if (test == false) {
            System.out.println("Error de Tipo en fila: " + visitor.fila + " La funcion " + d.id + " tiene parametros distintos o de distinto tipo");
        }

        //Se comprueba que los parametros esten inicializados
        boolean asign = Util.testIni(d, asignaciones);
        if (asign == false) {
            System.out.println("Error de Tipo en fila: " + visitor.fila + " Un parametro no ha sido inicializado");
        }

    }

}
