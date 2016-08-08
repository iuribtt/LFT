package sintaxeAbstrata;

import visitor.XVisitor;

public class Nao extends Exp{
	
	Exp exp;
	
	public Nao(Exp exp) {
		
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitNao(this);
	}

}
