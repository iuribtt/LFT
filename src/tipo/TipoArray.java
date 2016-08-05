package tipo;

import java.util.List;

import exp.Exp;
import tBase.TBase;

public class TipoArray extends Tipo {
	
	List<Exp> exps;
	TBase tBase;
	
	
	public TipoArray(TBase tBase, List<Exp> exps) {
	
		this.tBase = tBase;
		this.exps = exps;
		
		
	}

}
