package visitor;

import java.util.List;

import binOp.BinOp;
import comando.Comando;
import dVar.DVar;
import dVarConsCom.DVarConsCom;
import dec.DCons;
import dec.Dec;
import exp.Exp;
import parametro.Parametro;
import tBase.TBase;
import tipo.Tipo;
import var.ID;
import var.Var;

public interface XVisitor {
	
	//Comando
	Object visitAssign(Var var, Exp exp);
	Object visitBloco(List<DVarConsCom> dVarConsComs);
	Object visitChamanda(ID id, List<Exp> exps);
	Object visit(Exp exp, Comando esquerda, Comando direita);
	Object visit(Exp exp, Comando comando);
	
	//DCons
	Object visit(Tipo tipo, ID id, Exp exp);
	Object visit(Tipo tipo, ID id, List<ID> ids, Exp exp);
	Object visitConsExt(Tipo tipo, ID id, List<Exp> exps);
	
	//Dec
	Object visitDCons(DCons dCons);
	Object visitDecVar(DVar dVar);
	Object visitFuncao(Tipo tipo, ID id, List<Parametro> parametros, Comando comando);
	Object visitProcedimento(ID id, List<Parametro> parametros, Comando comando);
	
	//DVar
	Object visitVarInic(Tipo tipo, ID id, Exp exp);
	Object visitVarInicComp(Tipo tipo, ID id, List<ID> ids, Exp exp);
	Object visitVarInicExt(Tipo tipo, ID id, List<Exp> exps);
	Object visitVarNaoInic(Tipo tipo, ID id);
	
	//DVarConsCon
	Object visitCom(Comando comando);
	Object visitDC(DCons dCons);
	Object visitDV(DVar dVar);
	
	//Exp
	Object visitBinExp(BinOp operador, Exp esquerda, Exp direita);
	Object visitBlocoExp(List<DCons> cons, Exp exp);
	Object visitChamadaExp(ID id, List<Exp> exps);
	Object visitLiteralBool(boolean b);
	Object visitLiteralInt(int i);
	Object visitMenos(Exp exp);
	Object visitNao(Exp exp);
	Object visitVarExp(Var var);
	
	//Parametro
	Object visitParArrayCopia(TBase tBase, int dimensao, ID id);
	Object visitParArrayRef(TBase tBase, int dimensao, ID id);
	Object visitParBaseCopia(TBase tBase, ID id);
	Object visitParBaseRef(TBase tBase, ID id);
	
	//Programa
	Object visitPrograma(List<Dec> decs);
	
	//Tipo
	Object visitTipoArray(TBase tBase, List<Exp> exps);
	Object visitTipoBase(TBase tBase);
	
	//Var
	Object visitID(String id);
	Object visitIDIndexada(Var var, Exp exp);

	
	
}
