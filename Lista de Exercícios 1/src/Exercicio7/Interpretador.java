package Exercicio7;

public class Interpretador {
	
	private PilhaGenerica<Character> pilhaOperadores;
	private PilhaGenerica<Integer> pilhaNumerica;
	private String expressao;

	public Interpretador(String s) {
		expressao = s;
		pilhaOperadores = new PilhaGenerica<Character>(expressao.length());
		pilhaNumerica = new PilhaGenerica<Integer>(expressao.length());
	}
	
	
	public boolean interpretaExpressao() 
	{
		char c ='\0';
		
		for(int i=0; i<expressao.length();i++) {
			
			c = expressao.charAt(i);
			if(c == '(') pilhaOperadores.push(c);
			else if(Character.isDigit(c)) pilhaNumerica.push(Character.getNumericValue(c));
			else if(c=='+'||c=='-'||c=='*'||c=='/') pilhaOperadores.push(c);
			
			else if(c == ')') {
				char op = pilhaOperadores.pop();
				int resultado;
				
				int n2 = pilhaNumerica.pop(), n1 = pilhaNumerica.pop();
				
				if(pilhaOperadores.pop() == '(') {
					
					switch(op) {
					case '+':
					resultado = n1 + n2;
					pilhaNumerica.push(resultado);
					break;
					
					case '-':
					resultado = n1 - n2;
					pilhaNumerica.push(resultado);
					break;
					
					case '*':
					resultado = n1 * n2;
					pilhaNumerica.push(resultado);
					break;
					
					case '/':
					resultado = n1 / n2;
					pilhaNumerica.push(resultado);
					break;
					}
				}
				else return false;

			}
				
			else return false;
		}
		
		if(pilhaNumerica.vazia()) return false;
		else return true;
		
	}
	
	public int retornaResultado() {
		return pilhaNumerica.pop();
	}
}
