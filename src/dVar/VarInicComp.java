package dVar;

import java.util.List;

import exp.Exp;
import tipo.Tipo;
import var.ID;

public class VarInicComp {
	
	
	Tipo tipo;
	ID id;
	List<ID> ids;
	Exp exp;
	
	public VarInicComp(Tipo tipo, ID id, List<ID> ids, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.ids = ids;
		this.exp = exp;
		
	}

}
