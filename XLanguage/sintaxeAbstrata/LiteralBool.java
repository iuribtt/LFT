package sintaxeAbstrata;

import visitor.XVisitor;

public class LiteralBool extends Exp {
	
	boolean b;

	public LiteralBool(boolean b) {
		
		this.b = b;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitLiteralBool(this);
	}
}
