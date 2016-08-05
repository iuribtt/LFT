package dVar;

import exp.Exp;
import tipo.Tipo;
import var.ID;

public class VarInic extends DVar{
	
	Tipo tipo;
	ID id;
	Exp exp;
	
	public VarInic(Tipo tipo, ID id, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.exp = exp;
		
	}

}
