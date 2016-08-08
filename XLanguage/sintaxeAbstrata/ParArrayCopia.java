package sintaxeAbstrata;

import visitor.XVisitor;

public class ParArrayCopia extends Parametro {
	
	TBase tBase;
	int dimensao;
	String id;
	
	public ParArrayCopia(TBase tBase, int dimensao, String id) {
		
		this.tBase = tBase;
		this.dimensao = dimensao;
		this.id = id;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitParArrayCopia(this);
	}
}
