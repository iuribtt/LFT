package memory;


import java.util.Map;

import expression.Exp;

public class Memory extends Exp{
	
	public void update(Map<String, Integer> hash, String id, int valor){
		hash.put(id, valor);

		
	}
	
	public int lookup(Map<String, Integer> hash, String id){

		return hash.get(id);
	}

	@Override
	public int evaluate(Map<String, Integer> memory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
