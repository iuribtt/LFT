package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Bloco extends Comando {
	
	List<DVarConsCom> dVarConsComs;
	
	public Bloco(List<DVarConsCom> dVarConsComs) {
		
		this.dVarConsComs = dVarConsComs;
	
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitBloco(this);
	}

}
