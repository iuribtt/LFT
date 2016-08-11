package ambiente;

import java.util.HashMap;
import java.util.Map;

public class Tabela {

	Map<Symbol, Object> memoria; 

	public Tabela() {

		memoria = new HashMap<Symbol, Object>();//Memoria 

	}

	public Object put(Symbol key, Object value) {

		return memoria.put(key, value);

	}

	public Object get(Symbol key) {

		return memoria.get(key);

	}

}