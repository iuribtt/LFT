package exp;

import java.util.List;

import var.ID;

public class ChamadaExp extends Exp {
	
	ID id;
	List<Exp> exps;
	
	public ChamadaExp(ID id, List<Exp> exps) {
		
		this.id = id;
		this.exps = exps;
		
	}

}
