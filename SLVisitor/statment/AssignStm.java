package statment;

import visitor.SLPrinter;
import visitor.SLVisitor;
import expression.Exp;

public class AssignStm extends Stm{

	public String id;// x = 5 + 6
	public Exp exp;

	public AssignStm(String i, Exp e){
		id = i; exp = e; 
	}

	@Override
	Object accept(SLVisitor visitor) {
		return visitor.visitAssignStm(this);
	}

	@Override
	Object print(SLPrinter print) {
		return print.visitAssignStm(this);
	}
	
	
	
}