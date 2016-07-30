package expression;

import java.util.Map;

public class NumExp extends Exp {

	public int num;

	public NumExp(int n) {
		num = n; 
	}

	@Override
	public String toString() {
		return num + "";
	}

	@Override
	public int evaluate(Map<String, Integer> memory) {
		return num;
	}

}