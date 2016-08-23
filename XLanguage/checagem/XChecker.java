package checagem;
import sintaxeAbstrata.*;
import visitor.XVisitor;


class XChecker implements XVisitor  {

	TabelaSimbolos<String, VinculavelConsVar> ambienteVars =
	       new TabelaSimbolos<...>();

	HashMap<String,VinculavelFunProc> ambienteSub = new HashMap<...>();

	RegistroDeErros erro = new RegistroErros(); // Implementar com uma lista, por simplicidade
	    ...

	public Object visitDecVar(DecVar decVar) {
	  decVar.dvar.accept(this);
	  return null;
	}

	public Object visitDVar(DVar dVar) {
		try
			ambienteVars.put(dVar.id, new Var(tipoSemantico(dVar.tipo));
		catch (AlreadyBound exc) {
			erro.add(dVar.id + "repetidamente declarado");
		}
		return null;
	}

    public Object visitBinExp (BinExp exp) {
	   if ( exp.bop == BinOp.Som ||
	        exp.bop == BinOp.Mul ||
		   ... ) {
	      Type tleft = (Type) exp.left.accept(this);
		  Type tright = (Type) exp.right.accept(this);
		  if (tleft == TBase.Int && tright == TBase.Int)
              return TBase.Int;
          else if (tleft == TBase.Real && tright == TBase.Real)
              return TBase.Real;
		  else if (tleft == TBase.Int && tright == TBase.Real)
              exp.left = new IntToReal(exp.left); // IntToReal � mais uma classe na sintaxe abstrata das express�es
			  return TBase.Real;
		  else if (tleft == TBase.Int && tright == TBase.Real)
              ...
		  else {
			erro.add("tipos incompat�veis na soma");
			return TBase.Int; // recupera��o de erro, continua a checagem
                              // por que n�o TBase.Real?
		  }
	   } else if ( exp.bop == BinOp.E ||
	               exp.bop == BinOp.Ou ) {
		  ...
	  } else if ...
	  ...
    }

	...

	public Object visitVarExp(VarExp ve) {
		ve.var.accept(this); // m�todos como este poderiam esta definidos na classe abstrata visitor
	}

	public Object visitSimples(Simples vs) {
		VinculavelVarCons vinc = ambienteVars.get(vs.id);
		if (vinc == null) {
			erro.add("vari�vel " + vs.id + " n�o declarada");
			return ?? // Uma solu��o: definir um tipo void que � subtipo de todo tipo
			          // e devolver ele.
		} else
			return vinc.type; // O campo type deve estar na superclasse
	}

	...

	public Object visitAssign(Assign stm) {
	    Type tyLeft = (Type) stm.var.accept(this);
	    Type tyRight = (Type) stm.exp.accept(this);
	    if (tyLeft.equivalente(tyRight)) // definir equivalente
           error.add(....);
        else {
            if (stm.var instanceof Simples) {
                String id = ((Simples) stm.var).id;
            else
                String id = getId((Indexada) stm.var); // definir esta fun��o
            }
            VinculavelVarCons vinc = ambienteVars.get(vs.id);
            if (vinc instanceof Cons)
                error.add(...);
        return null;
	}
		
	...
	
	public Object visitChamada(Chamada stm) {
		VinculavelSub vinc = ambienteSub.get(stm.id);
		if (vinc == null)
			error.add(... procedimento n�o declarado ....);
		else if (vinc instanceof Fun)
			error.add(... chamando fun ao inv�s de proced ...);
		else {
			Proc proc = (Proc) vinc;
			... checar que os par�metros reais tem tipos equivalentes
			    com os par�metros formais e se o par�metro foi declarado
				por refer�ncia, o correspondente par. real � uma vari�vel ...
		}
		return null;
	}
	
	public visitBloco(Bloco stm) {
		ambienteVars.beginScope();
		for (DVarConsCom d : stm.decsAndStms)
			d.accept(this);
		ambienteVars.endScope();
	}
	
	//declara��o de procedimento
	public Object visitProcedimento(Procedimento pDec) {
		se pDec.id j� foi declarado ==> error
		adicionar cabe�alho de pDec em ambienteSub
		ambienteVars.beginScope();
		... elabora decls dos par�metros formais pDec.formais
		pDec.body.accept(this);
		ambienteVars.endScope();
	}
	
	//Aceita chamadas Recursivas??
	//E chamadas mutuamente recursivas??
}


/*
	Defini��o da linguagem
		- Dois ambientes independentes
		- constantes arrays n�o permitem modifica��o parcial nem total.
*/
