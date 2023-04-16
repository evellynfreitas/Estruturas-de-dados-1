public class Ex2 {

	private PilhaGenerica<Character> pilha;
	private String s;
	
	public Ex2(String entrada){
		
		s = entrada;
		pilha = new PilhaGenerica<Character>(s.length());
	}
	
	public boolean verificaSubString() {
		
		PilhaGenerica<Character> aux = new PilhaGenerica<Character>(s.length());
		char c = pilha.pop();
		int meio=0;
		
		while(c!='C') {
			
			if(c!='A'&&c!='B')
				return false;
			
			else {
				aux.push(c);
				c = pilha.pop();
				meio++;
			}
		}
		
		for(int i=0; i<meio; i++) {
	
			if(pilha.vazia() || aux.vazia())
				return false;
			
			if(pilha.pop()!=aux.pop())
				return false;
		}
		
		if(!pilha.vazia() || !aux.vazia())
			return false;
		
		return true;
	}
	
	public boolean verificaString() {
		
		char c;
		int qtd_D=0;
		
		for(int i=0;i<s.length();i++) {
			c=s.charAt(i);
			
			if(c!='D')
				pilha.push(c);
			
			else{
				qtd_D++;
				if(!verificaSubString())
					return false;
			}
			
			if(i==s.length()-1)
				if(!verificaSubString())
					return false;
		}
		
		if(qtd_D==0)
			return false;
		
		return true;
	}
	
}
