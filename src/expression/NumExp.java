package expression;

import visitor.SLVisitor;

public class NumExp extends Exp {

	public int num;

	public NumExp(int n) {
		num = n; 
	}

	@Override
	public String toString() {
		return num + "";
	}

	@Override
	public Object accept(SLVisitor visitor) {
		return visitor.visitNumExp(this);
	}

}