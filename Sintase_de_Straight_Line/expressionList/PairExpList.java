package expressionList;

import java.util.Map;

import expression.Exp;
import expression.IdExp;

public class PairExpList extends ExpList {

	public Exp head;
	public ExpList tail;

	public PairExpList(Exp e, ExpList l){
		head=e; tail = l; 
	}

	@Override 	
	public String toString() {
		return  head.toString()+", "+ tail.toString();
	}

	@Override
	public int execute(Map<String, Integer> memory) {
		head.evaluate(memory);/*+ ???*/ tail.execute(memory);
		return 0;//TODO Dúvida
		/*head.evaluate(memory);
		tail.execute(memory);*/
			
	}


}