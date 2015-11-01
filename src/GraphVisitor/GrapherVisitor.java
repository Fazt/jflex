package GraphVisitor;
import java.util.ArrayList;
import ast.*;
import Visitor.Visitor;

public class GrapherVisitor implements Visitor {
	public static ArrayList<Integer> nodoVisitados = new ArrayList<>();
	//variables que se encarga de concatener los arreglos para generar el graph.
	public static int identNodo; //Esta variable es para incrementar los nodos que se utilizaran, y que no se repitan
	public String cadenaRelaciones = "";//Esta variable puedo haber estado en cualquier lado hasta en el main pero al
	public String cadenaAsociados = "";//Utilizar esta herramienta del visitor para utilizar la abstraccion es mas correcto declararlo en la herrramienta.

	public GrapherVisitor(){
		this.cadenaAsociados = "digraph g {\n"; //Inicia la variable con este String ya que es la sintaxis para generar el graph.
		this.identNodo = 0;//Se inicilizan los nodos en 0 (indice).
	}
	/*Para cada implementacion de los metodos se tendra los arreglos que concatenan las sintaxis para el graph.*/
	@Override
	public void visit(Program visitor) {	
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Program{}\"];\n";
	}		
        @Override
	public void visit(var_declaration visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"" + "Variable, "+ visitor.getIdent() + " " + visitor.getTipo() + "\"];\n";
	}
	@Override
	public void visit(fun_declaration visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"" + "Funcion: " + visitor.getTipo()+ " " + visitor.getIdent() + "\"];\n";
	}
	//Este metodo tiene 2 tipos distintos uno de arreglo. (el que tiene el corchete).
	public void visit(Param visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(visitor.isCorchetes()){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"" + "Parametro: " + visitor.getTipo() + "\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\""  + "Parametro: " + visitor.getTipo() + "\"];\n";
		}		
	}
	
	@Override
	public void visit(compound_stmt visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Cuerpo{}\"];\n";		
	}
	
	@Override
	public void visit(Empty_Stmt visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Vacio\"];\n";
	}
	/*Este metodo tiene un boolean que se encarga de verificar si la sintaxis if tiene un else.*/
	@Override
	public void visit(selection_stmt visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(!visitor.isTieneElse()){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Else{}\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"If{}\"];\n";
		}
	}
	/*Al igual que la sintxis if este tiene un boolean que se encarga de ver si el while tiene un do antees.*/
	@Override
	public void visit(iteration_stmt visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(!visitor.isTieneDoWhile()){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Do{}\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"While{}\"];\n";
		}
	}
	
	@Override
	public void visit(return_stmt visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Return " +visitor.getTipo() +";\"];\n";
	}
	/*Asignacion de expresiones que tienen arreglos y otras no.*/
	@Override
	public void visit(exp_Asign visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(visitor.getValor() == null){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Asignacion\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Asignacion, Valor: " + visitor.getValor() + "\"];\n";
		}
		
	}
	/*Expresiones compuestas y normales.*/
	@Override
	public void visit(Exp_Var visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(!visitor.isCorchetes()){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Expresion, " + visitor.getIdent() + "  " + visitor.getValor() + "\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Expresion, " + visitor.getIdent() + "[Expresion] = " + visitor.getValor() + "\"];\n";
		}
		
	}
	/*Expresiones que utilizan operadores, suma, resta, mult, etc.*/
	@Override
	public void visit(ExprBynary visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
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
		this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Operacion,  " + visitor.getValor() + " " + operacion +" " + visitor.getValor2() + "\"];\n";
	}
	/*Expresion constante.*/
	@Override
	public void visit(ExprConst visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(visitor.getTipo() == "int"){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Constante, " + visitor.getValor() + "\"];\n";
		}		
	}
	/*Declara funcioens.*/
	@Override
	public void visit(ExprFunction visitor) {
		Node padre = visitor.getPadre();
		if(padre != null){
			this.cadenaRelaciones += Integer.toString(padre.getNNodo()) + "->" + Integer.toString(visitor.getNNodo()) + ";\n";
		}
		if(visitor.getTipo() == "void"){
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Call, " + visitor.getIdent() + "(args)" + "\"];\n";
		}else{
			this.cadenaAsociados += Integer.toString(visitor.getNNodo()) + " [label=\"Valor, " + visitor.getValor() + "\"];\n";
		}
	}
	
	/*Metodo que retorna la cadena completa para generar el .dot.*/
	public String retornaCadenaGraph(){
		String cadena = "";
		cadena = cadena.concat(this.cadenaAsociados);
		cadena = cadena.concat(this.cadenaRelaciones);
		cadena += "}";
		return cadena;
	}

}
