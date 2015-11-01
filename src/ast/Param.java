package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.sym;
import Visitor.Visitor;

/**
 *
 * Clase que genera las declaraciones de parametros.
 */
public class Param extends Node {

    protected String ident;
    protected boolean corchetes;
    protected String valor;
    protected int tipos;

    public Param(int tipoEntrante, String id, boolean brack) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.corchetes = brack;
        this.tipos = tipoEntrante;
        this.ident = id;
        if (this.corchetes == false) {
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

    public boolean isCorchetes() {
        return corchetes;
    }

    public void setCorchetes(boolean corchetes) {
        this.corchetes = corchetes;
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
