package ast;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Visitor.Visitor;

//Nodo que se encarga de la asignacion.
public class ExprAsign extends Node {

    public ExprAsign(Node var, Node exp, int asign) {
        this.kind= Kind.ExprAsign;
        this.type = Integer.toString(asign); //se pasa el entero a string
        this.iNode = GrapherVisitor.nodeCount++; //Se incrementa en uno el contador y este pasa a ser el index
        this.setValor(exp.getValor());
        if (var != null) {
            var.setPadre(this);
            this.childs.add(var);

            while (true) {
                if (var.getHermano() == null) {
                    break;
                }
                this.childs.add(var.getHermano());
                var.getHermano().setPadre(this);
                var = var.getHermano();
            }
        }
        if (exp != null) {
            this.childs.add(exp);
            exp.setPadre(this);

            while (true) {
                if (exp.getHermano() == null) {
                    break;
                }
                this.childs.add(exp.getHermano());
                exp.getHermano().setPadre(this);
                exp = exp.getHermano();
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
