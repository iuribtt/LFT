package sintaxeAbstrata;

import visitor.XVisitor;

public class DV extends DVarConsCom{
	
	public DVar dVar;

	public DV(DVar dVar) {
		
		this.dVar = dVar;
	
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitDV(this);
	}
}
