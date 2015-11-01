package ast;
import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class Exp_Var extends Node{
	protected String ident;
	protected boolean corchetes;
	
	public Exp_Var(Node exp, String id, boolean corch) {
		this.nNodo = GrapherVisitor.identNodo++;
		this.corchetes = corch; 
		this.ident = id;
		if(this.corchetes == true){
			this.tipo = "conOperacion";
		}else{
			this.tipo = "sinOperacion";
		}
		if(exp != null){
			this.valor = exp.getValor();
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

	public boolean isCorchetes() {
		return corchetes;
	}

	public void setCorchetes(boolean corchetes) {
		this.corchetes = corchetes;
	}

}
