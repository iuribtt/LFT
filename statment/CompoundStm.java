package statment;

import java.util.Map;

public class CompoundStm extends Stm {

	public Stm stm1,stm2;

	public CompoundStm(Stm s1, Stm s2) { 
		stm1=s1; stm2=s2; 
	}

	@Override
	public String toString() {
		return stm1.toString() + " " + stm2.toString();
	}

	@Override
	public void interpret(Map<String, Integer> memory) {
		
		stm1.interpret(memory);
		stm2.interpret(memory);
		

	}

}