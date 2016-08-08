package sintaxeAbstrata;

import visitor.XVisitor;

public class DecVar extends Dec{
	
	public DVar dVar;
	
	public DecVar(DVar dVar) {
		
		this.dVar = dVar;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
	
		return visitor.visitDecVar(this);
	}

}
