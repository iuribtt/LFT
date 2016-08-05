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

public class Checador implements XVisitor{

	public Object visitAssign(Var var, Exp exp) {
		
		return null;
	}

	public Object visitBloco(List<DVarConsCom> dVarConsComs) {
		
		return null;
	}

	public Object visitChamanda(ID id, List<Exp> exps) {
		
		return null;
	}

	public Object visit(Exp exp, Comando esquerda, Comando direita) {
		
		return null;
	}

	public Object visit(Exp exp, Comando comando) {
		
		return null;
	}

	public Object visit(Tipo tipo, ID id, Exp exp) {
		
		return null;
	}

	public Object visit(Tipo tipo, ID id, List<ID> ids, Exp exp) {
		
		return null;
	}

	public Object visitConsExt(Tipo tipo, ID id, List<Exp> exps) {
		
		return null;
	}

	public Object visitDCons(DCons dCons) {
		
		return null;
	}

	public Object visitDecVar(DVar dVar) {
		
		return null;
	}

	public Object visitFuncao(Tipo tipo, ID id, List<Parametro> parametros, Comando comando) {
		
		return null;
	}

	public Object visitProcedimento(ID id, List<Parametro> parametros, Comando comando) {
		
		return null;
	}

	public Object visitVarInic(Tipo tipo, ID id, Exp exp) {
		
		return null;
	}

	public Object visitVarInicComp(Tipo tipo, ID id, List<ID> ids, Exp exp) {
		
		return null;
	}

	public Object visitVarInicExt(Tipo tipo, ID id, List<Exp> exps) {
		
		return null;
	}

	public Object visitVarNaoInic(Tipo tipo, ID id) {
		
		return null;
	}

	public Object visitCom(Comando comando) {
		
		return null;
	}

	public Object visitDC(DCons dCons) {
		
		return null;
	}

	public Object visitDV(DVar dVar) {
		
		return null;
	}

	public Object visitBinExp(BinOp operador, Exp esquerda, Exp direita) {
		
		return null;
	}

	public Object visitBlocoExp(List<DCons> cons, Exp exp) {
		
		return null;
	}

	public Object visitChamadaExp(ID id, List<Exp> exps) {
		
		return null;
	}

	public Object visitLiteralBool(boolean b) {
		
		return null;
	}

	public Object visitLiteralInt(int i) {
		
		return null;
	}

	public Object visitMenos(Exp exp) {
		
		return null;
	}

	public Object visitNao(Exp exp) {
		
		return null;
	}

	public Object visitVarExp(Var var) {
		
		return null;
	}

	public Object visitParArrayCopia(TBase tBase, int dimensao, ID id) {
		
		return null;
	}

	public Object visitParArrayRef(TBase tBase, int dimensao, ID id) {
		
		return null;
	}

	public Object visitParBaseCopia(TBase tBase, ID id) {
		
		return null;
	}

	public Object visitParBaseRef(TBase tBase, ID id) {
		
		return null;
	}

	public Object visitPrograma(List<Dec> decs) {
		
		return null;
	}

	public Object visitTipoArray(TBase tBase, List<Exp> exps) {
		
		return null;
	}

	public Object visitTipoBase(TBase tBase) {
		
		return null;
	}

	public Object visitID(String id) {
		
		return null;
	}

	public Object visitIDIndexada(Var var, Exp exp) {
		
		return null;
	}

}
