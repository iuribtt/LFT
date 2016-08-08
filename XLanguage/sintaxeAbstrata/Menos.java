package sintaxeAbstrata;

import visitor.XVisitor;

public class Menos extends Exp{
	
	Exp exp;
	
	public Menos(Exp exp) {
		
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitMenos(this);
	}

}
