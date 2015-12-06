package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Visitor.Visitor;

//Nodo que controla los llamados  
public class CallFunction extends Node {

    protected String id;

    public CallFunction(String id, Node arg) {
        this.kind= Kind.CallFunction;
        this.iNode = GrapherVisitor.nodeCount++;
        this.type = "Identifier";
        this.id = id;
        if (arg != null) {
            this.setValor(arg.getValor());
            this.childs.add(arg);
            arg.setPadre(this);

            while (true) {
                if (arg.getHermano() == null) {
                    break;
                }
                this.childs.add(arg.getHermano());
                arg.getHermano().setPadre(this);
                arg = arg.getHermano();
            }
        }
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public String getIdent() {
        return this.id;
    }

    public void setIdent(String ident) {
        this.id = ident;
    }
}
