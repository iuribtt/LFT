package comando;

import java.util.List;

import exp.Exp;
import var.ID;

public class Chamanda extends Comando {
	
	ID id;
	List<Exp> exps;
	
	public Chamanda(ID id, List<Exp> exps) {
		
		this.id = id;
		this.exps = exps;
	
	}

}
