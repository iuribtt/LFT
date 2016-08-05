package parametro;

import tBase.TBase;
import var.ID;

public class ParArrayRef extends Parametro {
	
	TBase tBase;
	int dimensao;
	ID id;
	
	public ParArrayRef(TBase tBase, int dimensao, ID id) {
		
		this.tBase = tBase;
		this.dimensao = dimensao;
		this.id = id;
		
	}

}
