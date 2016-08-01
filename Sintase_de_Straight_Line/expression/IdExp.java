package expression;

import java.util.HashMap;
import java.util.Map;

public class IdExp extends Exp {
	
	public String id;
	
	public IdExp(String i) { id = i; }

	@Override
	public String toString() {
		return id + "";
	}

	@Override
	public int evaluate(Map<String, Integer> memory) {

		return memory.get(id);
		
	}
	

	
}	