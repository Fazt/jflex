package ast;

import AnalisisSemantico.Declaration;
import AnalisisSemantico.SymTab;
import java.util.Collections;
import Visitor.Visitor;
import Tablas.sym;
import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import java.util.Hashtable;
import java.util.LinkedList;


public class fun_declaration extends Node {

    protected String ident;
    protected int tipos;
    public SymTab st;
    public fun_declaration(int tipoLlega, String id, Node params, Node comp) {
        this.kind= Kind.fun_declaration;
        this.iNode = GrapherVisitor.nodeCount++;
        this.tipos = tipoLlega;
        this.ident = id;
        if (this.tipos == sym.VOID) {
            this.type = "void"; //Asignacion void.
        } else {
            this.type = "int"; //Asignacion int.
        }
        if (params != null) {
            this.childs.add(params);
            params.setPadre(this);
            while (true) {
                if (params.getHermano() == null) {//Si no hay mas hermanos se dejan de asignar padres
                    Collections.reverse(this.childs); 
                    break;
                }
                this.childs.add(params.getHermano());
                params.getHermano().setPadre(this);
                params = params.getHermano();
            }
        }
        this.childs.add(comp);
        if (comp != null) {
            comp.setPadre(this);
        }

    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public int getTipos() {
        return tipos;
    }

    public void setTipos(int tipos) {
        this.tipos = tipos;
    }

}
