package statment;

import java.util.List;

import visitor.SLPrinter;
import visitor.SLVisitor;
import expression.Exp;

public class PrintStm extends Stm {

	public List<Exp> exps;
	@Override
	Object accept(SLVisitor visitor) {
		return visitor.visitPrintStm(this);
	}
	
	@Override
	Object print(SLPrinter print) {
		
		return print.visitPrintStm(this);
	}
	
}
