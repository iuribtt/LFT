package expressionList;

import java.util.Map;

import expression.Exp;

public class SingleExpList extends ExpList {

	public Exp exp;
	
	public SingleExpList(Exp e) {
		exp = e;
	}

	@Override
	public String toString() {
		return exp.toString();
	}


	@Override
	public int execute(Map<String, Integer> memory) {
	
		return exp.evaluate(memory);
	}

}