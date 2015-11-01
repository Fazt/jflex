package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 *	Clase que se encarga de generar el Compund statment.
 */
public class compound_stmt extends Node{
	
	public compound_stmt(Node locDec, Node stmtList){
		this.nNodo = GrapherVisitor.identNodo++;

		if(stmtList != null){
			this.hijos.add(stmtList); 
			stmtList.setPadre(this);
			while(true){
				if(stmtList.getHermano() == null){ 
					break;
				}
				this.hijos.add(stmtList.getHermano());
				stmtList.getHermano().setPadre(this); 
				stmtList = stmtList.getHermano();
			}
		}
		if(locDec != null){
			this.hijos.add(locDec); 
			locDec.setPadre(this);
			while(true){
				if(locDec.getHermano() == null){ 
					break;
				}
				this.hijos.add(locDec.getHermano());
				locDec.getHermano().setPadre(this); 
				locDec = locDec.getHermano();
			}
		}
		Collections.reverse(this.hijos); 
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
