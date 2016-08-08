package sintaxeAbstrata;

import visitor.XVisitor;

public class ParBaseRef extends Parametro {

	TBase tBase;
	String id;

	public ParBaseRef(TBase tBase, String id) {

		this.tBase = tBase;
		this.id = id;

	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitParBaseRef(this);
	}

}
