package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class selection_stmt extends Node {

    protected boolean Else;

    public selection_stmt(Node exp, Node ifStmt, Node elseStmt, boolean e) {
        this.kind= Kind.selection_stmt;
        this.iNode = GrapherVisitor.nodeCount++;
        this.Else = e;
        if (Else == true) {
            this.type = "else";
        } else {
            this.type = "if";
        }
        if (exp != null) {
            this.childs.add(exp);
            exp.setPadre(this);
        }
        if (ifStmt != null) {
            this.childs.add(ifStmt);
            ifStmt.setPadre(this);

            while (true) {
                if (ifStmt.getHermano() == null) {
                    break;
                }
                this.childs.add(ifStmt.getHermano());
                ifStmt.getHermano().setPadre(this);
                ifStmt = ifStmt.getHermano();
            }
        }

        if (elseStmt != null) {
            this.childs.add(elseStmt);
            elseStmt.setPadre(this);

            while (true) {
                if (elseStmt.getHermano() == null) {
                    break;
                }
                this.childs.add(elseStmt.getHermano());
                elseStmt.getHermano().setPadre(this);
                elseStmt = elseStmt.getHermano();
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public boolean getElse() {
        return Else;
    }

    public void setElse(boolean tieneElse) {
        this.Else = tieneElse;
    }

}
