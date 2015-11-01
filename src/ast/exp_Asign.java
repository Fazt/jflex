package ast;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author
 *	Metodo que se encarga de asignar valores.
 */
public class exp_Asign extends Node{
	
	public exp_Asign(Node var, Node exp,int tipo) {
		this.tipo = Integer.toString(tipo); 
		this.nNodo = GrapherVisitor.identNodo++;
		this.setValor(exp.getValor()); 
		if(var != null){
			this.hijos.add(var);
			var.setPadre(this);
			while(true){
				if(var.getHermano() == null){ 
					break;
				}
				this.hijos.add(var.getHermano());
				var.getHermano().setPadre(this);
				var = var.getHermano();
			}
		}
		if(exp != null){
			this.hijos.add(exp);
			exp.setPadre(this);
			
			while(true){
				if(exp.getHermano() == null){ 
					break;
				}
				this.hijos.add(exp.getHermano());
				exp.getHermano().setPadre(this);
				exp = exp.getHermano();
			}
		}
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
