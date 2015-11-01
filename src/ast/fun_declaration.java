package ast;

import java.util.Collections;
import Visitor.Visitor;
import Tablas.sym;
import GraphVisitor.GrapherVisitor;

/**
 * @author ErnestoLuis Metodo que se encarga de generar la funcion para cuando
 * llega.
 */
public class fun_declaration extends Node {

    protected String ident;
    protected int tipos;

    public fun_declaration(int tipoLlega, String id, Node params, Node comp) {
        this.iNode = GrapherVisitor.nodeCount++;
        this.tipos = tipoLlega;
        this.ident = id;
        if (this.tipos == sym.VOID) {
            this.type = "void"; //Asignacion de tipo void.
        } else {
            this.type = "int"; //Asignacion de tipo int.
        }
        if (params != null) {
            this.childs.add(params);
            params.setPadre(this);
            while (true) {
                if (params.getHermano() == null) { //Deja de asignar padres si no hay mas hermanos para el nodo inicial.
                    break;
                }
                this.childs.add(params.getHermano());
                params.getHermano().setPadre(this);
                params = params.getHermano();
            }
        }
        /*Ahora como se tiene en el automata otra nodo que es el de compound-stmt se re 
         * agregaran sus childs igual y se se�alara su padre, en este caso es un solo nodo 
         * no se recorren en sus hermanos ya que es el nodo del cuerpo de la funcion.
         */
        this.childs.add(comp);
        if (comp != null) {
            comp.setPadre(this);
        }
        Collections.reverse(this.childs); //Se invierte la lista para tener el orden correcto.

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

    public int getTipos() {
        return tipos;
    }

    public void setTipos(int tipos) {
        this.tipos = tipos;
    }

}
