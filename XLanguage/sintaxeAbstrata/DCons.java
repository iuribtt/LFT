package sintaxeAbstrata;

import visitor.XVisitor;

abstract public class DCons {
	

	public abstract Object accept(XVisitor visitor);
	
}
