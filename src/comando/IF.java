package comando;

import exp.Exp;

public class IF extends Comando {
	
	Exp exp;
	Comando esquerda;
	Comando direita;
	
	public IF( Exp exp, Comando esquerda, Comando direita){
		
		this.exp = exp;
		this.esquerda = esquerda;
		this.direita = direita;
		
	}

}
