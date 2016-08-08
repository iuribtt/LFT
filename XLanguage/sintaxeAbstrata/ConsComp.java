package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class ConsComp extends DCons{
	
	Tipo tipo;
	String id;
	List<String> ids;
	Exp exp;
	
	public ConsComp(Tipo tipo, String id, List<String> ids, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.ids = ids;
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitConsComp(this);
	}

}
