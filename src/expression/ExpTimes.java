package expression;

import visitor.SLVisitor;

public class ExpTimes extends Exp {

	public Exp left, right;

	public ExpTimes(Exp l, Exp r) {
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return left.toString() + " * " + right.toString();
	}

	@Override
	public Object accept(SLVisitor visitor) {
		
		return visitor.visitExpTimes(this);		
	}

}
