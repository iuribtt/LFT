package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class VarInicComp  extends DVar{
	
	
	public Tipo tipo;
	String id;
	List<String> ids;
	Exp exp;
	
	public VarInicComp(Tipo tipo, String id, List<String> ids, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.ids = ids;
		this.exp = exp;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitVarInicComp(this);
	}

}
