package sintaxeAbstrata;

import visitor.XVisitor;

public class ParBaseCopia extends Parametro {
	
	TBase tBase;
	String id;
	
	public ParBaseCopia(TBase tBase, String id) {
		
		this.tBase = tBase;
		this.id = id;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitParBaseCopia(this);
	}

}
