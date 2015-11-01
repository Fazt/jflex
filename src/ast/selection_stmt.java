package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 * @author ErnestoLuis
 *
 */
public class selection_stmt extends Node {

    protected boolean tieneElse;

    public selection_stmt(Node exp, Node stmtIf, Node stmtElse, boolean tendraElse) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.tieneElse = tendraElse;
        if (tieneElse = true) {
            this.type = "else";
        } else {
            this.type = "if";
        }
        if (exp != null) {
            this.childs.add(exp);
            exp.setPadre(this);
        }
        if (stmtIf != null) {
            this.childs.add(stmtIf);
            stmtIf.setPadre(this);

            while (true) {
                if (stmtIf.getHermano() == null) {
                    break;
                }
                this.childs.add(stmtIf.getHermano());
                stmtIf.getHermano().setPadre(this);
                stmtIf = stmtIf.getHermano();
            }
        }

        if (stmtElse != null) {
            this.childs.add(stmtElse);
            stmtElse.setPadre(this);

            while (true) {
                if (stmtElse.getHermano() == null) {
                    break;
                }
                this.childs.add(stmtElse.getHermano());
                stmtElse.getHermano().setPadre(this);
                stmtElse = stmtElse.getHermano();
            }
        }
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public boolean isTieneElse() {
        return tieneElse;
    }

    public void setTieneElse(boolean tieneElse) {
        this.tieneElse = tieneElse;
    }

}
