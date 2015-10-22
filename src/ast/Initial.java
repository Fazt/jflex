package ast;

import java.util.LinkedList;

public class Initial extends SyntaxNode {

	/**
	 * Constructor del raiz.
	 * @param e Nodo al que apunta.
	 */
	public Initial(SyntaxNode e) {
		this.children = new LinkedList<SyntaxNode>();
		//Se linkea el padre y el hijo.
		this.children.add(e);
		e.setParent(this);
	}
	
}
