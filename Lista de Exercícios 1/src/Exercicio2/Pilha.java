package Exercicio2;

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
			topo--;
		}
		else
		{
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


	public boolean verificaSubString(String s) {
		
		Pilha aux = new Pilha(s.length());
		char c = this.pop();
		int meio=0;
		
		while(c!='C') {
			
			if(c!='A'&&c!='B')
				return false;
			
			else {
				aux.push(c);
				c = this.pop();
				meio++;
			}
		}
		
		for(int i=0; i<meio; i++) {
	
			if(this.vazia() || aux.vazia())
				return false;
			
			if(this.pop()!=aux.pop())
				return false;
		}
		
		if(!this.vazia() || !aux.vazia())
			return false;
		
		return true;
	}
	
	public boolean verificaString(String s) {
		
		char c;
		int qtd_D=0;
		
		for(int i=0;i<s.length();i++) {
			c=s.charAt(i);
			
			if(c!='D')
				this.push(c);
			
			else{
				qtd_D++;
				if(!this.verificaSubString(s))
					return false;
			}
			
			if(i==s.length()-1)
				if(!this.verificaSubString(s))
					return false;
		}
		
		if(qtd_D==0)
			return false;
		
		return true;
	}
	
}