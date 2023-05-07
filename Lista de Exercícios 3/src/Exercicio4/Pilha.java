package Exercicio4;
public class Pilha
{
	private int n;
	private int vetor[];
	private int topo;
	private int pares;
	
	public Pilha()
	{
		n = 10;
		vetor = new int[n];
		topo = -1;
		pares = 0;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new int[tamanho];
		topo = -1;
		pares = 0;
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
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elemento = vetor[topo];
			
			if(elemento%2==0)
				pares--;
			//Decrementando o topo, o elemento é "removido"
			topo--;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha vazia: pop não funcionou.");
		}
		
		return elemento;
	}
	
	public boolean push(int elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			
			if(elemento%2==0)
				pares++;
			
			return true;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha cheia: push não funcionou.\n");
			return false;
		}
	}
	
	public int retornaTopo()
	{
		int elemento = Integer.MIN_VALUE;

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

	public int contaPares() {
		return pares;
	}

}