package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class BlocoExp extends Exp {
	
	List<DCons> cons;
	Exp exp;
	
	public BlocoExp(List<DCons> cons, Exp exp) {
		this.cons = cons;
		this.exp = exp;
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitBlocoExp(this);
	}

}
