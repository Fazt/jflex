/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

import Tablas.Kind;
import ast.Node;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Spartan
 */
public class Util {

    
    /**
     * Funcion que comprueba que una funcion este declarada con la misma
     * cantidad de parametros que la llamada a esa funcion. Tambien comprueba
     * que el tipo de los parametros entregados sea el correcto. Tambien soporta
     * la sobrecarga de funciones..
     *     
*
     */;
    /**
     * Funcion que comprueba que una funcion este declarada con la misma
     * cantidad de parametros que la llamada a esa funcion. Tambien comprueba
     * que el tipo de los parametros entregados sea el correcto. Tambien soporta
     * la sobrecarga de funciones..
     *     
     */
    static boolean testFun(Node local, List<Declaration> overload, Declaration d) {
        Declaration vardecl;
        List<String> variables = new LinkedList<>();
        //Se guardan los nombres de los parametros
        for (int i = 0; i < d.params.size(); i++) {
            if(d.params.get(i).getKind()!= Kind.ExprConst){
            variables.add(d.params.get(i).getIdent());
            }
        }
        //Se busca la variable dentro del alcance, y si esta declarada se obtiene su tipo
        for (int i = 0; i < variables.size(); i++) {
            for (int j = local.alcance.size() - 1; j >= 0; j--) {
                vardecl = local.alcance.get(j).get(variables.get(i));
                if (vardecl != null) {
                    for (int k = 0; k < d.params.size(); k++) {
                        if (vardecl.id.equals(d.params.get(k).getIdent())) {
                            d.params.get(k).setTipo(vardecl.type);
                        }
                    }
                    break;
                }
            }
        }
        //Se compara el tipo de los parametros con el de la funcion llamada
        for (int i = 0; i < overload.size(); i++) {
            if (overload.get(i).params.size() - 1 == d.params.size()) {
                for (int j = 0; j < overload.get(i).params.size() - 1; j++) {
                    if (d.params.get(j).getTipo().equals(overload.get(i).params.get(j).getTipo())) {
                        //Si son iguales, todo ok
                    } else {
                        return false; //si encuentra una diferencia, retorna falso
                    }
                }
                return true; // Cuando hacen match los tipos, retorna true
            }
        }
        return false;// Si no encuentra la variable declarada retorna falso
    }

    /**
     * Funcion que comprueba el tipo de una BynaryExpr
     *
     * @param Bexp
     * @param scopes
     */
    static String testBynaryExp(Node Bexp, Node scopes) {
        Node Bizq = Bexp.getChilds().get(0);
        Node Bder = Bexp.getChilds().get(1);
        String tIzq = "";
        String tDer = "";
        Declaration vardecl;
        switch (Bizq.getKind()) {
            case ExprVar:
                for (int j = scopes.alcance.size() - 1; j >= 0; j--) {
                    vardecl = scopes.alcance.get(j).get(Bizq.getIdent());
                    if (vardecl != null) {
                        tIzq = vardecl.type;
                    }
                }
                break;
            case ExprBynary:
                testBynaryExp(Bizq, scopes);
                break;
            case ExprConst:
                tIzq = Bizq.getTipo();
                break;
            default:
                throw new AssertionError(Bizq.getKind().name());
        }

        switch (Bder.getKind()) {
            case ExprVar:
                for (int j = scopes.alcance.size() - 1; j >= 0; j--) {
                    vardecl = scopes.alcance.get(j).get(Bder.getIdent());
                    if (vardecl != null) {
                        tDer = vardecl.type;
                        break;
                    }
                }
                break;
            case ExprBynary:
                testBynaryExp(Bder, scopes);
                break;
            case ExprConst:
                tDer = Bder.getTipo();
                break;
            default:
                throw new AssertionError(Bder.getKind().name());
        }
        if(tIzq == "intArray"){
            tIzq = "int";
        }
        if(tDer == "intArray"){
            tDer = "int";
        }
        if (tIzq.equals(tDer)) {
            return tIzq;//Si son iguales se retorna el tipo de cualquiera de los dos
        } else {
            return null;
        }

    }
    
    static boolean testIni(Declaration d, List<Node> asignaciones){
        List<String> check = new LinkedList<>();
        boolean t = false;
        for (int i = 0; i < d.params.size(); i++) {
            for (int j = 0; j < asignaciones.size(); j++) {
                if (d.params.get(i).getKind() != Kind.ExprConst) {
                    if (d.params.get(i).getIdent().equals(asignaciones.get(j).getChilds().get(0).getIdent())) {
                        check.add(d.params.get(i).getIdent());
                        break;
                    }
                }
            }
        }
        if(d.params.size()==check.size()){
            t= true;
        }
        return t;
    }

}
