package statment;

import java.util.Map;

import expressionList.ExpList;

public class PrintStm extends Stm {
	
	public ExpList exps;
	
	public PrintStm(ExpList es) { exps = es; }

	@Override
	public String toString() {
		return "print(" + exps.toString() + ")";
	}

	@Override
	public void interpret(Map<String, Integer> memory) {

		System.out.println( exps.execute(memory));
	}
	
}
