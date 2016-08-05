package comando;

import java.util.List;

import dVarConsCom.DVarConsCom;

public class Bloco extends Comando {
	
	List<DVarConsCom> dVarConsComs;
	
	public Bloco(List<DVarConsCom> dVarConsComs) {
		
		this.dVarConsComs = dVarConsComs;
	
		
	}

}
