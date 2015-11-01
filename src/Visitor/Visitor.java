package Visitor;
import ast.*;
public interface Visitor {

	public void visit(Program visitor);
	public void visit(var_declaration visitor);
	public void visit(fun_declaration visitor);
	public void visit(Param visitor);
	public void visit(compound_stmt visitor);
	public void visit(Empty_Stmt visitor);
	public void visit(selection_stmt visitor);
	public void visit(iteration_stmt visitor);
	public void visit(return_stmt visitor);
	public void visit(exp_Asign visitor);
	public void visit(Exp_Var visitor);
	public void visit(ExprBynary visitor);
	public void visit(ExprConst visitor);
	public void visit(ExprFunction visitor);
	}
