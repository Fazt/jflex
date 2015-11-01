package ast;
import java.util.LinkedList;
import Visitor.Visitor;
import GraphVisitor.GrapherVisitor;


public abstract class Node {
	protected int nNodo = 0; //Indice del nodo.
	protected Node padre = null; //Padre.
	protected Node hermano = null; //Hermano.
	protected LinkedList<Node> hijos = new LinkedList<>();
	protected String tipo = ""; //Tipo del valor.
	protected String valor;
	
	public Node() {
		super();
		this.valor = "";
	}
                
	public int getNNodo(){
		return this.nNodo;
	}
	
	public Node getPadre(){
		return this.padre;
	}
	
	public Node getHermano(){
		return this.hermano;
	}
	
	public LinkedList<Node> getHijos(){
		return this.hijos;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public void setNodo(int nodoN){
		this.nNodo = nodoN;
	}
	
	public void setPadre(Node pad){
		this.padre = pad;
	}
	
	public void setHermano(Node her){
		this.hermano = her;
	}
	
	public void setHijos(LinkedList<Node> hij){
		this.hijos = hij;
	}
	
	public void setTipo(String tip){
		this.tipo = tip;
	}
	
	public void recorrerArbol(Visitor visitor) {
		if (GrapherVisitor.nodoVisitados.contains(this.nNodo)) {
			return; 
		}
		GrapherVisitor.nodoVisitados.add(this.nNodo); 
		accept(visitor); //acepta el visitor.
		for (Node nodo : hijos) { 
			if (nodo != null)
				nodo.recorrerArbol(visitor);
		}
	}
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
