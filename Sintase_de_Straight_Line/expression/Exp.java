package expression;

import java.util.Map;

import statment.Stm;

public abstract class Exp {
	
	public abstract int evaluate(Map<String, Integer> memory);
		
	public abstract String toString();
		
}
	