package comando;

import exp.Exp;

public class WHILE extends Comando {
	
	Exp exp;
	Comando comando;
	
	public WHILE( Exp exp, Comando comando){
		
		this.exp = exp;
		this.comando = comando;
		
	}
}
