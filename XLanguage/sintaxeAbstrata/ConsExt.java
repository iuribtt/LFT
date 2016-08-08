package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class ConsExt extends DCons{
	
	Tipo tipo;
	String id;
	List<Exp> exps;

	public ConsExt(Tipo tipo, String id, List<Exp> exps) {
		
		this.tipo = tipo;
		this.id = id;
		this.exps = exps;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
