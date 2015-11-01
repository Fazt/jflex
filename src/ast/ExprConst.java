package ast;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * 
 *	*Clase que verifica si hay una constante.
 */
public class ExprConst extends Node{
	public ExprConst(Integer num) {
		this.nNodo = GrapherVisitor.identNodo++;
		this.setTipo("int");
		this.setValor(num.toString());
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
