package expression;

import java.util.Map;

import statment.Stm;

public class StmExp extends Exp {
	public Stm stm;
	public Exp exp;

	public StmExp(Stm s,Exp e) {
		stm = s; exp = e; 
	}

	@Override
	public String toString() {
		return "(" + stm.toString() + " " + exp.toString()+ ")";	
	}

	@Override
	public int evaluate(Map<String, Integer> memory) {
		//Ex: a:= print(y+5,s),b+9
		stm.interpret(memory);//execulta os efeitos colateria de print(y+5,s)
		
		return exp.evaluate(memory);//b+9	
		
	}
	
}