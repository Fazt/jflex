package ast;

import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;


public class ForStmt extends Node {

    public ForStmt(Node exp1, Node exp2, Node exp3, Node stmt) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.type = "for";
        
        if (exp1 != null && exp2 != null && exp3 != null ) {
            this.childs.add(exp1);
            this.childs.add(exp2);
            this.childs.add(exp3);
            exp1.setPadre(this);
            exp2.setPadre(this);
            exp3.setPadre(this);           
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
    }
    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }
}
