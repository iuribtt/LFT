package sintaxeAbstrata;

import visitor.XVisitor;

public class Simples extends Var{


	public String id;

	public Simples(String id) {
		
		this.id = id;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitSimples(this);
	}

}
