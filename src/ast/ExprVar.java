package ast;

import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

//Nodo que se encarga de los llamados a expresiones de variables
public class ExprVar extends Node {

    protected boolean argumento;
    protected String ident;

    public ExprVar(Node exp, String id, boolean args) {

        this.argumento = args; //detecta si el llamado a la funcion fue con o sin argumentos entre los parentesis cuadrados
        this.iNode = GrapherVisitor.nodeCount++;
        this.ident = id;
        if (this.argumento == true) {
            this.type = "con argumento";
        } else {
            this.type = "sin argumento";
        }
        if (exp != null) {//si Var::= ID, exp es null
            this.valor = exp.getValor();
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
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public boolean isCorchetes() {
        return this.argumento;
    }

    public void setCorchetes(boolean brackets) {
        this.argumento = brackets;
    }

}
