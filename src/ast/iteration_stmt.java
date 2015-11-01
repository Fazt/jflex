package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * 
 */
public class iteration_stmt extends Node{
	protected boolean tieneDoWhile;
	
	public iteration_stmt(Node exp, Node stmt, boolean tendraDoWhile) {
		this.nNodo = GrapherVisitor.identNodo++;
		this.tieneDoWhile = tendraDoWhile;
		if(this.tieneDoWhile = true){
			this.tipo = "do";
		}else{
			this.tipo = "while";
		}
		
				if (exp != null) {
					this.hijos.add(exp);
					exp.setPadre(this);
				}
				
				if(stmt != null){
					this.hijos.add(stmt);
					stmt.setPadre(this);
					
					while(true){
						if(stmt.getHermano() == null){ 
							break;
						}
						this.hijos.add(stmt.getHermano());
						stmt.getHermano().setPadre(this);
						stmt = stmt.getHermano();
					}
				}
				Collections.reverse(this.hijos);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public boolean isTieneDoWhile() {
		return tieneDoWhile;
	}

	public void setTieneDoWhile(boolean tieneDoWhile) {
		this.tieneDoWhile = tieneDoWhile;
	}

}
