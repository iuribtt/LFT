package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class ChamadaExp extends Exp {
	
	String id;
	List<Exp> exps;
	
	public ChamadaExp(String id, List<Exp> exps) {
		
		this.id = id;
		this.exps = exps;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitChamadaExp(this);
	}

}
