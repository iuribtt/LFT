package checagem;

import sintaxeAbstrata.TBase;

public class Tipo {
	
	public TBase tipoElemento;
	
	/**dimensao = 0 (primitivo); 
	 * dimensao >0 (array) **/
	public int dimensao;
	
	public Tipo(TBase tipoElemento, int dimensao) {
		this.dimensao = dimensao;
		this.tipoElemento = tipoElemento;
	
	}
	
	public boolean equivalente(Tipo tipo){
		
		return (tipoElemento == tipo.tipoElemento && dimensao == tipo.dimensao);
				
	}
	
	
	

}
