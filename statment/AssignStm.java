package statment;

import java.util.Map;

import expression.Exp;
import expression.NumExp;

public class AssignStm extends Stm {

	public String id;
	public Exp exp;

	public AssignStm(String i, Exp e){
		id = i; exp = e; 
	}
	//criado

	@Override
	public String toString() {
		return id + " := " + exp.toString() + ";";		
	}
	@Override
	public void interpret(Map<String, Integer> memory) {

		memory.put(id, exp.evaluate(memory));
	
	}



}