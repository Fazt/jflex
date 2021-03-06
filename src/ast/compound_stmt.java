package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Tablas.Kind;
import Visitor.Visitor;


public class compound_stmt extends Node {

    public compound_stmt(Node locDec, Node stmtList) {
        this.kind= Kind.compound_stmt;
        this.iNode = GrapherVisitor.nodeCount++;

        if (stmtList != null) {
            this.childs.add(stmtList);
            stmtList.setPadre(this);
            while (true) {
                if (stmtList.getHermano() == null) {
                    break;
                }
                this.childs.add(stmtList.getHermano());
                stmtList.getHermano().setPadre(this);
                stmtList = stmtList.getHermano();
            }
        }
        if (locDec != null) {
            this.childs.add(locDec);
            locDec.setPadre(this);
            while (true) {
                if (locDec.getHermano() == null) {
                    break;
                }
                this.childs.add(locDec.getHermano());
                locDec.getHermano().setPadre(this);
                locDec = locDec.getHermano();
            }
        }
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
