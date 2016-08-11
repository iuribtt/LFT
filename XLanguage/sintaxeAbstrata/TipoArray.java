package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class TipoArray extends Tipo {
	
	public List<Exp> exps;
	public TBase tBase;
	
	
	public TipoArray(TBase tBase, List<Exp> exps) {
	
		this.tBase = tBase;
		this.exps = exps;
		
	}


	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitTipoArray(this);
	}

}
