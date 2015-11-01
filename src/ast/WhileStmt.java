package ast;

import java.util.Collections;
import GraphVisitor.GrapherVisitor;
import Visitor.Visitor;

/**
 *  Nodo encargado del metodo While
 */
public class WhileStmt extends Node {

    public WhileStmt(Node exp, Node stmt) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.type = "while";
        
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
}
