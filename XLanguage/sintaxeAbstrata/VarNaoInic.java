package sintaxeAbstrata;

import visitor.XVisitor;

public class VarNaoInic extends DVar{
	
	Tipo tipo;
	String id;
	
	public VarNaoInic(Tipo tipo, String id) {

		this.tipo = tipo;
		this.id = id;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitVarNaoInic(this);
	}

}
