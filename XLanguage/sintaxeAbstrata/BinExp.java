package sintaxeAbstrata;

import visitor.XVisitor;

public class BinExp extends Exp {

	public Exp esquerda, direita;
	public BinOp operador;

	public BinExp(BinOp operador, Exp esquerda, Exp direita) {
		
		this.operador = operador; 
		this.esquerda = esquerda; 
		this.direita = direita; 
		
	}

	@Override
	public Object accept(XVisitor visitor) {
		return visitor.visitBinExp(this);
	}

}