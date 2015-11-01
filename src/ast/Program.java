package ast;

import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

        /**
	 * Constructor del raiz.
	 * Node dl Nodo al que apunta.
	 */
public class Program extends Node {
    public Program(Node dl) {//dl viene de declaration-list
        this.iNode = GrapherVisitor.nodeCount++; //se aumenta el contador
        if (dl != null) {
            this.childs.add(dl);//Se linkean padre e hijos
            dl.setPadre(this);
            while (true) {
                if (dl.getHermano() == null) {
                    break;
                }
                this.childs.add(dl.getHermano());
                dl.getHermano().setPadre(this);
                dl = dl.getHermano();//se pasa al siguiente nodo hermano
            }
        }
        Collections.reverse(this.childs); //Se invierte la lista para tener el orden correcto.
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
