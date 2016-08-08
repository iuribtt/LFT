package sintaxeAbstrata;

import visitor.XVisitor;

abstract public class Comando {

	public abstract Object accept(XVisitor visitor);
}
