package statment;

import visitor.SLVisitor;
import expression.Exp;

public class AssignStm extends Stm{

	public String id;
	public Exp exp;

	public AssignStm(String i, Exp e){
		id = i; exp = e; 
	}

	@Override
	Object accept(SLVisitor visitor) {
		return visitor.visitAssignStm(this);
	}
	
}