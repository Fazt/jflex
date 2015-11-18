/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Tablas.*;
import ast.Node;
import AnalisisSemantico.Alcance;

/**
 *
 * @author Spartan
 */
public class SymTab {

    Kind kind;
    int size;
    Alcance head;
    SymTab next;
    Alcance alcance = null;

    public SymTab(Kind kind, int size, Alcance head, SymTab next) {
        this.kind = kind;
        this.size = size;
        this.head = head;
        this.next = next;
    }

    public void create_symtab(Node node) {
        Fun_info funinfo = null;
        Type tipo = null;
        while (node != null) {
            switch (node.getKind()) {
                case var_declaration:
                    break;
                case fun_declaration:
                    break;
                case Param:
                    break;
                case compound_stmt:
                    //Se crea un nuevo alcance
                    break;
                case Empty_Stmt:
                    break;
                case selection_stmt:
                    // se crea un nuevo alcance
                    break;
                case WhileStmt:
                    //se crea un nuevo alcance
                    break;
                case ForStmt:
                    //se crea un nuevo alcance
                    break;
                case return_stmt:
                    break;
                case ExprAsign:
                    break;
                case ExprVar:
                    break;
                case ExprBynary:
                    break;
                case ExprConst:
                    break;
                case CallFunction:
                    break;
                default:
                    break;
            }
        }
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(Alcance head) {
        this.head = head;
    }

    public void setNext(SymTab next) {
        this.next = next;
    }

    public Kind getKind() {
        return kind;
    }

    public int getSize() {
        return size;
    }

    public Alcance getHead() {
        return head;
    }

    public SymTab getNext() {
        return next;
    }

}
