package expression;

import java.util.Map;

public class ExpTimes extends Exp {

	public Exp left, right;

	public ExpTimes(Exp l, Exp r) {
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return left.toString() + " * " + right.toString();
	}

	@Override
	public int evaluate(Map<String, Integer> memory) {
		return left.evaluate(memory) * right.evaluate(memory);
	}

}
