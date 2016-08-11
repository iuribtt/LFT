package sintaxeAbstrata;

import visitor.XVisitor;

public class DecCons extends Dec{
	
	public DecCons dCons;
	
	public DecCons(DecCons dCons) {
		
		this.dCons = dCons;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitDecCons(this);
	}

}
