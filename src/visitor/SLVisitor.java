package visitor;

import expression.ExpDivision;
import expression.ExpMinus;
import expression.ExpPlus;
import expression.ExpTimes;
import statment.AssignStm;
import statment.PrintStm;

public interface SLVisitor {
	
	Object visitAssignStm (AssignStm stm);
	
	Object visitPrintStm (PrintStm stm);

	Object visitExpPlus (ExpPlus exp);

	Object visitExpMinus(ExpMinus expMinus);

	Object visitExpTimes(ExpTimes expTimes);

	Object visitExpDivision(ExpDivision expDivision);

}
