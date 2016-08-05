package dec;

import java.util.List;

import comando.Comando;
import parametro.Parametro;
import tipo.Tipo;
import var.ID;

public class Funcao extends Dec{

	ID id;
	List<Parametro> parametros;
	Comando comando;
	Tipo tipo;
	
	public Funcao(Tipo tipo, ID id, List<Parametro> parametros, Comando comando) {
		
		this.tipo = tipo;
		this.id = id;
		this.parametros = parametros;
		this.comando = comando;
	}

}
