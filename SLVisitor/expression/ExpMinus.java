package expression;

import visitor.SLVisitor;


public class ExpMinus extends Exp {
	
	public Exp left, right;

	public ExpMinus(Exp l, Exp r) {
		left = l; right = r; 
	}

	@Override
	public String toString() {
		return left.toString() + " - " + right.toString();
	}

	@Override
	public  Object accept(SLVisitor visitor) {
	 visitor.visitExpMinus(this);
	}
	
}
