package comando;

import exp.Exp;
import var.Var;

public class Assign extends Comando{
	
	Var var;
	Exp exp;
	
	public Assign(Var var, Exp exp) {
		
		this.var = var;
		this.exp = exp;
		
	}

}
