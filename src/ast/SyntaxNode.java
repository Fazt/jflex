// The following code was generated by ClassGen 1.0 on 17-08-14 10:38 PM

package ast;

import java.util.List;

/**
 * Clase abstracta que define la base de todos los nodos.
 * @author Brian Keith N
 *
 */
public abstract class SyntaxNode {

	protected int nodeTag;
	
	protected SyntaxNode parent;
	protected List<SyntaxNode> children;

	protected Integer number;
	protected String name;

	protected int line_number;
	protected int col_number;
	
	/**
	 * Metodo que retorna los hijos del nodo.
	 */
	public List<SyntaxNode> getChildren() {
		return this.children;
	}

	/**
	 * Obtiene el numero de linea asociado al nodo.
	 * @return Numero de linea.
	 */
	public Integer getLineNumber() {
		return line_number;
	}

	/**
	 * Obtiene el numero de columna asociado al nodo.
	 * @return
	 */
	public Integer getColNumber() {
		return col_number;
	}

	/**
	 * Modifica el numero de linea del nodo.
	 * @param n
	 */
	public void setLineNumber(int n) {
		this.line_number = n;
	}

	/**
	 * Modifica el numero de columna del nodo.
	 * @param n
	 */
	public void setColNumber(int n) {
		this.col_number = n;
	}

	/**
	 * Obtiene el nodo padre de este nodo, null si es que no tiene.
	 * @return
	 */
	public SyntaxNode getParent() {
		return parent;
	}
	
	/**
	 * Obtiene el numero (valor) almacenado en este nodo.
	 * @return
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Modifica el nodo padre del nodo.
	 * @param parent
	 */
	public void setParent(SyntaxNode parent) {
		this.parent = parent;
	}

	/**
	 * Funcion que determina si un nodo tiene hijos o no.
	 * @return True si tiene hijos, false en otro caso.
	 */
	public boolean hasChildren() {
		return (this.children.size() != 0);
	}
}
