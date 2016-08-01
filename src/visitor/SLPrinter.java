package visitor;

import expression.Exp;
import expression.ExpDivision;
import expression.ExpMinus;
import expression.ExpPlus;
import expression.ExpTimes;
import statment.AssignStm;
import statment.PrintStm;


public class SLPrinter implements SLVisitor {

	public Object visitAssignStm(AssignStm stm) {
		
		return stm.id + " := " + stm.exp.accept(this);
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

}
