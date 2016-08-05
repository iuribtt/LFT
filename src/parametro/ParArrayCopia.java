package parametro;

import tBase.TBase;
import var.ID;

public class ParArrayCopia extends Parametro {
	
	TBase tBase;
	int dimensao;
	ID id;
	
	public ParArrayCopia(TBase tBase, int dimensao, ID id) {
		
		this.tBase = tBase;
		this.dimensao = dimensao;
		this.id = id;
		
	}
}
