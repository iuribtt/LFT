package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Funcao extends Dec{

	String id;
	List<Parametro> parametros;
	Exp exp;
	Tipo tipo;
	
	public Funcao(Tipo tipo, String id, List<Parametro> parametros, Exp exp) {
		
		this.tipo = tipo;
		this.id = id;
		this.parametros = parametros;
		this.exp = exp;
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitFuncao(this);
	}

}
