package sintaxeAbstrata;

import visitor.XVisitor;

public class Indexada extends Var{
	
	Var var;
	Exp exp;
	
	public Indexada(Var var, Exp exp) {
		
		this.var = var;
		this.exp = exp;
	
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitIndexada(this);
	}

}
