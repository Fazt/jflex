package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.*;
import Visitor.Visitor;
import java.util.Collections;


public class Param extends Node {

    protected String ident;
    protected boolean brackets;
    protected String valor;
    protected int tipos;

    public Param(int tipoEntrante, String id, boolean brack) {
        this.kind= Kind.Param;
        this.iNode = GrapherVisitor.nodeCount++;
        this.brackets = brack;
        this.tipos = tipoEntrante;
        this.ident = id;
        if (this.brackets == false) {
            if (this.tipos == sym.VOID) {
                this.type = "void";
            } else {
                this.type = "int";
            }
        } else {
            if (this.tipos == sym.VOID) {
                this.type = "void[]";
            } else {
                this.type = "int[]";
            }
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

    public boolean getBrackets() {
        return brackets;
    }

    public void setBrackets(boolean corchetes) {
        this.brackets = corchetes;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getTipos() {
        return tipos;
    }

    public void setTipos(int tipos) {
        this.tipos = tipos;
    }

}
