package Exercicio5;

public class Pilha
{
	private int n;
	private char vetor[];
	private int topo;
	
	public Pilha()
	{
		n = 10;
		vetor = new char[n];
		topo = -1;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
		topo = -1;
	}
	
	public boolean vazia()
	{
		return topo == -1 ? true : false;
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public char pop()
	{
		char c = '\0';
		
		if (!this.vazia())
		{
			c = vetor[topo];
			
			//Decrementando o topo, o elemento é "removido"
			topo--;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha vazia: pop não funcionou.");
		}
		
		return c;
	}
	
	public boolean push(char elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			return true;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha cheia: push não funcionou.\n");
			return false;
		}
	}
	
	public char retornaTopo()
	{
		char elemento = '\0';

		if(!this.vazia())
		{
			elemento = vetor[topo];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}
	
	public boolean verificaSequencia(String sequencia) 
	{
		char c = '\0';
		for(int i=0; i<sequencia.length(); i++)
		{
			c = sequencia.charAt(i);
			
			switch(c) {
			case '{':
			case '[':
			case '(':
				this.push(c);
				break;
			
			case '}':
				if(this.vazia()) return false;
				else {
					char elemento = this.pop();
					if(elemento != '{') return false;
				}
				break;
				
			case ']':
				if(this.vazia()) return false;
				else {
					char elemento = this.pop();
					if(elemento != '[') return false;
				}
				break;
			
			case ')':
				if(this.vazia()) return false;
				else {
					char elemento = this.pop();
					if(elemento != '(') return false;
				}
				break;
			}
		}
		
		if(this.vazia())
			return true;
		else
			return false;
	}
}