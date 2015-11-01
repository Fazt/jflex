package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 *
 */
public class iteration_stmt extends Node {

    protected boolean tieneDoWhile;

    public iteration_stmt(Node exp, Node stmt, boolean tendraDoWhile) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.tieneDoWhile = tendraDoWhile;
        if (this.tieneDoWhile = true) {
            this.type = "do";
        } else {
            this.type = "while";
        }

        if (exp != null) {
            this.childs.add(exp);
            exp.setPadre(this);
        }

        if (stmt != null) {
            this.childs.add(stmt);
            stmt.setPadre(this);

            while (true) {
                if (stmt.getHermano() == null) {
                    break;
                }
                this.childs.add(stmt.getHermano());
                stmt.getHermano().setPadre(this);
                stmt = stmt.getHermano();
            }
        }
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public boolean isTieneDoWhile() {
        return tieneDoWhile;
    }

    public void setTieneDoWhile(boolean tieneDoWhile) {
        this.tieneDoWhile = tieneDoWhile;
    }

}
