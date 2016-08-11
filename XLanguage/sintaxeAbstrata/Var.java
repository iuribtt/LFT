package sintaxeAbstrata;

import visitor.XVisitor;

public abstract class Var {

	
	public abstract Object accept(XVisitor visitor);
	
}
