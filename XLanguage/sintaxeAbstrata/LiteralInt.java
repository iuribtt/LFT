package sintaxeAbstrata;

import visitor.XVisitor;

public class LiteralInt extends Exp{
	
	public int i;
	
	public LiteralInt(int i) {
		this.i = i;

	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitLiteralInt(this);
	}

}
