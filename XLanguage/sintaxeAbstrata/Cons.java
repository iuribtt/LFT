package sintaxeAbstrata;

import visitor.XVisitor;

public class Cons extends DCons{
	
	public Tipo tipo;
	public String id;
	public Exp exp;

	public Cons(Tipo tipo, String id, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitCons(this);
	}
	
}
