package sintaxeAbstrata;

import visitor.XVisitor;

public class VarInic extends DVar {

	public Tipo tipo;
	public String id;
	public Exp exp;

	public VarInic(Tipo tipo, String id, Exp exp) {

		this.tipo = tipo;
		this.id = id;
		this.exp = exp;

	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitVarInic(this);
	}

}
