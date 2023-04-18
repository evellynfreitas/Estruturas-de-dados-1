package Exercicio8;

public class Pilha
{
	private int n;
	private int vetor[];
	private int topo;
	
	public Pilha()
	{
		n = 10;
		vetor = new int[n];
		topo = -1;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new int[tamanho];
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
	
	public int pop()
	{
		int c = -1;
		
		if (!this.vazia())
		{
			c = vetor[topo];
			
			//Decrementando o topo, o elemento  "removido"
			topo--;
		}
		else
		{
			//Impressao para fins didaticos
			System.out.println("Pilha vazia: pop nao funcionou.");
		}
		
		return c;
	}
	
	public boolean push(int elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
      //++topo -> incrementa antes de usar a variável || topo++ usa a variavel e só depois incrementa
			return true;
		}
		else
		{
			//Impressao para fins didaticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
	public int retornaTopo()
	{
		int elemento = -1;

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
	
	public void imprimeParesUnicos(int vetor[], int n) {
		
		for (int i=0; i<n; i++)
			this.push(vetor[i]);
        
		while(!this.vazia()) {
			int a = this.pop();
			int b = this.pop();
			
			
			if(a!=b)
				System.out.println("("+a+","+b+")");
			
			if(!this.vazia())
				this.push(b);
		}
		
		
	}
}