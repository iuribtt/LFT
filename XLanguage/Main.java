import java.util.ArrayList;
import java.util.List;

import sintaxeAbstrata.*;

public class Main {


	
	public static void main(String[] args) {
		
		PROG1();
		
		PROG2();
			
	}
	
	/**<pre>
	 * Sintaxe Concreta PROG1
	 * 
	 * var int lado := 7;
	 * var int area; 
	 * 
	 * function int areaQuadrado (var int l)
	 * 		l*l;
	 * 
	 * area := areaQuadrado(lado); 
	 * </pre>	
	*/
	private static void PROG1() {

	
		
		
		//Todas as declaracoes do programa
		List<Dec> d = new ArrayList<Dec>();
		
		//Parametro da funcao
		List<Parametro> parametros = new ArrayList<Parametro>();
		parametros.add( new ParBaseCopia(TBase.Int, "l"));
		
		//declaracao e inicializacao da variavel lado
		d.add( new DecVar(new VarInic(new TipoBase(TBase.Int), "lado", new LiteralInt(7))));
		
		//declaracao da funcao areaQuadrado
		d.add (
				new Funcao(new TipoBase(TBase.Int), "areaQuadrado", parametros, new
						BinExp(BinOp.Mul, new VarExp(new Simples("l")), new VarExp(new Simples("l")))
				)
		);
		
		
		//declaracao da variavel area
		d.add (new DecVar(new VarNaoInic(new TipoBase(TBase.Int),"area")));
		
		//paramentro lado sera passado na chamada da funcao
		List<Exp> passagemParametros = new ArrayList<Exp>();
		passagemParametros.add( new VarExp(new Simples("lado")));
		
		//atribuicao do resultado da funcao areaQuadrado a variavel area
		new Assign (new Simples("area"), new ChamadaExp("areaQuadrado", passagemParametros));
		
		Programa prog1 = new Programa (d);
		System.out.println("PROG 1");
		System.out.println(prog1.decs);
		
	}
	
	/**<pre>
	 * Sintaxe Concreta PROG2
	 * 
	 * var int numero := 8;
	 * var bool par; 
	 * 
	 * if (numero % 2 = 0) 
	 * 	 par := true;
	 * else 
	 *   par := false;
	 * </pre>		
	*/
	private static void PROG2() {

				
		List<Dec> d = new ArrayList<Dec>();
		
		d.add (new DecVar(new VarInic(new TipoBase(TBase.Int), "numero", new LiteralInt(8))));
		d.add (new DecVar(new VarNaoInic(new TipoBase(TBase.Bool), "par")));
		
		new IF(
				new BinExp(
						BinOp.Igual,
						new LiteralInt(0),
						new BinExp(
								BinOp.Mod,
								new VarExp(new Simples("numero")),
								new LiteralInt(2)
						)
				),
				new Assign (new Simples("par"), new LiteralBool(true)),
				new Assign (new Simples("par"), new LiteralBool(false))
								
				);
		
		Programa prog2 = new Programa (d);
		System.out.println(prog2.decs);
		
	}

	/*List<Dec> decs = new ArrayList<Dec>();
	
	decs.add(new DecVar(new VarInic(new TipoBase(TBase.Int), "x", new LiteralInt(5))));
	
	List<Parametro> parametros =  new ArrayList<Parametro>();
	parametros.add( new ParBaseCopia(TBase.Int, "a"));
	
	decs.add(new Funcao(new TipoBase(TBase.Int), "q", parametros, new BinExp(BinOp.Mul, new VarExp(new Simples("a")) , new VarExp(new Simples("a")) )));
	
	List<Exp> exps = new ArrayList<Exp>();
	exps.add(new VarExp(new Simples("x")));
	
	
	new Assign (new Simples("area"), new ChamadaExp("q", exps));
	
	Programa p = new Programa(decs);*/
	
}
