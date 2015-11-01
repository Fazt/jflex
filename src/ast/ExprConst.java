package ast;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

//Nodo que revisa si hay un numero.
public class ExprConst extends Node {

    public ExprConst(Integer num) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.setTipo("Integer");
        this.setValor(num.toString());// Se convierte el token a string
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
