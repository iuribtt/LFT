package statment;

import visitor.SLVisitor;


public abstract class Stm {
	
	abstract Object accept(SLVisitor visitor);
	
}



