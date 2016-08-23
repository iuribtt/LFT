package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Programa {
	
	
	public List<Dec> decs;
	
	public Programa(List<Dec> decs) {
		
		this.decs = decs;
		
	}
	
	public Object accept(XVisitor visitor) {
		return visitor.visitPrograma(this);
	}
	
	
}
