package expression;

import visitor.SLVisitor;


public class ExpPlus extends Exp {

	public Exp left, right;

	public ExpPlus(Exp l, Exp r) {
		left = l; right = r; 
	}

	@Override
	public	String toString() {
		
		return left.toString() + " + " + right.toString();
	}

	@Override
	public  Object accept(SLVisitor visitor) {

		return visitor.visitExpPlus(this);
	}


}
