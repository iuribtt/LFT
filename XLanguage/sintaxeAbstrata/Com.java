package sintaxeAbstrata;

import visitor.XVisitor;

public class Com extends DVarConsCom {
	
	public Comando comando;
	
	public Com(Comando comando) {
		
		this.comando = comando;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitCom(this);
	}


}
