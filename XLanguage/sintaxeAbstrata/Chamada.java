package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Chamada extends Comando {
	
	public String id;
	public List<Exp> exps;
	
	public Chamada(String id, List<Exp> exps) {
		
		this.id = id;
		this.exps = exps;
	
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitChamada(this);
	}

}
