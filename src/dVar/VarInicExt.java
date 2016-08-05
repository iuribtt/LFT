package dVar;

import java.util.List;

import exp.Exp;
import tipo.Tipo;
import var.ID;

public class VarInicExt {
	
	
	Tipo tipo;
	ID id;
	List<Exp> exps;
	
	public VarInicExt(Tipo tipo, ID id, List<Exp> exps) {
		
		this.tipo = tipo;
		this.id = id;
		this.exps = exps;
		
	}

}
