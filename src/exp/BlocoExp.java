package exp;

import java.util.List;

import dCons.DCons;

public class BlocoExp {
	
	List<DCons> cons;
	Exp exp;
	
	public BlocoExp(List<DCons> cons, Exp exp) {
		this.cons = cons;
		this.exp = exp;
	}

}
