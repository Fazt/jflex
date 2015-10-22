package ast;

import java.util.LinkedList;

public class ExprConst extends SyntaxNode {

	/**
	 * Constructor del nodo que almacena una constante, aqui se guarda en la tabla de literales.
	 * @param n
	 */
	public ExprConst(Integer n) {

		this.children = new LinkedList<SyntaxNode>();
		this.number = n;
	}
	
}