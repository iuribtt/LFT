package sintaxeAbstrata;

import visitor.XVisitor;

public class IntToReal extends Exp {
	
	public Exp exp;
	
	public IntToReal(Exp exp) {

		this.exp = (LiteralReal) exp;
		
	}
	
	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitIntToReal(this);
	}

}
