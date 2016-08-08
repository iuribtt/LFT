package sintaxeAbstrata;

import visitor.XVisitor;

public class TipoBase extends Tipo{
	
	TBase tBase;
	
	public TipoBase(TBase tBase) {
		
		this.tBase = tBase;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitTipoBase(this);
	}

}
