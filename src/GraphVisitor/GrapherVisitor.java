package GraphVisitor;
import java.util.ArrayList;
import ast.*;
import Visitor.Visitor;

public class GrapherVisitor implements Visitor {
	public static ArrayList<Integer> VisitedNode = new ArrayList<>();
	public static int nodeCount; //contador de nodos
	public String concat = "";//string para concatenar los nodos visitados
	public String member = "";//string que guarda los nodos reducidos

	public GrapherVisitor(){
		this.member = "digraph g {\n"; //Sintaxis inicial
		this.nodeCount = 0;
	}
	@Override
	public void visit(Program visitor) {	
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"Program{}\"];\n";
	}		
        @Override
	public void visit(var_declaration visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"" + "Variable, "+ visitor.getIdent() + " " + visitor.getTipo() + "\"];\n";
	}
	@Override
	public void visit(fun_declaration visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"" + "Funcion: " + visitor.getTipo()+ " " + visitor.getIdent() + "\"];\n";
	}
	//Este metodo tiene 2 tipos distintos uno de arreglo. (el que tiene el corchete).
	public void visit(Param visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(visitor.isCorchetes()){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"" + "Parametro: " + visitor.getTipo() + "\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\""  + "Parametro: " + visitor.getTipo() + "\"];\n";
		}		
	}
	
	@Override
	public void visit(compound_stmt visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"Cuerpo{}\"];\n";		
	}
	
	@Override
	public void visit(Empty_Stmt visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"Vacio\"];\n";
	}
	/*Este metodo tiene un boolean que se encarga de verificar si la sintaxis if tiene un else.*/
	@Override
	public void visit(selection_stmt visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(!visitor.isTieneElse()){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Else{}\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\"If{}\"];\n";
		}
	}
	/*Al igual que la sintxis if este tiene un boolean que se encarga de ver si el while tiene un do antees.*/
	@Override
	public void visit(iteration_stmt visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(!visitor.isTieneDoWhile()){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Do{}\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\"While{}\"];\n";
		}
	}
	
	@Override
	public void visit(return_stmt visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		this.member += Integer.toString(visitor.getINode()) + " [label=\"Return " +visitor.getTipo() +";\"];\n";
	}
	/*Asignacion de expresiones que tienen arreglos y otras no.*/
	@Override
	public void visit(ExprAsign visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(visitor.getValor() == null){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Asignacion\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Asignacion, Valor: " + visitor.getValor() + "\"];\n";
		}
		
	}
	/*Expresiones compuestas y normales.*/
	@Override
	public void visit(ExprVar visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(!visitor.isCorchetes()){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Expresion, " + visitor.getIdent() + "  " + visitor.getValor() + "\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Expresion, " + visitor.getIdent() + "[Expresion] = " + visitor.getValor() + "\"];\n";
		}
		
	}
	/*Expresiones que utilizan operadores, suma, resta, mult, etc.*/
	@Override
	public void visit(ExprBynary visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		String operacion = visitor.getTipo();
		switch(operacion){
		case "Menor igual":
			operacion = "<=";
			break;
		case "Menor":
			operacion = "<";
			break;
		case "Mayor igual":
			operacion = ">=";
			break;
		case "Mayor":
			operacion = ">";
			break;
		case "Igual igual":
			operacion = "==";
			break;
		case "Distinto":
			operacion = "<>";
			break;
		case "Suma":
			operacion = "+";
			break;
		case "Resta":
			operacion = "-";
			break;
		case "Multiplicacion":
			operacion = "*";
			break;
		case "Division":
			operacion = "/";
			break;
		default:
			operacion = "Desconocido";
			break;
		}
		//Valor 2 es la segunda expresion.
		this.member += Integer.toString(visitor.getINode()) + " [label=\"Operacion,  " + visitor.getValor() + " " + operacion +" " + visitor.getValor2() + "\"];\n";
	}
	/*Expresion constante.*/
	@Override
	public void visit(ExprConst visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(visitor.getTipo() == "int"){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Constante, " + visitor.getValor() + "\"];\n";
		}		
	}
	/*Declara funcioens.*/
	@Override
	public void visit(CallFunction visitor) {
		Node nodoPadre = visitor.getPadre();
		if(nodoPadre != null){
			this.concat += Integer.toString(nodoPadre.getINode()) + "->" + Integer.toString(visitor.getINode()) + ";\n";
		}
		if(visitor.getTipo() == "void"){
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Call, " + visitor.getIdent() + "(args)" + "\"];\n";
		}else{
			this.member += Integer.toString(visitor.getINode()) + " [label=\"Valor, " + visitor.getValor() + "\"];\n";
		}
	}
	
	/*Metodo que retorna la cadena completa para generar el .dot.*/
	public String retornaCadenaGraph(){
		String cadena = "";
		cadena = cadena.concat(this.member);
		cadena = cadena.concat(this.concat);
		cadena += "}";
		return cadena;
	}

}
