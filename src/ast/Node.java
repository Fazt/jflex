package ast;

import AnalisisSemantico.ScopeVisitor;
import java.util.LinkedList;
import Visitor.Visitor;
import GraphVisitor.GrapherVisitor;
import Tablas.*;
public abstract class Node {

 
    protected String type = "";
    protected String valor;
    protected int iNode = 0; //index
    protected Node padre = null;
    protected Node hermano = null;
    protected LinkedList<Node> childs = new LinkedList<>();
    protected Kind kind;
    public int fila;

    public Node() {
        super();
        this.valor = "";
    }
    //metodo encargado de recorrer el arbol
    public void GrapherTree(Visitor visitor) {
        if (GrapherVisitor.VisitedNode.contains(this.iNode)) {
            return;
        }
        GrapherVisitor.VisitedNode.add(this.iNode);
        accept(visitor); //se ejecuta el metodo accept
        for (Node nodo : childs) {
            if (nodo != null) {
                nodo.GrapherTree(visitor);
            }
        }
    }
    
    public void ScopeTree(Visitor visitor) {
        if (ScopeVisitor.VisitedNode.contains(this.iNode)) {
            return;
        }
        ScopeVisitor.VisitedNode.add(this.iNode);
        accept(visitor); //se ejecuta el metodo accept
        for (Node nodo : childs) {
            if (nodo != null) {
                nodo.ScopeTree(visitor);
            }
        }
    }

    public int getINode() {
        return this.iNode;
    }

    public Node getPadre() {
        return this.padre;
    }

    public Node getHermano() {
        return this.hermano;
    }

    public LinkedList<Node> getChilds() {
        return this.childs;
    }

    public String getTipo() {
        return this.type;
    }

    public void setNodo(int nodoN) {
        this.iNode = nodoN;
    }

    public void setPadre(Node pad) {
        this.padre = pad;
    }

    public void setHermano(Node her) {
        this.hermano = her;
    }

    public void setChilds(LinkedList<Node> hij) {
        this.childs = hij;
    }

    public void setTipo(String tip) {
        this.type = tip;
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
    
        public void setKind(Kind kind) {
        this.kind = kind;
    }
       public Kind getKind() {
        return kind;
    }


}
