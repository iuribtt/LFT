package ambiente;

import java.util.HashMap;
import java.util.Map;

public class Symbol { 
	
	private String name;
	private int hashCd;
	
	private static Map<String,Symbol> dict = new HashMap<String,Symbol>();

	private Symbol (String n) {
		name=n; hashCd = hashcode_();
	} 

	public String toString() {
		return name; 
	} 

	public static Symbol symbol(String n) {
		
		Symbol s = dict.get(n); 
		
		if (s==null) {
			
			s = new Symbol(n);
			
			dict.put(n,s);
			
		} 
		
		return s; 

	} 

	private int hashcode_() {

		return hashCd; /*....*/
	} 

	public int hashcode () { 

		return hashCd; 
	} 
}
