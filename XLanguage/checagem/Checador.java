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

	public ArrayList<String> registroDeErros = new ArrayList<String>();//implementar com uma lista*/

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

				registroDeErros.add("Tipos incompatíveis na soma.");

			return TBase.Int; 

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

	public Object visitChamada(Chamada chamada) {
		//Verificar no ambiente de FuncProc e verificar

		//de funcao erro, procedimento checa os tipos, se for declarao por referencia ou copia
		//chamada.id TODO


		//ambienteSub.get(chamada.id).tipo

		//TBase tBase = (TBase) chamada.accept(this);

		if(tBase != ambienteSub.get(chamada.id).tipo){//conversão de tipos

			registroDeErros.add("Chamada tipo incompativel");
		}

		for (Exp exp : chamada.exps) {
			exp.accept(this);
		}

		return null;

	}

	public Object visitIF(IF i) {

		TBase tBase = ((TBase)i.exp.accept(this));


		if(tBase != TBase.Bool ){

			registroDeErros.add("IF suporta expressão somente boleana");
		}

		i.direita.accept(this);
		i.esquerda.accept(this);

		return null;

	}

	public Object visitWHILE(WHILE w) {

		TBase tBase = ((TBase)w.exp.accept(this));


		if(tBase != TBase.Bool ){

			registroDeErros.add("WHILE suporta expressão somente boleana");
		}


		w.comando.accept(this);


		return null;

	}

	public Object visitCons(Cons cons) {

		return cons.exp.accept(this);

	}

	public Object visitConsComp(ConsComp consComp) {

		//TODO
		//consComp.ids; 	
		//pesquiso todos os ids e vejo se o tipo bate -- isso é para vetor?
		for(String id :consComp.ids){

			TBase tipo = (TBase) ambienteVars.get(id);
			if(tipo != consComp.tipo.accept(this) )
				registroDeErros.add("ConsComp - ids com tipos incompativeis");
		}


		TBase tBase = (TBase) consComp.exp.accept(this);


		if(tBase != consComp.tipo.accept(this) ){

			registroDeErros.add("ConsComp - tipo incompativel");
		}

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

		funcao.exp.accept(this);

		for(Parametro parametro : funcao.parametros){

			parametro.accept(this);
		}


		/*ambienteSub.put(funcao.id, new VinculavelFunProc(false, funcao.tipo ));//Divergencia de tipos*/

		//procedimento.body.accept(this);

		ambienteVars.endScope();


		return null;
	}

	//Se caso seja por referencia somente variavel, se for pro referencia
	public Object visitProcedimento(Procedimento procedimento) {
		//TODO
		//se pDec.id já foi declarado ==> error
		//adicionar cabeçalho de pDec em ambienteSub
		ambienteVars.beginScope();
		//... elabora decls dos parâmetros formais pDec.formais
		//procedimento.body.accept(this);

		procedimento.comando.accept(this);

		for(Parametro parametro : procedimento.parametros){

			//(TBase)parametro.accept(this));
			ambienteSub.put(procedimento.id, new VinculavelFunProc(true, List<Tipos> ));//Coloca no ambiente

		}

		ambienteVars.endScope();

		return null;
	}

	public Object visitVarInic(VarInic varInic) {

		TBase tipo = (TBase) varInic.exp.accept(this);

		if(ambienteVars.get(varInic.id) != null){
			registroDeErros.add("Variavel \"" + varInic.id + "\" já foi mapeada (Duplicada).");
		}

		if(tipo != ((TBase)varInic.tipo.accept(this))){
			registroDeErros.add("Tipos incompativel para a variavel \"" + varInic.id + "\"");
		}

		ambienteVars.put(varInic.id, ((TBase) varInic.tipo.accept(this)));//Coloca no ambiente

		return tipo;
	}

	public Object visitVarInicComp(VarInicComp varInicComp) {

		//TODO Iniciar escopo? {i|b[i]} ou {i|i+i}
		//criar um escopo para i e verificar b

		varInicComp.id;
		varInicComp.ids;

		TBase tBase = (TBase) varInicComp.exp.accept(this);

		if(tBase != varInicComp.tipo.accept(this))
			registroDeErros.add("Tipos incompativel para a variavel \"" + varInicComp.id + "\"");


		return varInicComp.tipo;
	}

	public Object visitVarInicExt(VarInicExt varInicExt) {

		//{0,0,5,8,8 } chegar os tipos equivalencia
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

		///se chamar procediemto erro pois necesita do retorno
		VinculavelFunProc vinc = ambienteSub.get(chamadaExp.id);
		if (vinc == null){
			registroDeErros.add("... procedimento não declarado ....");
		}else

			if (!vinc.isProcedimento){

				registroDeErros.add("... chamando fun ao invés de procedimento ...");

			}else {

				//Procedimento proc = (Procedimento) vinc;
				/*... checar que os parâmetros reais tem tipos equivalentes
			    com os parâmetros formais e se o parâmetro foi declarado
				por referência, o correspondente par. real é uma variável ...*/
			}

		return vinc.tipo;

	}

	public Object visitLiteralBool(LiteralBool literalBool) {

		return TBase.Bool;
	}

	public Object visitLiteralInt(LiteralInt literalInt) {

		return TBase.Int;
	}
	public Object visitLiteralReal(LiteralReal literalReal) {

		return TBase.Real;
	}


	public Object visitMenos(Menos menos) {

		TBase tBase = (TBase) menos.accept(this);

		if(tBase != TBase.Real || tBase != TBase.Int){

			registroDeErros.add("Menos de tipo não numerico.");
		}

		return null;
	}

	public Object visitNao(Nao nao) {

		TBase tBase = (TBase) nao.accept(this);

		if(tBase != TBase.Bool ){

			registroDeErros.add("Negação de tipo não boolean.");
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
			registroDeErros.add("Array Copia tipo inconsistentes");

		}

		return null;
	}



	public Object visitParArrayRef(ParArrayRef parArrayRef) {


		//O que fazer com a dimensao
		//parArrayRef.dimensao
		//TODO
		TBase tbase = ((TipoBase) ambienteVars.get(parArrayRef.id)).tBase;

		//TBase tbase = (TBase) parArrayRef.accept(this);
		if (parArrayRef.tBase != tbase){
			registroDeErros.add("Array referencia tipo inconsistentes");
		}

		return null;
	}

	public Object visitParBaseCopia(ParBaseCopia parBaseCopia) {
		ambienteVars.put(parBaseCopia.id, parBaseCopia.tBase );
		return null;
	}

	public Object visitParBaseRef(ParBaseRef parBaseRef) {
		ambienteVars.put(parBaseRef.id, parBaseRef.tBase );
		return null;
	}

	public Object visitPrograma(Programa programa) {


		/*for(Dec decs: programa.decs)
			adcicionar no amiente de funcoes os cabecalhos
			instanceof
		 */

		for(Dec decs: programa.decs)
			decs.accept(this);

		return null;
	}

	public Object visitTipoArray(TipoArray tipoArray) {

		for(Exp exp : tipoArray.exps ){
			TBase tbase = (TBase) exp.accept(this);
			if (tipoArray.tBase != tbase){
				registroDeErros.add("Array tipo inconsistentes");
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



	public Object visitTipoBase(sintaxeAbstrata.TipoBase tipoBase) {

		return tipoBase.tBase;
	}

	public Object visitIntToReal(IntToReal intToReal) {
		return intToReal.accept(this);
	}


}
