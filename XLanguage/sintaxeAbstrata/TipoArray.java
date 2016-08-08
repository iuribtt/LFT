package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class TipoArray extends Tipo {
	
	List<Exp> exps;
	TBase tBase;
	
	
	public TipoArray(TBase tBase, List<Exp> exps) {
	
		this.tBase = tBase;
		this.exps = exps;
		
	}


	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitTipoArray(this);
	}

}
