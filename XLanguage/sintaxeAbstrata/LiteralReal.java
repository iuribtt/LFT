package sintaxeAbstrata;

import visitor.XVisitor;

public class LiteralReal extends Exp{
	
	public double real;
	
	public LiteralReal(double real) {
		this.real = real;

	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitLiteralReal(this);
	}

}
