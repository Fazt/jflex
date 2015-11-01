package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.sym;
import Visitor.Visitor;

/**
 * @author
 *
 */
public class var_declaration extends Node {

    protected String ident = "";
    protected boolean corchetes = false;
    protected String valor = "";

    public var_declaration(int tipoEntrante, String id, boolean brack, Integer num) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.corchetes = brack;
        this.ident = id;
        if (this.corchetes == false) {
            if (tipoEntrante == sym.VOID) {
                this.setTipo("void");
            } else {
                this.setTipo("int");
            }
        } else {
            this.setValor(num.toString());
            if (tipoEntrante == sym.VOID) {
                this.setTipo("void[" + this.getValor() + "]");
            } else {
                this.setTipo("int[" + this.getValor() + "]");
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
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

}
