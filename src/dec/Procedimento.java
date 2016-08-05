package dec;

import java.util.List;

import comando.Comando;
import parametro.Parametro;
import var.ID;

public class Procedimento extends Dec{

	ID id;
	List<Parametro> parametros;
	Comando comando;
	
	public Procedimento(ID id, List<Parametro> parametros, Comando comando) {
		
		this.id = id;
		this.parametros = parametros;
		this.comando = comando;
	}

}
