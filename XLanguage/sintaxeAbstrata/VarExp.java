package sintaxeAbstrata;

import visitor.XVisitor;

public class VarExp extends Exp {
	
	public Var var;
	
	public VarExp(Var var) {
	
		this.var = var;
		
	}
	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitVarExp(this);
	}

}
