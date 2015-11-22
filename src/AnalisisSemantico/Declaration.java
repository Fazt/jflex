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
public class Declaration extends Node {

    public String id;
    public String type;
    public LinkedList<Node> params;

    public Declaration() {
    }

}
