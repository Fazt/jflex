package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Visitor.Visitor;


public class return_stmt extends Node {

    protected int tipos;

    public return_stmt(Node exp) {
        this.kind= Kind.return_stmt;
        this.iNode = GrapherVisitor.nodeCount++;
        if (exp != null) {
            this.setValor(exp.getTipo());;
            if (exp != null) {
                exp.setPadre(this);
                this.childs.add(exp);
            }
            this.childs.add(exp);
            this.setTipo(exp.getTipo());
        } else {
            this.setTipo("void");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
