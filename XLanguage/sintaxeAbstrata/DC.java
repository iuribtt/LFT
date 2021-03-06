package sintaxeAbstrata;

import visitor.XVisitor;

public class DC extends DVarConsCom{
	
	public DCons dCons;
	
	public DC(DCons dCons) {
		
		this.dCons = dCons;
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitDC(this);
	}

}
