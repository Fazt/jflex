package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Tablas.sym;
import Visitor.Visitor;

//Nodo que se encarga de los vacios.
public class Empty_Stmt extends Node{
    
	public Empty_Stmt() {
		this.iNode = GrapherVisitor.nodeCount++; //Se incrementa en uno el contador y este pasa a ser el index
		this.type = Integer.toString(sym.VOID); //Se convierte el entero al que corresponde el simbolo a string
                this.kind= Kind.Empty_Stmt;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	
}
