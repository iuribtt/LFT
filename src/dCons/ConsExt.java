package dCons;

import java.util.List;

import exp.Exp;
import tipo.Tipo;
import var.ID;

public class ConsExt extends DCons{
	
	Tipo tipo;
	ID id;
	List<Exp> exps;

	public ConsExt(Tipo tipo, ID id, List<Exp> exps) {
		
		this.tipo = tipo;
		this.id = id;
		this.exps = exps;
		
	}
	
}
