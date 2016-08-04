package visitor;

import expression.Exp;
import expression.ExpDivision;
import expression.ExpMinus;
import expression.ExpPlus;
import expression.ExpTimes;
import expression.IdExp;
import expression.NumExp;
import expression.StmExp;
import statment.AssignStm;
import statment.PrintStm;


public class SLPrinter implements SLVisitor {

	public Object visitAssignStm(AssignStm stm) {
		
		return stm.id + " := " + stm;
	}

	public Object visitPrintStm(PrintStm stm) {

		String res = "Print (";
		for(Exp e: stm.exps){
			res = res + e.accept(this);
		}
		
		res = res + ")";
			
		return res;
	}
	
	public Object visitExpPlus(ExpPlus exp){
		
		return "(" + exp.left.accept(this) + " + " + exp.right.accept(this) + ")";
	}
	
	public Object visitExpMinus(ExpMinus exp){
		
		return "(" + exp.left.accept(this) + " - " + exp.right.accept(this) + ")";
	}

	public Object visitExpTimes(ExpTimes exp){
		
		return "(" + exp.left.accept(this) + " * " + exp.right.accept(this) + ")";
	}
	
	public Object visitExpDivision(ExpDivision exp){
		
		return "(" + exp.left.accept(this) + " / " + exp.right.accept(this) + ")";
	}

	public Object visitStmExp(StmExp stmExp) {
	
		return stmExp.accept(this);
	}

	public Object visitIdExp(IdExp idExp) {

		return idExp.id;
	}

	public Object visitNumExp(NumExp numExp) {
	
		
		
		
		return numExp.num;
	}

}
