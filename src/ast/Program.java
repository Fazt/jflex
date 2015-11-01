package ast;

import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class Program extends Node {
    /*Metodo que crea el primero nodo del programa y recibe una declaration_list la cual
     * genera cada hijo para este nodo padre Program y recorre todos los hermanos del nodo que llega.
     */

    public Program(Node dl) {
        this.iNode = GrapherVisitor.nodeCount++; //Se incrementa en uno los nodos visitados ya por el GrapherVisitor y se le asigna al numero de nodo. 
        if (dl != null) {
            this.childs.add(dl);
            dl.setPadre(this);
            while (true) {
                if (dl.getHermano() == null) { //Deja de asignar padres si no hay mas hermanos para el nodo inicial.
                    break;
                }
                this.childs.add(dl.getHermano());
                dl.getHermano().setPadre(this);
                dl = dl.getHermano();
            }
        }
        Collections.reverse(this.childs); //Se invierte la lista para tener el orden correcto.
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
