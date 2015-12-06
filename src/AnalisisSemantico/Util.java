/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSemantico;

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
     */
    static boolean testFun(Node local, List<Declaration> overload, Declaration d) {
        Declaration vardecl;
        List<String> variables = new LinkedList<>();
        List<Declaration> declarations = new LinkedList<>();
        for (int i = 0; i < d.params.size(); i++) {
            variables.add(d.params.get(i).getIdent());
        }
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

        for (int i = 0; i < overload.size(); i++) {
            if (overload.get(i).params.size() - 1 == d.params.size()) {
                for (int j = 0; j < overload.get(i).params.size() - 1; j++) {
                    if (d.params.get(j).getTipo().equals(overload.get(i).params.get(j).getTipo())) {
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
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
    
    public void testIni(){
        
    }

}
