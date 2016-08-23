package ambiente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TabelaSimbolos {

	//Map<String, Object> memoria; 

	//Adicionar uma pilha para adicionar as variaveis
	Stack< HashMap<String, Object>> pilha; // pilhas com as declarações das variaveis do escopo

	//E uma Lista encadeada para interagir com o pop do 
	public TabelaSimbolos() {

	//	memoria = new HashMap<String, Object>();//Memoria 
		pilha = new Stack< HashMap<String, Object>>();
	}

	public Object put(String key, Object value) {

		return pilha.peek().put(key, value);
		 // return memoria.put(key, value);

	}

	public Object get(Object key) {

		return pilha.peek().get(key);
		//return memoria.get(key);

	}

	public void beginScope(){
		//adiciona as variaveis quando comeca o "{" e adiciona as variaveis na pilha
		pilha.push(new HashMap<String, Object>());

	}

	public void endScope(){
		//remove as variaveis da memoria e da pop na pilha

		HashMap<String, Object> variaveis = pilha.pop();//remove da pilha

		/*for(String variavel: variaveis){//remove da memoria
			memoria.remove(variavel);
		}*/

	}

}