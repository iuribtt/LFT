package checagem;

import sintaxeAbstrata.Exp;
import sintaxeAbstrata.LiteralReal;

public class MetodosAuxiliar {
	

	public static Exp intoToReal(Exp esquerda) {
		
		Exp exp = (LiteralReal) esquerda;
				
		return exp;
	
	}

}
