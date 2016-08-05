package expression;

import visitor.SLVisitor;

public class IdExp extends Exp {
	
	public String id;
	
	public IdExp(String i) { id = i; }

	@Override
	public String toString() {
		return id + "";
	}

	@Override
	public Object accept(SLVisitor visitor) {
		return visitor.visitIdExp(this);
	}

}	