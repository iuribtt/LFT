package visitor;

import expression.ExpDivision;
import expression.ExpMinus;
import expression.ExpPlus;
import expression.ExpTimes;
import expression.IdExp;
import expression.NumExp;
import expression.StmExp;
import statment.AssignStm;
import statment.PrintStm;

public class SLExecute implements SLVisitor{

	public Object visitAssignStm(AssignStm stm) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPrintStm(PrintStm stm) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitExpPlus(ExpPlus exp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitExpMinus(ExpMinus expMinus) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitExpTimes(ExpTimes expTimes) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitExpDivision(ExpDivision expDivision) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitStmExp(StmExp stmExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIdExp(SLVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitNumExp(NumExp numExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIdExp(IdExp idExp) {
		// TODO Auto-generated method stub
		return null;
	}

}
