package sintaxeAbstrata;

import visitor.XVisitor;

public abstract class Tipo {

	public abstract Object accept(XVisitor visitor);
}
