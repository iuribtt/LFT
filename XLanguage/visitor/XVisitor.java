package visitor;

import sintaxeAbstrata.*;

public interface XVisitor {
	
	//Comando
	Object visitAssign(Assign assign);
	Object visitBloco(Bloco bloco);
	Object visitChamanda(Chamada chamada);
	Object visitIF(IF i);
	Object visitWHILE(WHILE w);
	
	//DCons
	Object visitCons(Cons cons);
	Object visitConsComp(ConsComp consComp);
	Object visitConsExt(ConsExt consExt);
	
	//Dec
	Object visitDecCons(DecCons dCons);
	Object visitDecVar(DecVar dVar);
	Object visitFuncao(Funcao funcao);
	Object visitProcedimento(Procedimento procedimento);
	
	//DVar
	Object visitVarInic(VarInic varInic);
	Object visitVarInicComp(VarInicComp varInicComp);
	Object visitVarInicExt(VarInicExt varInicExt);
	Object visitVarNaoInic(VarNaoInic varNaoInic);
	
	//DVarConsCon
	Object visitCom(Com com);
	Object visitDC(DC dc);
	Object visitDV(DV dv);
	
	//Exp
	Object visitBinExp(BinExp binExp);
	Object visitBlocoExp(BlocoExp blocoExp);
	Object visitChamadaExp(ChamadaExp chamadaExp);
	Object visitLiteralBool(LiteralBool literalBool);
	Object visitLiteralInt(LiteralInt literalInt);
	Object visitMenos(Menos menos);
	Object visitNao(Nao nao);
	Object visitVarExp(VarExp varExp);
	
	//Parametro
	Object visitParArrayCopia(ParArrayCopia parArrayCopia);
	Object visitParArrayRef(ParArrayRef parArrayRef);
	Object visitParBaseCopia(ParBaseCopia parBaseCopia);
	Object visitParBaseRef(ParBaseRef parBaseRef);
	
	//Programa
	Object visitPrograma(Programa programa);
	
	//Tipo
	Object visitTipoArray(TipoArray tipoArray);
	Object visitTipoBase(TipoBase tipoBase);
	
	//Var
	Object visitSimples(Simples simples);
	Object visitIndexada(Indexada indexada);

}
