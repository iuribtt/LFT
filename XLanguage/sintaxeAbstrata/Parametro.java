package sintaxeAbstrata;

import visitor.XVisitor;

abstract public class Parametro {
	
	public abstract Object accept(XVisitor visitor);

}
