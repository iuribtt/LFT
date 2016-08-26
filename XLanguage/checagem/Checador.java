package checagem;

import java.awt.List;
import java.nio.channels.AlreadyBoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ambiente.TabelaSimbolos;
import sintaxeAbstrata.*;
import visitor.XVisitor;

// xlanguage.chegagem
public class Checador implements XVisitor{


	//HashMap<String, VinculavelConsVar> ambienteVars = new HashMap<String, VinculavelConsVar>();//Begin e EndEscopo

	TabelaSimbolos ambienteVars = new TabelaSimbolos();
	//id
	Map<String, VinculavelFunProc> ambienteSub = new HashMap<String, VinculavelFunProc>();

	ArrayList<String> registroDeErros = new ArrayList<String>();//implementar com uma lista*/
	public Object visitBinExp(BinExp exp) {


		if(exp.operador == BinOp.Som || exp.operador == BinOp.Sub || exp.operador == BinOp.Mul 
				|| exp.operador == BinOp.Div  || exp.operador == BinOp.Mod 
				|| exp.operador == BinOp.Igual || exp.operador == BinOp.Menor){

			TBase tesquerda = (TBase) exp.esquerda.accept(this);
			TBase tdireita = (TBase) exp.direita.accept(this);

			if(tesquerda == TBase.Int && tdireita == TBase.Int){

				return TBase.Int;

			}else if  (tesquerda == TBase.Real && tdireita == TBase.Real){

				return TBase.Real;

			}else if  (tesquerda == TBase.Int && tdireita == TBase.Real){

				exp.esquerda = new IntToReal (exp.esquerda);//IntToReal é mais uma da sintaxe abstrata

				return TBase.Real;

				//}else if  (tesquerda == TBase.Real && tdireita == TBase.Int){
			}else
				//	erro.add("Tipos inconpativeis na soma");//deixar mensagem mais clara

				//return TBase.Int;//uma vez que nao posso adicionar o

				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}

		}else if(exp.operador == BinOp.E ||
				exp.operador == BinOp.Ou){
			//se for n bool return bool and throw
			return null;
		}

		return null;
	}

	public Object visitDecVar(DecVar dVar) {

		dVar.dVar.accept(this);

		return null;
	}

	public Object visitBlocoExp(BlocoExp blocoExp) {


		ambienteVars.beginScope();
		for (DCons d : blocoExp.cons)
			d.accept(this);
		ambienteVars.endScope();

		return null;

	}

	public Object visitDVar(DVar dVar) {

		try{
			ambienteVars.put(((VarNaoInic)dVar).id
					, ((VarNaoInic)dVar).tipo);
		}catch (AlreadyBoundException exc) {
			registroDeErros.add(((VarNaoInic)dVar).id + "repetidamente declarado");
		}

		TBase var = (TBase) dVar.accept(this);

		return var;

	}

	public Object visitAssign(Assign assign) {

		Tipo tyLeft = (Tipo) assign.var.accept(this);
		Tipo tyRight = (Tipo) assign.exp.accept(this);

		if (tyLeft.equivalente(tyRight)) // definir equivalente
			registroDeErros.add(" Assign tipo nao convergem " + tyLeft.tipoElemento + " != " + tyRight.tipoElemento);
		else {
			String id;
			if (assign.var instanceof Simples) {
				id = ((Simples) assign.var).id;
			}else{
				id = getId((Indexada) assign.var); // definir esta função
			}

			VinculavelConsVar vinc = (VinculavelConsVar) ambienteVars.get(id);
			if (vinc.constante)
				registroDeErros.add("Variavel é constante, não pode ser atribuido novamente.");
		}
		return null;

	}

	public String getId(Var var){
		String id = ((Simples)var.accept(this)).id;

		return id;
	}

	public Object visitBloco(Bloco bloco) {
		//begin escopo, adicionar mais um componente na pila e adiciona 

		ambienteVars.beginScope();

		for(DVarConsCom dVarConsCom: bloco.dVarConsComs)
			dVarConsCom.accept(this);

		ambienteVars.endScope();


		return null;

	}

	public Object visitChamanda(Chamada chamada) {
		//Verificar no ambiente de FuncProc e verificar

		//tabela.get(chamada.id);
		//chamada.id TODO

		TBase t = (TBase) chamada.accept(this);

		for (Exp exp : chamada.exps) {
			exp.accept(this);
		}

		return t;

	}

	public Object visitIF(IF i) {

		i.exp.accept(this);

		i.direita.accept(this);
		i.esquerda.accept(this);

		i.exp.accept(this);

		return null;

	}

	public Object visitWHILE(WHILE w) {

		TBase tesquerda = (TBase) w.exp.accept(this);

		w.comando.accept(this);

		return tesquerda;

	}

	public Object visitCons(Cons cons) {

		return cons.exp.accept(this);

	}

	public Object visitConsComp(ConsComp consComp) {

		consComp.exp.accept(this);

		//TBase tBase = (TBase) consComp.exp.accept(this);

		//TODO

		return null;

	}

	public Object visitConsExt(ConsExt consExt) {

		for(Exp exp : consExt.exps){

			exp.accept(this);

		}

		ambienteVars.get(consExt.id);

		//consExt.tipo;

		// TODO

		return null;
	}

	public Object visitDecCons(DecCons dCons) {

		dCons.accept(this);
		return null;
	}

	public Object visitFuncao(Funcao funcao) {

		//TODO
		//coloca a informacao na tabela de sub programa
		ambienteVars.beginScope();

		//procedimento.body.accept(this);

		ambienteVars.endScope();


		return null;
	}

	public Object visitProcedimento(Procedimento procedimento) {
		//TODO
		//se pDec.id já foi declarado ==> error
		//adicionar cabeçalho de pDec em ambienteSub
		ambienteVars.beginScope();
		//... elabora decls dos parâmetros formais pDec.formais
		//procedimento.body.accept(this);
		ambienteVars.endScope();

		return null;
	}

	public Object visitVarInic(VarInic varInic) {

		// TODO gerar ifs para cada tipo base

		TBase tipo = (TBase) varInic.exp.accept(this);

		if(tipo == TBase.Int){

		}

		return null;
	}

	public Object visitVarInicComp(VarInicComp varInicComp) {
		// TODO gerar ifs para cada tipo base
		return null;
	}

	public Object visitVarInicExt(VarInicExt varInicExt) {

		for ( Exp exp : varInicExt.exps)
			exp.accept(this);


		ambienteVars.put(varInicExt.id, ((TBase) varInicExt.tipo.accept(this)));

		return null;
	}

	public Object visitVarNaoInic(VarNaoInic varNaoInic) {
		/**TODO Usar o get e chegar o tipo ou colocar no ambiente*/
		ambienteVars.put(varNaoInic.id, varNaoInic.tipo.accept(this));

		return null;
	}

	public Object visitCom(Com com) {
		com.comando.accept(this);
		return null;
	}

	public Object visitDC(DC dc) {

		dc.dCons.accept(this);

		return null;
	}

	public Object visitDV(DV dv) {

		dv.dVar.accept(this);

		return null;
	}

	public Object visitChamadaExp(ChamadaExp chamadaExp) {


		VinculavelFunProc vinc = ambienteSub.get(chamadaExp.id);
		if (vinc == null)
			registroDeErros.add("... procedimento não declarado ....");
		/*else if (vinc.tipo instanceof Funcao)
			registroDeErros.add("... chamando fun ao invés de proced ...");*/
		else {//TODO
			/*Proc proc = (Proc) vinc;
			... checar que os parâmetros reais tem tipos equivalentes
			    com os parâmetros formais e se o parâmetro foi declarado
				por referência, o correspondente par. real é uma variável ...*/
		}
		return null;

	}

	public Object visitLiteralBool(LiteralBool literalBool) {

		return literalBool.b;
	}

	public Object visitLiteralInt(LiteralInt literalInt) {

		return literalInt.i;
	}

	public Object visitMenos(Menos menos) {

		menos.exp.accept(this);

		return null;
	}

	public Object visitNao(Nao nao) {

		TBase tBase = (TBase) nao.accept(this);

		if(tBase != TBase.Real || tBase != TBase.Int){

			lancarExcecao("visitNao");


		}

		return null;
	}

	public Object visitVarExp(VarExp varExp) {

		varExp.var.accept(this);

		return null;
	}

	public Object visitParArrayCopia(ParArrayCopia parArrayCopia) {
		/**O que fazer com a dimensao TODO
		parArrayRef.dimensao;*/

		//TODO
		TBase tbase = ((TipoBase) ambienteVars.get(parArrayCopia.id)).tBase;

		if(!parArrayCopia.tBase.getClass().equals(tbase.getClass()) ){
			lancarExcecao("visitParArrayCopia");

		}

		return null;
	}

	public Object visitParArrayRef(ParArrayRef parArrayRef) {


		/**O que fazer com a dimensao
		parArrayRef.dimensao;*/
		//TODO
		TBase tbase = ((TipoBase) ambienteVars.get(parArrayRef.id)).tBase;

		if(!parArrayRef.tBase.getClass().equals(tbase.getClass()) ){
			lancarExcecao("visitParArrayRef");

		}

		return null;
	}

	public Object visitParBaseCopia(ParBaseCopia parBaseCopia) {
		//TODO
		ambienteVars.put(parBaseCopia.id, parBaseCopia.tBase );
		//ambienteVars.put(parBaseCopia.id, new VinculavelConsVar(false, parBaseCopia.tBase) );

		return null;
	}

	public Object visitParBaseRef(ParBaseRef parBaseRef) {

		//TODO
		ambienteVars.put(parBaseRef.id, parBaseRef.tBase );
		//ambienteVars.put(parBaseCopia.id, new VinculavelConsVar(false, parBaseCopia.tBase) );
		
		return null;
	}

	public Object visitPrograma(Programa programa) {

		for(Dec decs: programa.decs)
			decs.accept(this);

		return null;
	}

	public Object visitTipoArray(TipoArray tipoArray) {

		for(Exp exp : tipoArray.exps ){
			TBase tbase = (TBase) exp.accept(this);
			if(!tipoArray.tBase.getClass().equals(tbase.getClass()) ){
				lancarExcecao("visitTipoArray");

			}

		}

		return null;
	}

	public Object visitSimples(Simples simples) {
		VinculavelConsVar vinc = (VinculavelConsVar) ambienteVars.get(simples.id);
		if (vinc == null) {
			registroDeErros.add("variável " + simples.id + " não declarada");
			return vinc.tipo; //TODO Uma solução: definir um tipo void que é subtipo de todo tipo
			//TODO e devolver ele.
		} else
			return vinc.tipo; // O campo type deve estar na superclasse

	}

	public Object visitIndexada(Indexada indexada) {

		indexada.var.accept(this);

		indexada.exp.accept(this);

		return null;
	}

	public Object visitLiteralReal(LiteralReal literalReal) {

		return literalReal.real;
	}

	public Object visitTipoBase(sintaxeAbstrata.TipoBase tipoBase) {

		return tipoBase.tBase;
	}

	private void lancarExcecao(String mensagem){

		try {
			throw new Exception(mensagem);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object visitIntToReal(IntToReal intToReal) {
		// TODO Auto-generated method stub
		return null;
	}


}
