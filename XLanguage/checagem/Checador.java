package checagem;

import java.util.HashMap;
import java.util.List;

import sintaxeAbstrata.Assign;
import sintaxeAbstrata.BinExp;
import sintaxeAbstrata.BinOp;
import sintaxeAbstrata.Bloco;
import sintaxeAbstrata.BlocoExp;
import sintaxeAbstrata.Chamada;
import sintaxeAbstrata.ChamadaExp;
import sintaxeAbstrata.Com;
import sintaxeAbstrata.Comando;
import sintaxeAbstrata.Cons;
import sintaxeAbstrata.ConsComp;
import sintaxeAbstrata.ConsExt;
import sintaxeAbstrata.DC;
import sintaxeAbstrata.DV;
import sintaxeAbstrata.DVar;
import sintaxeAbstrata.DVarConsCom;
import sintaxeAbstrata.Dec;
import sintaxeAbstrata.DecCons;
import sintaxeAbstrata.DecVar;
import sintaxeAbstrata.Exp;
import sintaxeAbstrata.Funcao;
import sintaxeAbstrata.IF;
import sintaxeAbstrata.Indexada;
import sintaxeAbstrata.LiteralBool;
import sintaxeAbstrata.LiteralInt;
import sintaxeAbstrata.Menos;
import sintaxeAbstrata.Nao;
import sintaxeAbstrata.ParArrayCopia;
import sintaxeAbstrata.ParArrayRef;
import sintaxeAbstrata.ParBaseCopia;
import sintaxeAbstrata.ParBaseRef;
import sintaxeAbstrata.Parametro;
import sintaxeAbstrata.Procedimento;
import sintaxeAbstrata.Programa;
import sintaxeAbstrata.Simples;
import sintaxeAbstrata.TBase;
import sintaxeAbstrata.Tipo;
import sintaxeAbstrata.TipoArray;
import sintaxeAbstrata.TipoBase;
import sintaxeAbstrata.Var;
import sintaxeAbstrata.VarExp;
import sintaxeAbstrata.VarInic;
import sintaxeAbstrata.VarInicComp;
import sintaxeAbstrata.VarInicExt;
import sintaxeAbstrata.VarNaoInic;
import sintaxeAbstrata.WHILE;
import visitor.XVisitor;

// xlanguage.chegagem
public class Checador implements XVisitor{

	//TabelaSimbolos<String, VinculavelConsVar> ambienteVars = new TabelaSimbolos<...>();
	
	//HashMap<String, VinculavelFunProg> ambienteSub = new HasMap<...>();
	
	
	public Object visitBinExp(BinExp exp) {
	
		/*if(operador == BinOp.Som){
			//type classe criada?
			Type tesquerda = (Type) esquerda.left.accept(this);
			Type tdireita = (Type) direita.left.accept(this);
			
			if(tesquerda == TBase.Int && tdireita == TBase.Int)
				return TBase.Int;
			
			else if  (tesquerda == TBase.Real && tdireita == TBase.Real)
				return TBase.Real;
			
			else
				throw new Exception();
		}else if(operador == BinOp.Mul){*/
		//....
			
		return null;
	}
	
	public Object visitDecVar(DecVar dVar) {
		
		//dVar.dVar.accept(this);
		return null;
	}
	
	public Object visitDVar(DVar dVar) {
		
		//ambienteVars.put(dVar.Var.id, dVar.tipo);
		
		return null;
	}

	public Object visitAssign(Assign assign) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitBloco(Bloco bloco) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitChamanda(Chamada chamada) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIF(IF i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitWHILE(WHILE w) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCons(Cons cons) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitConsComp(ConsComp consComp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitConsExt(ConsExt consExt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitDecCons(DecCons dCons) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitFuncao(Funcao funcao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitProcedimento(Procedimento procedimento) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarInic(VarInic varInic) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarInicComp(VarInicComp varInicComp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarInicExt(VarInicExt varInicExt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarNaoInic(VarNaoInic varNaoInic) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCom(Com com) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitDC(DC dc) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitDV(DV dv) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitBlocoExp(BlocoExp blocoExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitChamadaExp(ChamadaExp chamadaExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitLiteralBool(LiteralBool literalBool) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitLiteralInt(LiteralInt literalInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMenos(Menos menos) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitNao(Nao nao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVarExp(VarExp varExp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParArrayCopia(ParArrayCopia parArrayCopia) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParArrayRef(ParArrayRef parArrayRef) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParBaseCopia(ParBaseCopia parBaseCopia) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParBaseRef(ParBaseRef parBaseRef) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPrograma(Programa programa) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTipoArray(TipoArray tipoArray) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTipoBase(TipoBase tipoBase) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitSimples(Simples simples) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitIndexada(Indexada indexada) {
		// TODO Auto-generated method stub
		return null;
	}

}
