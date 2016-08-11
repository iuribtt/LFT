package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class VarInicExt extends DVar{
	
	
	public Tipo tipo;
	public String id;
	public List<Exp> exps;
	
	public VarInicExt(Tipo tipo, String id, List<Exp> exps) {
		
		this.tipo = tipo;
		this.id = id;
		this.exps = exps;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitVarInicExt(this);
	}

}
