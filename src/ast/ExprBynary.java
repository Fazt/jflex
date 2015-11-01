package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Tablas.sym;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class ExprBynary extends Node{
	protected String valor2; 
	
	public ExprBynary(Node exp1,int tipo, Node exp2) {
		this.nNodo = GrapherVisitor.identNodo++;
	
		switch(tipo){
		case sym.LEQ:
			this.tipo = "Menor igual";
			break;
		case sym.LT:
			this.tipo = "Menor";
			break;
		case sym.GT:
			this.tipo = "Mayor";
			break;
		case sym.GEQ:
			this.tipo = "Mayor igual";
			break;
		case sym.EQ:
			this.tipo = "Igual igual";
			break;
		case sym.NEQ:
			this.tipo = "Distinto";
			break;
		case sym.SUMA:
			this.tipo = "Suma";
			break;
		case sym.RESTA:
			this.tipo = "Resta";
			break;
		case sym.MULT:
			this.tipo = "Multiplicacion";
			break;
		case sym.DIV:
			this.tipo = "Division";
			break;
		default:
			this.tipo = "";
			break;
		}
		if(exp1 != null){
			this.hijos.add(exp1);
			exp1.setPadre(this);
			this.setValor(exp1.getValor());
			
			while(true){
				if(exp1.getHermano() == null){ 
					break;
				}
				this.hijos.add(exp1.getHermano());
				exp1.getHermano().setPadre(this);
				exp1 = exp1.getHermano();
			}
		}
		if(exp2 != null){
			this.hijos.add(exp2);
			exp2.setPadre(this);
			this.valor2 = exp2.getValor();
			
			while(true){
				if(exp2.getHermano() == null){
					break;
				}
				this.hijos.add(exp2.getHermano());
				exp2.getHermano().setPadre(this);
				exp2 = exp2.getHermano();
			}
		}
		Collections.reverse(this.hijos); 
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

}
