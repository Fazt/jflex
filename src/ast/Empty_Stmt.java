package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.sym;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class Empty_Stmt extends Node{

	/*Clase que genera los vacion y los cuenta, les asigna el tipo void.*/
	public Empty_Stmt() {
		this.nNodo = GrapherVisitor.identNodo++; //Se incrementa en uno los nodos visitados ya por el GrapherVisitor y se le asigna al numero de nodo. 
		this.tipo = Integer.toString(sym.VOID);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	
}
