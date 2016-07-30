import java.util.HashMap;
import java.util.Map;

import statment.AssignStm;
import statment.CompoundStm;
import statment.PrintStm;
import statment.Stm;
import expression.ExpMinus;
import expression.NumExp;
import expression.ExpPlus;
import expression.ExpTimes;
import expression.IdExp;
import expression.StmExp;
import expressionList.PairExpList;
import expressionList.SingleExpList;


public class Main {

	public static void main(String[] args) {
		
		
		//5 + 4
		System.out.println(new ExpPlus(new NumExp(5), new NumExp(4))); 
		
		//a := 5 + 4
		System.out.println(new AssignStm("a",
				new ExpPlus(new NumExp(5), new NumExp(4)))); 
		
		//b := 5 + 4
		System.out.println(new AssignStm("b",
				new ExpTimes(new NumExp(5), new NumExp(4)))); 
			
		//b := (print(a, a-1), 10*a)
		System.out.println(
				//b :=
				new AssignStm("b",
				new StmExp(
				//print(a, a-1) 
				new PrintStm(new PairExpList(new IdExp("a"),
				//a-1		
				new SingleExpList(new ExpMinus(new IdExp("a"), new NumExp(1))) 
				)//PairExpression
				),//PrintStm
				//10*a)
				new ExpTimes(new NumExp(10), new IdExp("a")))
		)); 
		
		System.out.println();
		
		/**Interpreter  Straight-line *************************************************************/
		System.out.println("********Interpretador***********");
		System.out.println();
		
		Map memory= new HashMap<String, Integer>();//Memoria 
		
		// x:= 4+5
		 new AssignStm("x", new NumExp(
				new ExpPlus(new NumExp(5), new NumExp(4)).evaluate(memory))).interpret(memory); 
			
		// print(x)
		System.out.print("print(x) -> ");
		new PrintStm(new SingleExpList(new IdExp("x"))).interpret(memory);

		
		// y:= x+1
		 
		new AssignStm("y", new NumExp(
				new ExpPlus(new NumExp((Integer)memory.get("x")), new NumExp(1)).evaluate(memory))).interpret(memory);
		System.out.print("y:= x+1 -> y = " + memory.get("y"));
		
		System.out.println();
		// print(y)
		System.out.println("print(y) -> " +  memory.get("y")); //new PrintStm(new SingleExpList(new IdExp("y")))
			
		//print(y, y-1)
		new PrintStm(new PairExpList(new IdExp("y"), new SingleExpList(new ExpPlus(new IdExp("y"), new NumExp(1))))).interpret(memory);
		System.out.println( "print(y, y + 1) -> " + memory.get("y") );//new PrintStm(new PairExpList(new IdExp("y"), new SingleExpList(new ExpPlus(new IdExp("y"), new NumExp(1)))))
		
		
	}

}
