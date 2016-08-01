package expression;

import statment.Stm;
import visitor.SLVisitor;

public class StmExp extends Exp {
	public Stm stm;
	public Exp exp;

	public StmExp(Stm s,Exp e) {
		stm = s; exp = e; 
	}

	@Override
	public String toString() {
		return "(" + stm.toString() + " " + exp.toString()+ ")";	
	}

	@Override
	public Object accept(SLVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}