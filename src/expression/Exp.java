package expression;

import visitor.SLVisitor;

public abstract class Exp {
	
	public abstract Object accept(SLVisitor visitor);
		
}
	