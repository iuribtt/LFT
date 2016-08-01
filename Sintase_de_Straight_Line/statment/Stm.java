package statment;

import java.util.Map;



public abstract class Stm {
	
	public abstract String toString();
	
	public abstract void interpret(Map<String, Integer> memory);
	
}



