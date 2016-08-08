package sintaxeAbstrata;

import visitor.XVisitor;

abstract public class Exp {

	
	public abstract Object accept(XVisitor visitor);
	
}
