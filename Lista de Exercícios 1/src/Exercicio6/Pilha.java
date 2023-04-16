package Exercicio6;

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
	
	public String inverteFrase(String frase) 
	{
		String invertida="";
		
		for(int i=0; i<frase.length(); i++) {
			char c = frase.charAt(i);
			
			if(c!=' ') this.push(c);
			
			if(c == ' '||i==frase.length()-1) {
				while(!this.vazia())
					invertida+=this.pop();
			
				invertida += " ";
			}
		}
		
		
		return invertida;
	}


}