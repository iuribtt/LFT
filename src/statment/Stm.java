package statment;

import visitor.SLPrinter;
import visitor.SLVisitor;


public abstract class Stm {
	
	abstract Object accept(SLVisitor visitor);
	
	abstract Object print(SLPrinter print);
	 
}



