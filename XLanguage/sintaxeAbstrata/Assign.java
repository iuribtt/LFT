package sintaxeAbstrata;

import visitor.XVisitor;

public class Assign extends Comando{
	
	Var var;
	Exp exp;
	
	public Assign(Var var, Exp exp) {
		
		this.var = var;
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitAssign(this);
	}

}
