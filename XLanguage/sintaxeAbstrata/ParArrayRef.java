package sintaxeAbstrata;

import visitor.XVisitor;

public class ParArrayRef extends Parametro {
	
	public TBase tBase;
	public int dimensao;
	public String id;
	
	public ParArrayRef(TBase tBase, int dimensao, String id) {
		
		this.tBase = tBase;
		this.dimensao = dimensao;
		this.id = id;
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitParArrayRef(this);
	}

}
