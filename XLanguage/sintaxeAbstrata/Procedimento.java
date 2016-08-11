package sintaxeAbstrata;

import java.util.List;

import visitor.XVisitor;

public class Procedimento extends Dec{

	public String id;
	public List<Parametro> parametros;
	public Comando comando;
	
	public Procedimento(String id, List<Parametro> parametros, Comando comando) {
		
		this.id = id;
		this.parametros = parametros;
		this.comando = comando;
	}

	@Override
	public Object accept(XVisitor visitor) {
		
		return visitor.visitProcedimento(this);
		
	}
	

}
