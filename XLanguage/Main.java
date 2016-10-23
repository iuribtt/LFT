import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import checagem.Checador;
import sintaxeAbstrata.*;
import visitor.XVisitor;

public class Main {



	public static void main(String[] args) {

		List<Dec> d = new ArrayList<Dec>();

		//Parametro da funcao
		List<Parametro> parametros = new ArrayList<Parametro>();

		//declaracao e inicializacao da variavel lado
		d.add( new DecVar(new VarInic(new TipoBase(TBase.Int), "lado", new LiteralBool(true))));
		
		d.add( new DecVar(new VarInic(new TipoBase(TBase.Int), "lado", new LiteralInt(7))));
		
		Programa prog2 = new Programa (d);

		
		Checador c = new Checador();
		prog2.accept(c);
		
		for(String erro :c.registroDeErros){
			
			System.out.println(erro);
		}
		
		/*PROG1();
		PROG2();*/


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
	 * 
	 * var int numero := 8;
	 * var bool par; 
	 * 
	 * if (numero % 2 = 0) 
	 * 	 par := true;
	 * else 
	 *   par := false;
	 *   
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
				new Funcao(new TipoBase(TBase.Int), "areaQuadrado", parametros, 
						new	BinExp(BinOp.Mul, new VarExp(new Simples("l")), new VarExp(new Simples("l")))
						)
				);


		//declaracao da variavel area
		d.add (new DecVar(new VarNaoInic(new TipoBase(TBase.Int),"area")));

		//paramentro lado sera passado na chamada da funcao
		List<Exp> passagemParametros = new ArrayList<Exp>();
		passagemParametros.add( new VarExp(new Simples("lado")));

		//atribuicao do resultado da funcao areaQuadrado a variavel area
		new Assign (new Simples("area"), new ChamadaExp("areaQuadrado", passagemParametros));


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

	// Achar o raiz quadrada de 2 pelo metodo de bissecção

	/**<pre>
	 *  	public class sqrt2 {
	 *public static void main(String args[]) {
	 *
	 *Sintaxe Concreta PROG3
	 *double a, b, x=1.5, erro = 0.05;
	 *
	 *a = 1; b = 2; // 1 < (raiz de 2) < 2
	 *while(erro  <  (b-a)) {
	 *   x = (a+b)/2;
	 *   if (x*x < 2) // x < raiz de 2
	 *      a = x;
	 *   else // x >= raiz de 2
	 *      b = x;
	 *}
	 *System.out.println("Valor aproximado de raiz quadrada de 2: " + x);
	 *}
	 *} 
	</pre>	
	 **/

	private static void PROG2() {

		List<Dec> decs = new ArrayList<Dec>();
		

		//double a, b, x=1.5, erro = 0.05;
		decs.add (new DecVar(new VarNaoInic(new TipoBase(TBase.Real), "a")));
		decs.add (new DecVar(new VarNaoInic(new TipoBase(TBase.Real), "b")));

		decs.add (new DecVar(new VarInic(new TipoBase(TBase.Real), "x", new LiteralReal(1.5))));
		decs.add (new DecVar(new VarInic(new TipoBase(TBase.Real), "erro", new LiteralReal(0.05))));

		// a = 1; b = 2;
		new Assign (new Simples("a"), new LiteralInt(1));
		new Assign (new Simples("b"), new LiteralInt(2));

		List<DVarConsCom> dVarConsComs = new ArrayList<DVarConsCom>();
		dVarConsComs.add(
				new Com(
						new Assign(
								new Simples("x"), 
								new BinExp(BinOp.Div, new BinExp( BinOp.Som,  new VarExp(new Simples("a")),
										new VarExp(new Simples("b"))), new LiteralInt(2) ) 
								)));

		dVarConsComs.add(	
				new Com(
						new IF( 	
								new BinExp(BinOp.Menor,
										new BinExp( BinOp.Mul,  new VarExp(new Simples("x")),
												new VarExp(new Simples("x"))), new LiteralInt(2) ),
								new Assign(
										new Simples("a"), new VarExp( new Simples("x") ) ), 
								new Assign(
										new Simples("b"), new VarExp( new Simples("x") ) ) 
								)
						));


		new WHILE(new BinExp(BinOp.Menor, new VarExp(new Simples("erro")), 
				
				new BinExp(BinOp.Menor, 
						new VarExp(new Simples("b")), 
						new VarExp(new Simples("a")))), 
				new Bloco(dVarConsComs)
				);


		Programa prog3 = new Programa(decs);
		System.out.println(prog3.decs);

	}

}