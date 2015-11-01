package ast;


import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author 
 *
 */
public class return_stmt extends Node{
	protected int tipos;
	public return_stmt(Node exp) {
		this.nNodo = GrapherVisitor.identNodo++;
		if (exp != null) {
			this.setValor(exp.getTipo());; 
			if (exp != null) {
				exp.setPadre(this);
				this.hijos.add(exp);
			}
			this.hijos.add(exp);
			this.setTipo(exp.getTipo());
		}else{
			this.setTipo("void");
		}
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
