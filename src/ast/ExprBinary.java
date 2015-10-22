package ast;

import java.util.LinkedList;

public class ExprBinary extends SyntaxNode {

	/**
	 * Indica el tipo de operador basado en un valor entero (ver sym.java).
	 */
	private int operator;

	/**
	 * Constructor del nodo de la expresion binaria.
	 * @param m Operacion
	 * @param t Hijo izquierdo.
	 * @param f Hijo derecho.
	 */
	public ExprBinary(Integer m, SyntaxNode t, SyntaxNode f) {
		this.children = new LinkedList<SyntaxNode>();
		this.operator = m;

		if (t != null && f != null) {
			// Calcular valor si es posible.
		}
		
		if (t != null) {
			this.children.add(t);
			t.setParent(this);			
		}
		
		if (f != null){ 
			this.children.add(f);
			f.setParent(this);
		}
	}

	/**
	 * Obtiene el operador almacenado en este nodo.
	 * @return
	 */
	public int getOperator() {
		return operator;
	}
	
}
