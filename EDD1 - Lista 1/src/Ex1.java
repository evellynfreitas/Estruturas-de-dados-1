public class Ex1 {

	private PilhaGenerica<Character> pilha;
	private String s;
	
	public Ex1(String entrada){
		
		s = entrada;
		pilha = new PilhaGenerica<Character>(s.length());
	}
	
	public boolean verificaStrings() {
		
		PilhaGenerica<Character> aux = new PilhaGenerica<Character>(s.length());
		char c = pilha.pop();
		while(c!='C') {
			aux.push(c);
			c = pilha.pop();
		}
		
		while(!pilha.vazia() && !aux.vazia()) {
			if(pilha.pop() != aux.pop())
				return false;
		}
		
		return true;
	}
	
	
	public boolean enchePilha() {
		
		if(s.length()/2==0)
			return false;
		
		char c;
		int meio = s.length()/2;
		
		for(int i=0; i<s.length();i++) {
			c = s.charAt(i);
			
			if(c!='A' && c!='B' && i!=meio)
				return false;
			else if(i==meio&&c!='C')
				return false;
			else
				pilha.push(c);
		}
		
		return true;
	}
	
}
