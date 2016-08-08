package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Funcao extends Dec{

	String id;
	List<Parametro> parametros;
	Comando comando;
	Tipo tipo;
	
	public Funcao(Tipo tipo, String id, List<Parametro> parametros, Comando comando) {
		
		this.tipo = tipo;
		this.id = id;
		this.parametros = parametros;
		this.comando = comando;
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitFuncao(this);
	}

}
