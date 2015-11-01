package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class selection_stmt extends Node{
	protected boolean tieneElse;
	public selection_stmt(Node exp, Node stmtIf, Node stmtElse, boolean tendraElse) {
		this.nNodo = GrapherVisitor.identNodo++;
		this.tieneElse = tendraElse;
		if(tieneElse = true){
			this.tipo = "else";
		}else{
			this.tipo = "if";
		}
				if (exp != null) {
			this.hijos.add(exp);
			exp.setPadre(this);
		}
		if(stmtIf != null){
			this.hijos.add(stmtIf);
			stmtIf.setPadre(this);
			
			while(true){
				if(stmtIf.getHermano() == null){ 
				break;
				}
				this.hijos.add(stmtIf.getHermano());
				stmtIf.getHermano().setPadre(this);
				stmtIf = stmtIf.getHermano();
			}
		}
		
		if(stmtElse != null){
			this.hijos.add(stmtElse);
			stmtElse.setPadre(this);
			
			while(true){
				if(stmtElse.getHermano() == null){ 
					break;
				}
				this.hijos.add(stmtElse.getHermano());
				stmtElse.getHermano().setPadre(this);
				stmtElse = stmtElse.getHermano();
			}
		}
		Collections.reverse(this.hijos); 
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public boolean isTieneElse() {
		return tieneElse;
	}

	public void setTieneElse(boolean tieneElse) {
		this.tieneElse = tieneElse;
	}

}
