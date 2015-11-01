package ast;

import java.util.Collections;

import GraphVisitor.GrapherVisitor;
import Tablas.sym;
import Visitor.Visitor;

public class ExprBynary extends Node {

    protected String valor2;

    //Nodo encargado de trabajar con las expresiones que tienen 2 operadores
    public ExprBynary(Node exp1, int operador, Node exp2) {
        this.iNode = GrapherVisitor.nodeCount++;

        switch (operador) {
            case sym.LEQ:
                this.type = "Menorigual";
                break;
            case sym.LT:
                this.type = "Menor";
                break;
            case sym.GT:
                this.type = "Mayor";
                break;
            case sym.GEQ:
                this.type = "Mayorigual";
                break;
            case sym.EQ:
                this.type = "Igual";
                break;
            case sym.NEQ:
                this.type = "Distinto";
                break;
            case sym.SUMA:
                this.type = "Suma";
                break;
            case sym.RESTA:
                this.type = "Resta";
                break;
            case sym.MULT:
                this.type = "Multiplicacion";
                break;
            case sym.DIV:
                this.type = "Division";
                break;
            case sym.EXP1:
                this.type = "Exponente1";
                break;
            case sym.EXP2:
                this.type = "Exponente2";
                break;
            default:
                this.type = "";
                break;
        }
        if (exp1 != null) {
            this.childs.add(exp1);
            exp1.setPadre(this);
            this.setValor(exp1.getValor());

            while (true) {
                if (exp1.getHermano() == null) {
                    break;
                }
                this.childs.add(exp1.getHermano());
                exp1.getHermano().setPadre(this);
                exp1 = exp1.getHermano();
            }
        }
        if (exp2 != null) {
            this.childs.add(exp2);
            exp2.setPadre(this);
            this.valor2 = exp2.getValor();

            while (true) {
                if (exp2.getHermano() == null) {
                    break;
                }
                this.childs.add(exp2.getHermano());
                exp2.getHermano().setPadre(this);
                exp2 = exp2.getHermano();
            }
        }
        Collections.reverse(this.childs);
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

}
