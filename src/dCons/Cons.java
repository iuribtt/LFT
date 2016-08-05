package dCons;

import exp.Exp;
import tipo.Tipo;
import var.ID;

public class Cons extends DCons{
	
	Tipo tipo;
	ID id;
	Exp exp;

	public Cons(Tipo tipo, ID id, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.exp = exp;
		
	}
	
}
