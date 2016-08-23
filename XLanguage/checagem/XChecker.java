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
              exp.left = new IntToReal(exp.left); // IntToReal é mais uma classe na sintaxe abstrata das expressões
			  return TBase.Real;
		  else if (tleft == TBase.Int && tright == TBase.Real)
              ...
		  else {
			erro.add("tipos incompatíveis na soma");
			return TBase.Int; // recuperação de erro, continua a checagem
                              // por que não TBase.Real?
		  }
	   } else if ( exp.bop == BinOp.E ||
	               exp.bop == BinOp.Ou ) {
		  ...
	  } else if ...
	  ...
    }

	...

	public Object visitVarExp(VarExp ve) {
		ve.var.accept(this); // métodos como este poderiam esta definidos na classe abstrata visitor
	}

	public Object visitSimples(Simples vs) {
		VinculavelVarCons vinc = ambienteVars.get(vs.id);
		if (vinc == null) {
			erro.add("variável " + vs.id + " não declarada");
			return ?? // Uma solução: definir um tipo void que é subtipo de todo tipo
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
                String id = getId((Indexada) stm.var); // definir esta função
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
			error.add(... procedimento não declarado ....);
		else if (vinc instanceof Fun)
			error.add(... chamando fun ao invés de proced ...);
		else {
			Proc proc = (Proc) vinc;
			... checar que os parâmetros reais tem tipos equivalentes
			    com os parâmetros formais e se o parâmetro foi declarado
				por referência, o correspondente par. real é uma variável ...
		}
		return null;
	}
	
	public visitBloco(Bloco stm) {
		ambienteVars.beginScope();
		for (DVarConsCom d : stm.decsAndStms)
			d.accept(this);
		ambienteVars.endScope();
	}
	
	//declaração de procedimento
	public Object visitProcedimento(Procedimento pDec) {
		se pDec.id já foi declarado ==> error
		adicionar cabeçalho de pDec em ambienteSub
		ambienteVars.beginScope();
		... elabora decls dos parâmetros formais pDec.formais
		pDec.body.accept(this);
		ambienteVars.endScope();
	}
	
	//Aceita chamadas Recursivas??
	//E chamadas mutuamente recursivas??
}


/*
	Definição da linguagem
		- Dois ambientes independentes
		- constantes arrays não permitem modificação parcial nem total.
*/
