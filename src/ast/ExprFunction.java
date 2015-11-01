package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *	Metodo que genera la funciones con expresiones.
 */
public class ExprFunction extends Node{
	protected String ident;
	
	public ExprFunction(String id, Node arg) {
		this.nNodo = GrapherVisitor.identNodo++;
		this.tipo = "id";
		this.ident = id; 
		if(arg != null){
			this.setValor(arg.getValor());
			this.hijos.add(arg);
			arg.setPadre(this);
			
			while(true){
				if(arg.getHermano() == null){ 
					break;
				}
				this.hijos.add(arg.getHermano());
				arg.getHermano().setPadre(this);
				arg = arg.getHermano();
			}
		}
		Collections.reverse(this.hijos); 
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
}
