package sintaxeAbstrata;

import visitor.XVisitor;

public class WHILE extends Comando {
	
	public Exp exp;
	public Comando comando;
	
	public WHILE( Exp exp, Comando comando){
		
		this.exp = exp;
		this.comando = comando;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitWHILE(this);
	}
	
}
